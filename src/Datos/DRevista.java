
package Datos;

public class DRevista {
private int RevistaId;
private String Nombre;
private int CategoriaId;
private String Status;

//constuctor
public DRevista(){
    
}


//get and set
    public int getRevistaId() {
        return RevistaId;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getCategoriaId() {
        return CategoriaId;
    }

    public String getStatus() {
        return Status;
    }

    public void setRevistaId(int RevistaId) {
        this.RevistaId = RevistaId;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setCategoriaId(int CategoriaId) {
        this.CategoriaId = CategoriaId;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

 
    
    
    
}
