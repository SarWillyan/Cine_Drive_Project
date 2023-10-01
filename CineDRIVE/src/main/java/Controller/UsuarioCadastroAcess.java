package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UsuarioDao;
import Model.Usuario;


@WebServlet("/CadastroAcess")
public class UsuarioCadastroAcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UsuarioCadastroAcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDao us = new UsuarioDao();
		Usuario usuario = us.findByEmail(request.getParameter("email"));
		
		if (usuario.getEmail() == null) {
			usuario.setNome(request.getParameter("nome"));
			usuario.setEmail(request.getParameter("email"));
			usuario.setSenha(request.getParameter("senha"));
			
			us.create(usuario);
		} else {
			request.setAttribute("erroCad", "email em uso");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
