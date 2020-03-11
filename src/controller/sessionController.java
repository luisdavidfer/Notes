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
import model.Note;
import model.User;

/**
 * Servlet implementation class sessionController
 */
@WebServlet(name = "session", urlPatterns = { "/session" })
public class sessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if((request.getParameter("email") != null && request.getParameter("password") != null) || (request.getParameter("email") != null && request.getParameter("password") != null  && request.getParameter("username") != null)) {
			// Si recibimos parametros por la url ejecutamos el metodo doPost con los parametros recibidos
			doPost(request, response);
		}else {
			// Si no mandamos parametros por la url redireccionamos al inicio de sesion
			response.sendRedirect(request.getContextPath());
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = null;
		DbConnection conn = null;
		UserDao userDao = null;
		RequestDispatcher rd = null;
		
		//En funcion de la accion actuaremos

		String action = request.getParameter("action");
		switch(action) {
			// LOGUEAMOS USUARIO
			case "login":	
				 // Recibimos parametros del formulario de login
		        String emailParam = request.getParameter("email");
		        String passParam = request.getParameter("password");

		        // Verificamos en la BD, si es un usuario correcto.
		        conn = new DbConnection();
		        userDao = new UserDao(conn);
		        User user= userDao.login(emailParam, passParam);
		        conn.disconnect();

		        if (user.getId() > 0) {
		            // Creamos una variable de session, con el registro de usuario (Bean)
			        session = request.getSession();
		            // Verificar en el administrador de aplicaciones de tomcat.
		            session.setAttribute("user", user);
		            
		            response.sendRedirect(request.getContextPath());

		        } else {
		            request.setAttribute("message", "*Credenciales incorrectos.");
		            rd = request.getRequestDispatcher("/login.jsp");
		            rd.forward(request, response);
		        }
				break;
				
			// REGISTRAMOS NUEVO USUARIO
			case "register":
				// Creación del objeto Usuario con los datos introducidos
				User registeredUser = new User(0);
				registeredUser.setUsername(request.getParameter("username"));
				registeredUser.setPassword(request.getParameter("password"));
				registeredUser.setEmail(request.getParameter("email"));
				
				System.out.println("Registered user: " + registeredUser);
				
				// Almacenamiento en la BD
				conn = new DbConnection();
				userDao = new UserDao(conn);
				if(userDao.insert(registeredUser)) {
					System.out.println("Saved: " + registeredUser.toString());
				}else {
					System.out.println("Error: " + registeredUser.toString());
				}
				
				conn.disconnect();

				session = request.getSession();
				session.setAttribute("user", registeredUser);
				response.sendRedirect(request.getContextPath());
				break;
				 
		    // CERRAMOS LA SESION ACTUAL
			case "logout":
				System.out.println("logout");
				session = request.getSession();
				session.invalidate();
	            response.sendRedirect(request.getContextPath());
		}
		
	}

}
