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
import dao.UsuarioDao;

@WebServlet("/register-user")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioDao usuarioDao = new UsuarioDao();
       
    public RegisterUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("GET")) {
			response.sendRedirect(request.getContextPath()+"/");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		
		Message message = usuarioDao.CadastrarUsuario(usuario);
		if (message.isStatus() == true) {
			request.setAttribute("success", message.getContext());
		}else {
			request.setAttribute("error", message.getContext());
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
