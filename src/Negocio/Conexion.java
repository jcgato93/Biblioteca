
package Negocio;

 import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Conexion {
    String db="Biblioteca";
    String url="jdbc:sqlserver://localhost:1433;databaseName=Biblioteca;";
    String user="Invitado";
    String pass="pacifico";
 
    Connection conexion;
    
    
    public Conexion(){}
    
    
    public Connection Conectar()
    {
    
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion=DriverManager.getConnection(this.url,this.user,this.pass);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    return conexion;
    }
    
    
}
