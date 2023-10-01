package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UsuarioDao;
import Model.Usuario;

@WebServlet("/LoginAcess")
public class UsuarioLoginAcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioLoginAcess() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsuarioDao us = new UsuarioDao();
		Usuario usuario = us.findByEmail(request.getParameter("email"));
		String senhaDigitada = request.getParameter("senha");

		if (usuario.getEmail() != null) {

			if (usuario.getSenha().equals(senhaDigitada)) {
				
				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(10);
				session.setAttribute("logado", "true");
				//request.setAttribute("filmes", filmes);

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
