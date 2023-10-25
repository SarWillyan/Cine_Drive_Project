package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ComentarioDao;
import Model.Comentario;
import Model.Usuario;

/**
 * Servlet implementation class ComentárioAddComent
 */
@WebServlet("/AddComent")
public class ComentarioAddComent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ComentarioAddComent() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("logado") != null) {
			
			ComentarioDao comentarioDao = new ComentarioDao();
			Comentario comentario = new Comentario();
			
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			
			int id_filme = Integer.parseInt(request.getParameter("filme_id_coment"));
			int id_usuario = usuario.getId();
			
			comentario.setId_filme(id_filme);
			comentario.setId_usuario(id_usuario);
			comentario.setComentario(request.getParameter("comentarioUsuario"));
			
			comentarioDao.create(comentario);
			
			response.sendRedirect(request.getContextPath() + "/Filme?id=" + id_filme);
		} else {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}

}
