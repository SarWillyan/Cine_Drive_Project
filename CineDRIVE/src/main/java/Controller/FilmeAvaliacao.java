package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.AvaliacaoDao;
import Model.Avaliacao;

@WebServlet("/Avaliacao")
public class FilmeAvaliacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FilmeAvaliacao() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("logado") != null) {
			// Recupera os parâmetros recebidos pela requisição
			int filmeId = Integer.parseInt(request.getParameter("filmeId"));
			int userId = Integer.parseInt(request.getParameter("userId"));
			int nota = Integer.parseInt(request.getParameter("nota"));
			
			// Cria a avaliação
			Avaliacao avaliacao = new Avaliacao();
			
			//insere os dados
			avaliacao.setId_filme(filmeId);
			avaliacao.setId_usuario(userId);
			avaliacao.setNota(nota);
			
			// Insere no banco 
			AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
			avaliacaoDao.createOrUpdate(avaliacao);
			
			response.sendRedirect(request.getContextPath() + "/Filme?id=" + filmeId);			
		} else {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}

}
