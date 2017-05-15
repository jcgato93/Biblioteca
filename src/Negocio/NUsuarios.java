
package Negocio;

import Datos.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class NUsuarios {
    
private Conexion con=new Conexion();
private Connection com=con.Conectar();
private String query="";
    
    public NUsuarios() {
    }
    
    
    /**
     * Verifia si el usuario existe o no en la base de datos
     * @param user
     * @return boolean 
     */
    public boolean VerificaUser(DUsuarios user)
    {
        boolean result=false;
        String login="",pass="";
         ResultSet rs;
         PreparedStatement pst;
        query="SELECT * FROM Usuarios WHERE Usuarios.Usuario=? ANd Usuarios.Contrasena=?";
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
    
    /**
     * Retorna la informacion del un Usuario del Sistema
     * @param Usuario
     * @param Contrasena
     * @return
     * @throws SQLException 
     */
    public DUsuarios retornaUsuario(String Usuario,String Contrasena) throws SQLException
    {
         ResultSet rs=null;
         PreparedStatement pst;
         DUsuarios usuario=new DUsuarios();
        
        query="SELECT * FROM Usuarios WHERE Usuarios.Usuario=? ANd Usuarios.Contrasena=?";
        try {
            
            pst=com.prepareStatement(query);
            
            pst.setString(1,Usuario);
            pst.setString(2,Contrasena);
            
            rs=pst.executeQuery();
            
            while (rs.next())
            {                
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setApellido(rs.getString("Apellido"));
                usuario.setRolId(Integer.parseInt(rs.getString("RolId")));
                usuario.setUserId(Integer.parseInt(rs.getString("UserId")));
            }
            
            rs.close();
            
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            rs.close();
            com.close();
        }
         return usuario;
        
    }
}
    

