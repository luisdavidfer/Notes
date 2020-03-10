package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;



import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;



import dao.DbConnection;
import dao.NoteDao;
import model.Note;

/**
 * Servlet implementation class notesController
 */
@WebServlet(name = "notes", urlPatterns = { "/notes" })
public class notesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DbConnection conn = new DbConnection();
		NoteDao noteDao= new NoteDao(conn);
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		//En funcion de la accion actuaremos
		switch(action) {
			//ELIMIMAR NOTA DE LA BASE DE DATOS
			case "delete":	
				int removeId = Integer.parseInt(request.getParameter("id"));
				noteDao.delete(removeId);
				break;
				
			//ACTUALIZAR NOTA EN LA BASE DE DATOS
			case "update":
				int updateId = Integer.parseInt(request.getParameter("id"));
				Note updatedNote = noteDao.get(updateId);
				updatedNote.setTitle(request.getParameter("title"));
				updatedNote.setText(request.getParameter("text"));
				noteDao.update(updatedNote);
				break;
				 
		    // ALMACENAR NOTA EN LA BASE DE DATOS 
			case "store":
				Note newNote = new Note(0);
				newNote.setTitle(request.getParameter("title"));
				newNote.setText(request.getParameter("text"));
				noteDao.insert(newNote);
				break;
			case "logout":
				session.invalidate();
		}
		
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
        // Comprobamos que hay un usuario logueado
		if (session.getAttribute("user") != null) {
			DbConnection conn = new DbConnection();
			NoteDao noteDao= new NoteDao(conn);
			String action = request.getParameter("action");
			//En funcion de la accion actuaremos
			switch(action) {
				//ELIMIMAR NOTA DE LA BASE DE DATOS
				case "remove":	
					int removeId = Integer.parseInt(request.getParameter("id"));
					noteDao.delete(removeId);
					break;
					
				//ACTUALIZAR NOTA EN LA BASE DE DATOS
				case "update":
					int updateId = Integer.parseInt(request.getParameter("id"));
					Note updatedNote = new Note(updateId);
					updatedNote.setTitle(request.getParameter("title"));
					updatedNote.setText(request.getParameter("text"));
					noteDao.update(updatedNote);
					
					break;
					 
			    // ALMACENAR NOTA EN LA BASE DE DATOS 
				case "store":
					Note newNote = new Note(0);
					newNote.setTitle(request.getParameter("title"));
					newNote.setText(request.getParameter("text"));
					noteDao.update(newNote);
					PrintWriter out;
					//response.setContentType("text/html");
					out = response.getWriter();
					out.print('{"id"}');
					break;
			}
        }else{
			response.sendRedirect(request.getContextPath());
		}
		
	}

}
