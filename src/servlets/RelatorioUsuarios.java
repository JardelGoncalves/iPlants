package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.RelatorioServices;
import beans.Usuario;
import dao.UsuarioDao;

@WebServlet("/dashboard/relatorio-usuarios")
public class RelatorioUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RelatorioServices relatorioServices = new RelatorioServices();
	private UsuarioDao usuarioDao = new UsuarioDao();
       
    public RelatorioUsuarios() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			ServletContext context = request.getServletContext();
			
			List<Usuario> usuarios = usuarioDao.getAll();
			
			
			String fileURL = relatorioServices.gerarRelatorio(usuarios, new HashMap(), 
					"rel_usuarios", "rel_usuarios", context);
			
			File downFile = new File(fileURL);
			FileInputStream inputStream = new FileInputStream(downFile);
			
			String mimeType = context.getMimeType(fileURL);
			
			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}
			
			response.setContentType(mimeType);
			response.setContentLength((int) downFile.length());
			
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"", downFile.getName());

			response.setHeader(headerKey, headerValue);

			OutputStream outputStream = response.getOutputStream();

			byte[] buffer = new byte[4096];
			int bytesRead = -1;

			while((bytesRead = inputStream.read(buffer)) != -1){
				outputStream.write(buffer, 0, bytesRead);
			}
			
			inputStream.close();
			outputStream.close();
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
