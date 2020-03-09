package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    /**
     * Metodo para validar un usuario administrador en la base de datos
     * @param user
     * @param pass
     * @return Objeto de tipo Usuario con id, perfil, estado, etc.
     */
    public User login(String email, String password) {

        try {
            String sql = "select * from users where email= ? and password = ? limit 1";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            User user = new User(0);
            while (rs.next()) {
                // Create an object for the user
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            System.out.println("Error Dao.login: " + e.getMessage());
            return null;
        }
    }

}