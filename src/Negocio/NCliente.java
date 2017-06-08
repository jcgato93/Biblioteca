package Negocio;

import Datos.DCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NCliente {

     String query;
   private Conexion con=new Conexion();
   private Connection com=con.Conectar();
    
    public NCliente() {
    }
    
        /**
         * Retorna el resultado de la consulta a la tabla libros 
         * recibe como parametro un where especificanco las condiciones de la consulta
         * si no tiene condicionales envia el "filtro" vaciao ""
         * @param filtro
         * @return  DefaultTableModel
         */
    
    public DefaultTableModel fillDataTable(String filtro) {
        DefaultTableModel modeloCli;

        String[] titulosCli = {"Id","Nombre","Apellido","Telefono","Identificacion","Status"};

        Object[] registroCli = new Object[6];    
        
        modeloCli = new DefaultTableModel(null, titulosCli);
        


        query ="SELECT  cli.ClienteId,cli.Nombre, cli.Apellido, cli.Telefono,cli.Identificacion, cli.[Status] FROM Cliente cli "+filtro;

        try {
            PreparedStatement st = com.prepareStatement(query);
            
            
            ResultSet rs = st.executeQuery();

            
            
            while (rs.next()) {
                registroCli[0] = rs.getString("ClienteId");
                registroCli[1] = rs.getString("Nombre");
                registroCli[2] = rs.getString("Apellido");
                registroCli[3] = rs.getString("Telefono");
                registroCli[4] = rs.getString("Identificacion");
                registroCli[5] = rs.getString("Status");
 
                modeloCli.addRow(registroCli);
            }
            return modeloCli;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        }
        
    
    
    
        
   //=================INSERTAR DATOS  ====================================================
        
    public boolean insertar(DCliente Cliente) {
      
        boolean result=false;
        query = "INSERT INTO Cliente (Nombre,Apellido,Telefono,Identificacion,Status)"
        + "values (?,?,?,?,?)";
      
        try {

            PreparedStatement pst = com.prepareStatement(query);
            

            pst.setString(1, Cliente.getNombre());
            pst.setString(2, Cliente.getApellido());
            pst.setString(3, Cliente.getTelefono());
            pst.setString(4, Cliente.getIdentificacion());
            pst.setString(5, Cliente.getStatus());
          

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
    public boolean actualizar(DCliente Cliente) {
      
        boolean result=false;
        query = "UPDATE Cliente SET Nombre=?,Apellido=?,Telefono=?,Identificacion=?,Status=? WHERE ClienteId=?";
        
      
        try {

            PreparedStatement pst = com.prepareStatement(query);
            

            pst.setString(1, Cliente.getNombre());
            pst.setString(2, Cliente.getApellido());  
            pst.setString(3, Cliente.getTelefono());
            pst.setString(4, Cliente.getIdentificacion());
            pst.setString(5, Cliente.getStatus());
            pst.setInt(6, Cliente.getClienteId());
          
          

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
          public boolean verificaCliente(DCliente Cliente) {
              
        query ="SELECT * FROM Cliente WHERE  Identificacion=? ";

        int contador=0;
        boolean result=false;
        
        try {
            PreparedStatement st = com.prepareStatement(query);
            
           st.setString(1, Cliente.getIdentificacion());
            
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
   
    
    
    
    
    
    
    
    
    
    

