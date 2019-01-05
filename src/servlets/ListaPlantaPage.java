package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Message;
import beans.Usuario;
import dao.PlantaDao;

@WebServlet("/dashboard/lista-plantas")
public class ListaPlantaPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PlantaDao plantaDao = new PlantaDao();
       
    public ListaPlantaPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		request.setAttribute("listaPlantas", plantaDao.getAll(usuario.getId()));
		
		String acao = request.getParameter("acao");
		String planta_id = request.getParameter("planta_id");
		
		if (acao == null && planta_id == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("../u/lista-plantas.jsp");
			dispatcher.forward(request, response);
		}else if((acao != null && planta_id == null) || (acao == null && planta_id != null)) {
			request.setAttribute("error", "Operação inválida");
			RequestDispatcher dispatcher = request.getRequestDispatcher("../u/lista-plantas.jsp");
			dispatcher.forward(request, response);
		} else { // aqui poderia ser um else if para verificar se a ação é deletar
			Message message = plantaDao.DeletePlantas(Integer.parseInt(planta_id), usuario.getId());
			if(message.isStatus()) {
				response.sendRedirect(request.getContextPath()+"/dashboard/lista-plantas");
			}else {
				request.setAttribute("error", message.getContext());
				RequestDispatcher dispatcher = request.getRequestDispatcher("../u/lista-plantas.jsp");
				dispatcher.forward(request, response);
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Ocorreu um erro inesperado. Contate o administrador!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("../u/lista-plantas.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
