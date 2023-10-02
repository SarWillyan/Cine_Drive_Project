package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.FilmeDao;
import Dao.GeneroDao;
import Model.Filme;
import Model.Genero;

@WebServlet("/Find")
public class FindPagesNavBar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindPagesNavBar() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Variáveis para guardar lista de filmes
		FilmeDao filmeDao = new FilmeDao();
		List<Filme> filmes = null;
		// Variáveis para guardar lista de generos
		GeneroDao generoDao = new GeneroDao();
		List<Genero> generos = null;
		
		// Captura a pagina atual
		String pg = request.getParameter("pg");
		System.out.println("pg: " + pg);

		// Escolhe a ação adequada para cada página
		if (pg.equals("0")) { // geral
			filmes = filmeDao.findMovies();
			
		} else if (pg.equals("1")) { // categorias
			generos = generoDao.find();
			request.setAttribute("generos", generos);
			filmes = filmeDao.findByGender("Ação");
			
		} else if (pg.equals("2")) { // topFilmes
			filmes = filmeDao.findTopMovies();
			
		}
		
		request.setAttribute("filmes", filmes);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
