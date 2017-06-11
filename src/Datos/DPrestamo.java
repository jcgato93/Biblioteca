
package Datos;


public class DPrestamo {
    
    private int PrestamoId;
    private int UserId;
    private int ClienteId;
    private String FechaPrestamo;
    private String FechaDevolucion;
    private String LibroId_RevistaId;
    private String Tipo;

    public int getPrestamoId() {
        return PrestamoId;
    }

    public void setPrestamoId(int PrestamoId) {
        this.PrestamoId = PrestamoId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public int getClienteId() {
        return ClienteId;
    }

    public void setClienteId(int ClienteId) {
        this.ClienteId = ClienteId;
    }

    public String getFechaPrestamo() {
        return FechaPrestamo;
    }

    public void setFechaPrestamo(String FechaPrestamo) {
        this.FechaPrestamo = FechaPrestamo;
    }

    public String getFechaDevolucion() {
        return FechaDevolucion;
    }

    public void setFechaDevolucion(String FechaDevolucion) {
        this.FechaDevolucion = FechaDevolucion;
    }

    public String getLibroId_RevistaId() {
        return LibroId_RevistaId;
    }

    public void setLibroId_RevistaId(String LibroId_RevistaId) {
        this.LibroId_RevistaId = LibroId_RevistaId;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
}
