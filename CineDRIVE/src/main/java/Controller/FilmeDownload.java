package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UploadDao;
import Model.Upload;

@WebServlet("/Download")
public class FilmeDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FilmeDownload() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int filmeId = Integer.parseInt(request.getParameter("filmeId"));
		
		UploadDao uploadDao = new UploadDao();
		Upload upload = uploadDao.findByMovieId(filmeId);
		
		File file = new File(upload.getVideo_path());
		
		if (file.getName() != null) {
            // Configurar os cabeçalhos da resposta HTTP para forçar o download.
            response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());

            FileInputStream fileImput = new FileInputStream(file);
            // Abra o arquivo e configure a entrada e saída.
            try (InputStream inputStream = (InputStream) fileImput;
                 ServletOutputStream outStream = response.getOutputStream()) {

                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
            }
        } else {
            // Caso o nome do arquivo seja inválido ou não fornecido, você pode tratar isso apropriadamente.
            response.getWriter().println("Nome de arquivo inválido.");
        }

	}

}
