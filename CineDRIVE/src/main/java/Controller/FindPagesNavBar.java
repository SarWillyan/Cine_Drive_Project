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
        try {
            // Inicialização de objetos DAO
            FilmeDao filmeDao = new FilmeDao();
            GeneroDao generoDao = new GeneroDao();

            // Variáveis para armazenar listas de filmes e gêneros
            List<Filme> filmes = null;
            List<Genero> generos = null;

            // Captura a página atual
            String currentPage = request.getParameter("pg");
            
            // Captura a pesquisa feita
            String pesquisa = request.getParameter("pesquisa");

            // Define a página padrão como 0 se o parâmetro não existir
            if (currentPage == null) {
                currentPage = "0";
            }
            
            // Lógica para lidar com diferentes páginas
            if (currentPage.equals("0")) { // Página geral
            	if (pesquisa == null) {
            		filmes = filmeDao.findMovies();            		
            	} else {
            		filmes = filmeDao.findByName(pesquisa);
            	}
            } else if (currentPage.equals("1")) { // Página de categorias
                generos = generoDao.find();
                request.setAttribute("generos", generos);
                String generoSelecionado = request.getParameter("genero");
                if (generoSelecionado == null) {
                    filmes = filmeDao.findMovies();
                } else {
                    filmes = filmeDao.findByGender(generoSelecionado);
                }
            } else if (currentPage.equals("2")) { // Página de topFilmes
                filmes = filmeDao.findTopMovies();
            }

            // Define o atributo "filmes" para os filmes encontrados
            request.setAttribute("filmes", filmes);

            // Encaminha para a página "home.jsp"
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
			requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Lida com a exceção adequadamente
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    }
}
