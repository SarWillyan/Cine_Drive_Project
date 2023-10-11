package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogOut")
public class UsuarioLogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioLogOut() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recupere a sessão do usuário.
		HttpSession session = request.getSession(false); // Não cria uma nova sessão se não existir.

		if (session != null) {
			// 2. Faça logout seguro invalidando a sessão.
			session.invalidate();

			// 3. Redirecione o usuário para a página inicial
			response.sendRedirect(request.getContextPath() + "/Find?pg=0");
		} else {
			// O usuário não tem uma sessão ativa.
			response.sendRedirect(request.getContextPath() + "/Find?pg=0");
		}
	}

}
