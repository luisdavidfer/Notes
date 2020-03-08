package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.*;

public class UserDao {

    private DbConnection conn;

    public UserDao(DbConnection conn) {
        this.conn = conn;
    }

    /**
     * Metodo para insertar un registro en la tabla Usuarios
     *
     * @param usuario
     * @return Regresa true si se ha insertado y false si ha habido un error
     * @throws Exception
     */
    public boolean insert(User user) {
        try {
            String sql = "insert into users values (?,?,?,?)";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error UserDao.insert: " + e.getMessage());
            return false;
        }
    }



}