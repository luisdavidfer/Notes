package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.*;

public class NoteDao {
    
	private DbConnection conn;

    public NoteDao(DbConnection conn) {
        this.conn = conn;
    }

    /**
     * Metodo para insertar un registro en la tabla Notas
     *
     * @param nota
     * @return Regresa true si se ha insertado y false si ha habido un error
     * @throws Exception
     */
    public boolean insert(Note note) {
        try {
            String sql = "insert into notes values (?,?,?,?)";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, note.getId());
            preparedStatement.setString(2, note.getTitle());
            preparedStatement.setString(3, note.getText());
            preparedStatement.setString(4, note.getUserId());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error NoteDao.insert: " + e.getMessage());
            return false;
        }
    }

    /**
     * Metodo para insertar un registro en la tabla Notas
     *
     * @param nota
     * @return Regresa true si se ha insertado y false si ha habido un error
     * @throws Exception
     */
    public boolean update(Note note) {
        try {
            String sql = "update notes set title = ?, text = ? where id = " + note.getId();
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, note.getTitle());
            preparedStatement.setString(2, note.getText());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error NoteDao.update: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Metodo para eliminar un registro de la tabla Notas
     *
     * @param id nota
     * @return Regresa true si se ha eliminado y false si ha habido un error
     * @throws Exception
     */
    public boolean delete(int id) {
        try {
            String sql = "delete from notes where id = " + id;
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error NoteDao.delete: " + e.getMessage());
            return false;
        }
    }

    /**
     * Metodo que regresa una lista con todos las notas.
     *
     * @return Lista de todos los objetos nota
     * @throws Exception
     */
    public List<Note> getAll(){

        try {
            String sql = "select * from notes order by id desc";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Note> list = new LinkedList<>();
            Note note;
            while (rs.next()) {
            	note = new Note(rs.getInt("id"));
                note.setTitle(rs.getString("title"));
                note.setText(rs.getString("text"));
                note.setUserId(rs.getString("user_id"));    
                // Add note object to the list
                list.add(note);
            }
            return list;

        } catch (SQLException e) {            
            System.out.println("Error NoteDao.getAll: " + e.getMessage());
            return null;
        }
    }


}