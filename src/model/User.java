package model;

/**
 * Clase tipo "Modelo" que representa una entidad (registro) de la tabla de
 * Usuario.
 *
 */
public class User {

    /*
    Variables de Instancia de la clase.Cada variable, mapea a un campo de la tabla de 
    Usuario en la base de datos    
     */
    private int id;
    private String username;
    private String password;
    private String email;

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", username=" + username + ", password=" + password + "}";
    }

}