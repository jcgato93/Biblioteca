
package Negocio;

import Datos.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class NUser {
    
private Conexion con=new Conexion();
private Connection com=con.Conectar();
private String query="";
    
    public NUser() {
    }
    
    
    
    public boolean VerificaUser(DUser user)
    {
        boolean result=false;
        String login="",pass="";
         ResultSet rs;
         PreparedStatement pst;
        query="SELECT Usuario,Contrasena FROM Usuarios WHERE Usuarios.Usuario=? ANd Usuarios.Contrasena=?";
        try {
            
            pst=com.prepareStatement(query);
            
            pst.setString(1,user.getLogin());
            pst.setString(2,user.getPassword());
            
            rs=pst.executeQuery();
            
            while (rs.next())
            {                
                login=rs.getString("Usuario");
                pass=rs.getString("Contrasena");
            }
            
            rs.close();
            
            if(login.equals(user.getLogin()) && pass.equals(user.getPassword()))
            {
                result=true;
            }
            else{
            result=false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return result;
  
    }
    
}
