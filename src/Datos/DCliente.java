
package Datos;

public class DCliente {
private int ClienteId;
private String Nombre;
private String Apellido;
private String Telefono;
private String Identificacion;
private String Status;

public DCliente(){
    
}

    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public int getClienteId() {
        return ClienteId;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getStatus() {
        return Status;
    }

    public void setClienteId(int ClienteId) {
        this.ClienteId = ClienteId;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
    
    
    
}
