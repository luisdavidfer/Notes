package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbConnection;
import dao.UserDao;
import model.User;

/**
 * Servlet implementation class loginController
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("email") != null && request.getParameter("password") != null) {
			// Si recibimos parametros por la url ejecutamos el metodo doPost para comprobar el acceso
			doPost(request, response);
		}else {
			// Si no mandamos parametros por la url redireccionamos al inicio de sesion
			response.sendRedirect(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
	        // Recibimos parametros del formulario de login
	        String emailParam = request.getParameter("email");
	        String passParam = request.getParameter("password");
	        String msg = "";
	        // Recuperamos una instancia del objeto HttpSession
	        HttpSession session = request.getSession();

	        DbConnection conn = new DbConnection();
	        UserDao userDao = new UserDao(conn);
	        // Verificamos en la BD, si es un usuario correcto.
	        User user= userDao.login(emailParam, passParam);
	        conn.disconnect();

	        RequestDispatcher rd;
	        if (user.getId() > 0) {
	            // Creamos una variable de session, con el registro de usuario (Bean)
	            // Verificar en el administrador de aplicaciones de tomcat.
	            session.setAttribute("user", user);
	            response.sendRedirect(request.getContextPath());

	        } else {
	            msg = "*Credenciales incorrectos.";
	            request.setAttribute("message", msg);
	            rd = request.getRequestDispatcher("/login.jsp");
	            rd.forward(request, response);
	        }
	    }

}
