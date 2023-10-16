package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.FilmeDao;

/**
 * Servlet implementation class FilmeDelete
 */
@WebServlet("/FilmeDelete")
public class FilmeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FilmeDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int filmeId = Integer.parseInt(request.getParameter("filmeId"));
		FilmeDao filmeDao = new FilmeDao();
		filmeDao.delete(filmeId);
		
		// volta para a lista de clientes
		response.sendRedirect(request.getContextPath() + "/Perfil");
	}
	
}
