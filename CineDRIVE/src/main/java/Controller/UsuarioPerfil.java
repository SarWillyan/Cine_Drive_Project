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
import Dao.UploadDao;
import Model.Upload;
import Model.Usuario;

@WebServlet("/Perfil")
public class UsuarioPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioPerfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Verifica se o usário está logado 
		HttpSession session = request.getSession(false);

		// Verifica se a sessão existe 
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/Find?pg=0"); 
		}
		 	
		
		// Carregando dados nescessários para a pagina do perfil
		Usuario usuario = (Usuario) session.getAttribute("usuario"); 
		UploadDao upDao = new UploadDao();
		FilmeDao filmeDao = new FilmeDao();
		List<Upload> uploads = upDao.findByUserId(usuario.getId());
		
		// ------------------------ informações do usuário ------------------------
		request.setAttribute("filmeDao", filmeDao); // Será usado para buscar o filme
		request.setAttribute("uploads", uploads); // lista de uploads do usuário
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("perfil.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
