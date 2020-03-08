package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbConnection;
import dao.UserDao;
import model.User;

/**
 * Servlet implementation class registerController
 */
@WebServlet(name = "register", urlPatterns = { "/register" })
public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: (registerController) ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Creación del objeto Usuario con los datos introducidos
		User usr = new User(0);
		usr.setUsername(request.getParameter("username"));
		usr.setPassword(request.getParameter("password"));
		usr.setEmail(request.getParameter("email"));
		
		System.out.println(usr);
		
		// Almacenamiento en la BD
		DbConnection conn = new DbConnection();
		UserDao userDao = new UserDao(conn);
		if(userDao.insert(usr)) {
			System.out.println("Saved: " + usr.toString());
		}else {
			System.out.println("Error: " + usr.toString());
		}
		
		conn.disconnect();
		RequestDispatcher rd = request.getRequestDispatcher("/notes.jsp");
		rd.forward(request, response);
		
	}

}
