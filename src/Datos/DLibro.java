
package Datos;


public class DLibro {
    
    private int LibroId;
    private String Nombre;
    private int Categoria;
    private String Autor;
    private String Status;

    //Constructor 

    public DLibro() {
    }
    
    
    //set and get
    public int getLibroId() {
        return LibroId;
    }

    public void setLibroId(int LibroId) {
        this.LibroId = LibroId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCategoria() {
        return Categoria;
    }

    public void setCategoria(int Categoria) {
        this.Categoria = Categoria;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
}
