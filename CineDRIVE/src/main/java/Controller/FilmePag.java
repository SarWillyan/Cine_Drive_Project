package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AvaliacaoDao;
import Dao.FilmeDao;
import Dao.GeneroDao;
import Dao.GenerosFilmeDao;
import Dao.UploadDao;
import Dao.UsuarioDao;
import Model.Filme;
import Model.GenerosFilme;
import Model.Upload;
import Model.Usuario;

@WebServlet("/Filme")
public class FilmePag extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FilmePag() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recupera id do filme
		int id_filme = Integer.parseInt(request.getParameter("id"));
		
		// Capturando dados do filme
		FilmeDao filmeDao = new FilmeDao();
		Filme filme = filmeDao.findById(id_filme);
		// enviando dados do filme
		request.setAttribute("filme", filme);
		
		// Listando os generos do filme
		GenerosFilmeDao generosFilmeDao = new GenerosFilmeDao();
		// recebe os generos do filme 
		List<String> generos = generosFilmeDao.findGendersByMovie(id_filme);
		// envia os generos do filme
		request.setAttribute("generos", generos);
		
		// Recupera o usuário que postou o filme
		UploadDao uploadDao = new UploadDao();
		// pega o upload do filme
		Upload upload = uploadDao.findByMovieId(id_filme);
		// pega o usuário que fez o upload
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = usuarioDao.findById(upload.getId_usuario());
		// envia o nome do usuário
		request.setAttribute("uploaderName", usuario.getNome());
		
		// Recupera o número de votos 
		AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
		int votos = avaliacaoDao.countNumberOfVotes(id_filme);
		// envia o numero de votos
		request.setAttribute("votos", votos);
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("telaFilme.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
