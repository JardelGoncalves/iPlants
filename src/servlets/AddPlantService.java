package servlets;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import beans.Message;
import beans.Planta;
import beans.Usuario;
import config.Variables;
import dao.PlantaDao;

@WebServlet("/add-planta")
public class AddPlantService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Variables variables = new Variables();
	private static PlantaDao plantaDao = new PlantaDao();
       
    public AddPlantService() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("GET")) {
			response.sendRedirect(request.getContextPath()+"/dashboard/catalogar-planta");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		try {
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			Planta planta = new Planta();
			
			String foto = request.getParameter("foto");
			String nome_planta = request.getParameter("nome_planta");
			String descricao = request.getParameter("descricao");
			
			planta.setId_usuario(usuario.getId());
			planta.setFoto(foto);
			planta.setNome(nome_planta);
			planta.setDescricao(descricao);
			
			Message message = plantaDao.SavePlants(planta);
			if(message.isStatus() == true) {
				request.setAttribute("success", message.getContext());
				RequestDispatcher dispatcher = request.getRequestDispatcher("u/catalogar-planta.jsp");
				dispatcher.forward(request, response);
			}else {
				System.out.println(planta.toString());
				request.setAttribute("error", message.getContext());
				RequestDispatcher dispatcher = request.getRequestDispatcher("u/catalogar-planta.jsp");
				dispatcher.forward(request, response);
			}
		}catch (Exception e) {
			request.setAttribute("error", "Ocorreu um erro inesperado. Contate o administrado!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("u/catalogar-planta.jsp");
			dispatcher.forward(request, response);
		}
		
		
		/* UPLOAD FILE FUNCIONANDO
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Planta planta = new Planta();
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
		String foto = "PLANT-" + usuario.getId()+"-"+timeStamp+".png";
		String nome_planta = "";
		String descricao = "";
		
		
		String file_name = null;
		response.setContentType("text/html");
		
		
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if(!isMultipartContent){
			return;
		}
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> fields = upload.parseRequest(request);
			Iterator<FileItem> it = fields.iterator();
			
			if(!it.hasNext()) {
				return;
			}
			while(it.hasNext()){
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				// setando variaveis
				
				
				if(isFormField){
					if(file_name==null){
						if(fileItem.getFieldName().equals("nome_planta")){
							nome_planta = fileItem.getString();
						}else if (fileItem.getFieldName().equals("descricao")) {
							descricao = fileItem.getString();
						}
					}
				} else {
					if(fileItem.getSize() > 0) {
						planta.setId_usuario(usuario.getId());
						planta.setNome(nome_planta);
						planta.setDescricao(descricao);
						planta.setFoto(foto);
						//Metodo para enviar para o banco de dados
						Message message = plantaDao.SavePlants(planta);
						if(message.isStatus() == true) {
							fileItem.write(new File(variables.getDIR_FILE_UPLOAD()+foto));
							request.setAttribute("success", message.getContext());
							RequestDispatcher dispatcher = request.getRequestDispatcher("u/catalogar-planta.jsp");
							dispatcher.forward(request, response);
						}else {
							System.out.println(planta.toString());
							request.setAttribute("error", message.getContext());
							RequestDispatcher dispatcher = request.getRequestDispatcher("u/catalogar-planta.jsp");
							dispatcher.forward(request, response);
						}
					}
				}
			}
		} catch (Exception e) {
			request.setAttribute("error", "Ocorreu um erro inesperado. Contate o administrado!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("u/catalogar-planta.jsp");
			dispatcher.forward(request, response);
		}
		
		*/
		
	}

}
