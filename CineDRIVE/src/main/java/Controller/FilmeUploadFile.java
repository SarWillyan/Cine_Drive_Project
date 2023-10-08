package Controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.FilmeDao;
import Model.Filme;

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
        	RequestDispatcher requestDispatcher = request.getRequestDispatcher("upload.jsp");
    		requestDispatcher.forward(request, response);
        } else {
            // A sessão não existe
            response.getWriter().println("A sessão não existe.");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * // Obtém o diretório de trabalho atual ServletContext path =
		 * getServletContext(); // Pega o dirtório do projéto lá do .metadata do Tomcat
		 * String pathTomcat = path.getRealPath("/");
		 * 
		 * // Encontre a parte do caminho específica ao projeto String projetoPath =
		 * pathTomcat.substring(0, pathTomcat.indexOf(".metadata"));
		 * 
		 * // Verifica se o diretório atual contém o diretório File vidiosDir = new
		 * File(projetoPath, "Videos");
		 * response.getWriter().println("Diretório de videos: " +
		 * vidiosDir.getAbsolutePath());
		 * 
		 * if (vidiosDir.exists() && vidiosDir.isDirectory()) { // O diretório
		 * 'WebContent' existe no diretório atual, // portanto, consideramos este
		 * diretório como o diretório do projeto String diretorioDoProjeto =
		 * vidiosDir.getAbsolutePath();
		 * response.getWriter().println("Diretório do projeto: " + diretorioDoProjeto);
		 * } else { response.getWriter().
		 * println("Não foi possível determinar o diretório do projeto."); }
		 */
		
		// 1ª parte: inserir filme no banco de dados
		Filme filme = new Filme();
		filme.setTitulo(request.getParameter("titulo"));
		filme.setAno( Integer.parseInt( request.getParameter("ano")) );
		filme.setImagem_url(request.getParameter("url_imagem"));
		filme.setTempo( Integer.parseInt(request.getParameter("tempo")));
		filme.setSinopse(request.getParameter("sinopse"));
		
		FilmeDao filmedb = new FilmeDao();
		filmedb.create(filme);
		

	}

}
