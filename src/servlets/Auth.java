package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Usuario;
import dao.UsuarioDao;

@WebServlet("/auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDao usuarioDao = new UsuarioDao();
       
    public Auth() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("GET")) {
			response.sendRedirect(request.getContextPath()+"/");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = usuarioDao.Authentication(email, senha);
		
		if (usuario != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			session.setAttribute("admin", usuario.getNivel_acesso());
			response.sendRedirect(request.getContextPath()+"/dashboard");
		} else {
			request.setAttribute("error", "Email ou senha inválido!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

}
