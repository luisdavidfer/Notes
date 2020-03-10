package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbConnection;
import dao.NoteDao;
import model.Note;

/**
 * Servlet implementation class siteController
 */
@WebServlet("/")
public class siteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
        	// No existe la sesion mostramos login
        	rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        } else { 
        	// Existe la sesion accedemos a la aplicacion
        	DbConnection conn = new DbConnection();
    		NoteDao noteDao = new NoteDao(conn);
    		List<Note> notes = noteDao.getAll();
    		conn.disconnect();
    		request.setAttribute("notes", notes);
    		rd = request.getRequestDispatcher("/notes.jsp");
            rd.forward(request, response);
        }	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
