package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.FilmeDao;
import Dao.UsuarioDao;
import Model.Filme;
import Model.Usuario;

@WebServlet("/LoginAcess")
public class UsuarioLoginAcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioLoginAcess() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FilmeDao filmeDao = new FilmeDao();
		List<Filme> filmes = null;
		String pg = request.getParameter("pg");
		System.out.println("pg: " + pg);
		
		if (pg.equals("0")) {
			filmes = filmeDao.findMovies();
		}
		request.setAttribute("filmes", filmes);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsuarioDao us = new UsuarioDao();
		Usuario usuario = us.findByEmail(request.getParameter("email"));
		String senhaDigitada = request.getParameter("senha");

		if (usuario.getEmail() != null) {

			if (usuario.getSenha().equals(senhaDigitada)) {
				
				FilmeDao filmeDao = new FilmeDao();
				List<Filme> filmes = filmeDao.findMovies();
				
				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(3600);
				session.setAttribute("logado", "true");
				session.setAttribute("usuario", usuario);
				
				request.setAttribute("filmes", filmes);

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
				requestDispatcher.forward(request, response);

			} else {
				request.setAttribute("errolog", "senha errada");

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
				requestDispatcher.forward(request, response);
			}

		} else {
			request.setAttribute("errolog", "email não existe");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
