
package Negocio;

import Datos.DPrestamo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NPrestamo {
    
   String query;
   private Conexion con=new Conexion();
   private Connection com=con.Conectar();
   
   DPrestamo prestamo=new DPrestamo();
    
   public boolean GuardarPrestamo(DPrestamo prestamo,int cantidad){
   
       boolean result=false;
       try{
       CallableStatement cst = com.prepareCall("{call spInsert_Prestamo(?,?,?,?,?,?,?)}");
       
       cst.setInt(1, prestamo.getClienteId());
       cst.setInt(2, prestamo.getUserId());
       cst.setString(3,prestamo.getFechaPrestamo());
       cst.setString(4,prestamo.getFechaDevolucion());
       cst.setString(5,prestamo.getLibroId_RevistaId());
       cst.setString(6,prestamo.getTipo());
       cst.setInt(7,cantidad);
       
       cst.execute();
       result=true;
       
   }catch (Exception e) {JOptionPane.showMessageDialog(null, e.getMessage()); result=false;}
       return result;
       
   }
   
   
      public boolean Devolucion(DPrestamo prestamo,int cantidad){
   
       boolean result=false;
       try{
       CallableStatement cst = com.prepareCall("{call spUpdate_Devolucion (?,?,?,?)}");
       
       cst.setInt(1,prestamo.getClienteId());
       cst.setString(2,prestamo.getLibroId_RevistaId());
       cst.setString(3,prestamo.getTipo());
       cst.setInt(4,cantidad);
       
       cst.execute();
       result=true;
       
   }catch (Exception e) {JOptionPane.showMessageDialog(null, e.getMessage()); result=false;}
       return result;
       
   }
   
   //====================llena la tabla temporal=============
      public boolean FillTemp(int Clienteid){
   
       boolean result=false;
       try{
       CallableStatement cst = com.prepareCall("{call SP_FillTemp(?)}");
       
       cst.setInt(1,Clienteid);
    
       
       cst.execute();
       result=true;
       
   }catch (Exception e) {JOptionPane.showMessageDialog(null, e.getMessage()); result=false;}
       return result;
       
   }
   //=========================================
   
   
      
      
      
   
   public DefaultTableModel getDevoluciones()
   {
          DefaultTableModel modeloCli;

        String[] titulosCli = {"id","titulo","tipo"};

        Object[] registroCli = new Object[3];    
        
        modeloCli = new DefaultTableModel(null, titulosCli);
        


        query ="SELECT * FROM TablaTemporal";

        try {
            PreparedStatement st = com.prepareStatement(query);
            
            
            ResultSet rs = st.executeQuery();

            
            
            while (rs.next()) {
                registroCli[0] = rs.getString("id");
                registroCli[1] = rs.getString("titulo");
                registroCli[2] = rs.getString("tipo");
                
 
                modeloCli.addRow(registroCli);
            }
            return modeloCli;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
   
   }
    
}
