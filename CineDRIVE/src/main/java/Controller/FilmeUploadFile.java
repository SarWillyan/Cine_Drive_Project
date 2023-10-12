package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Dao.FilmeDao;
import Dao.GeneroDao;
import Dao.GenerosFilmeDao;
import Dao.UploadDao;
import Model.Filme;
import Model.Genero;
import Model.GenerosFilme;
import Model.Upload;
import Model.Usuario;

@WebServlet("/UploadFile")
@MultipartConfig
public class FilmeUploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FilmeUploadFile() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Obtém a sessão associada à solicitação atual, mas não a cria se ela não existir
        HttpSession session = request.getSession(false);

        if (session != null) {
        	if (session.getAttribute("usuario") != null) {
        		GeneroDao generoDao = new GeneroDao();
        		List<Genero> generos = null;
        		generos = generoDao.find();
        		request.setAttribute("generos", generos);
        		RequestDispatcher requestDispatcher = request.getRequestDispatcher("upload.jsp");
        		requestDispatcher.forward(request, response);
        	}else {
                // O usuário não existe
        		response.sendRedirect(request.getContextPath() + "/LogOut");
            }
        } else {
            // A sessão não existe
            response.sendRedirect(request.getContextPath() + "/LogOut");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1ª parte: inserir filme no banco de dados --------------------------------------------------------
		request.setCharacterEncoding("UTF-8");
		Filme filme = new Filme(); 
		FilmeDao filmedb = new FilmeDao(); 
		
		filme.setTitulo(request.getParameter("titulo").toString());
		filme.setAno( Integer.parseInt( request.getParameter("ano")) );
		filme.setImagem_url(request.getParameter("url_imagem")); 
		filme.setTempo(Integer.parseInt(request.getParameter("tempo")));
		filme.setSinopse(request.getParameter("sinopse").toString());

		filmedb.create(filme); // adiciona o filme ao BD

		
		// 2ª parte: buscar o filme inserido e adicioinar os --------------------------------------------------------
		// generos selecionado a ele
		int filme_id = filmedb.findLastMovie();
		
		// Váriaveis para inserção dos generos do filme
		GenerosFilme generosFilme = new GenerosFilme();
		GenerosFilmeDao generosFilmedb = new GenerosFilmeDao();
		GeneroDao generodb = new GeneroDao();
		
		List<Genero> generosExistentes = generodb.find();
		
		generosFilme.setId_filme(filme_id); //pega o filme
		// Lista os generos do filme que foram escolidos
		for (Genero genero : generosExistentes) {
			if (request.getParameter(genero.getNome()) != null){
				generosFilme.setGeneros(genero.getNome());				
			}
		}
		
		// Adiciona ao banco de dados esses generos ao filme
		generosFilmedb.create(generosFilme);
		
		// 3ª parte: adicionar o filme a tabela de uploads --------------------------------------------------------
		// e salvar o arquivo no servidor
		
		// Captura o nome do diretório do projeto
		ServletContext path = getServletContext(); 
		// Pega o caminho do projeto dentro do TomCat
		String pathTomcat = path.getRealPath("/"); 

		// Encontre a parte do caminho específica ao projeto excluino a parte do TomCat
		String projetoPath = pathTomcat.substring(0, pathTomcat.indexOf(".metadata"));

		// Inclui o diretório Videos ao caminho
		File vidiosDir = new File(projetoPath, "Videos");
		
		// Caso o diretório não exista, cria ele
		if (!vidiosDir.exists()) {
			vidiosDir.mkdir();
		}
		// Salva o arquivo no diretório
		String pathArqu = null;
		for (Part part : request.getParts()) {
			String fileName = part.getSubmittedFileName();
			part.write(vidiosDir + File.separator + fileName);
			pathArqu = vidiosDir + File.separator + fileName;
		}
		
		// Variáveis para a inserção na tabela de upload
		Upload upload = new Upload();
		UploadDao uploaddb = new UploadDao();
		Usuario usuario = (Usuario) request.getSession(false).getAttribute("usuario");
		 
		upload.setId_usuario(usuario.getId());
		upload.setId_filme(filme_id);
		upload.setVideo_path(pathArqu);
		
		uploaddb.create(upload);
		
		response.sendRedirect(request.getContextPath() + "/Find?pg=0");
		
	}

}
