package model;

/**
 * Clase tipo "Modelo" que representa una entidad (registro) de la tabla de
 * Notas.
 *
 */
public class Note {

    /*
    Variables de Instancia de la clase.Cada variable, mapea a un campo de la tabla de 
    Usuario en la base de datos    
     */
    private int id;
    private String title;
    private String text;
    private String userId;

    public Note(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", title=" + title + ", text=" + text + ", userId=" + userId + "}";
    }

}