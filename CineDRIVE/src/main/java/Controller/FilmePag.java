package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.FilmeDao;
import Model.Filme;

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
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("telaFilme.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
