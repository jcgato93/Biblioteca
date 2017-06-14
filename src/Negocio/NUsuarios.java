
package Negocio;

import Datos.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
                usuario.setStatus(String.valueOf(rs.getString("Status")));
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
    
    
    public DefaultTableModel fillDataTable(String filtro) {
        DefaultTableModel modeloUsu;

        String[] titulosUsu = {"Id","Nombre","Apellido","Usuario","Contraseña","RolId","Status"};

        Object[] registroUsu = new Object[7];    
        
        modeloUsu = new DefaultTableModel(null, titulosUsu);
        


        query ="SELECT usu.UserId,usu.Nombre, usu.Apellido, usu.Usuario,Usu.Contrasena, usu.RolId, usu.[Status] FROM Usuarios usu "+filtro;

        try {
            PreparedStatement st = com.prepareStatement(query);
            
            
            ResultSet rs = st.executeQuery();

            
            
            while (rs.next()) {
                registroUsu[0] = rs.getString("UserId");
                registroUsu[1] = rs.getString("Nombre");
                registroUsu[2] = rs.getString("Apellido");
                registroUsu[3] = rs.getString("Usuario");
                registroUsu[4] = rs.getString("Contrasena");
                registroUsu[5] = rs.getString("RolId");
                registroUsu[6] = rs.getString("Status");
 
                modeloUsu.addRow(registroUsu);
            }
            return modeloUsu;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        }
        
    
    
    
        
   //=================INSERTAR DATOS  ====================================================
        
    public boolean insertar(DUsuarios Usuarios) {
      
        boolean result=false;
        query = "INSERT INTO Usuarios (Nombre,Apellido,Usuario,Contrasena,Rolid,Status)"
        + "values (?,?,?,?,?,?)";
      
        try {

            PreparedStatement pst = com.prepareStatement(query);
            

            pst.setString(1, Usuarios.getNombre());
            pst.setString(2, Usuarios.getApellido());
            pst.setString(3, Usuarios.getLogin());
            pst.setString(4, Usuarios.getPassword());
            pst.setInt(5, Usuarios.getRolId());
            pst.setString(6, Usuarios.getStatus());

            int n = pst.executeUpdate();

            if (n != 0) {
               result=true;
            } 
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        return result; 
    }
            
            
            
     //=======================ACTUALIZAR DATOS===============================================
    public boolean actualizar(DUsuarios Usuarios) {
      
        boolean result=false;
        query = "UPDATE Usuarios SET Nombre=?,Apellido=?,Usuario=?,Contrasena=?,RolId=?,[Status]=? WHERE UserId=?";
        
      
        try {

            PreparedStatement pst = com.prepareStatement(query);
            

            pst.setString(1, Usuarios.getNombre());
            pst.setString(2, Usuarios.getApellido());  
            pst.setString(3, Usuarios.getLogin());
            pst.setString(4, Usuarios.getPassword());
            pst.setInt(5, Usuarios.getRolId());
            pst.setInt(6, Usuarios.getUserId());
            pst.setString(7, Usuarios.getStatus());
          

            int n = pst.executeUpdate();

            if (n>0) {
               result=true;
            } 
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        return result; 
    } 
                   
   
    //=========================VERIFICA si existe cliente=============================================
          public boolean verificaUsuario(DUsuarios Usuarios) {
              
        query ="SELECT * FROM Usuarios WHERE  UserId=? ";

        int contador=0;
        boolean result=false;
        
        try {
            PreparedStatement st = com.prepareStatement(query);
            
           st.setInt(1, Usuarios.getUserId());
            
            ResultSet rs = st.executeQuery();

            
            
            while (rs.next()) {
              contador++;
            }
            
            if(contador>0)
            {
            result=true;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
        }
          return result;
        }
 
}
    

