
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
   
   
   public DefaultTableModel getDevoluciones(int idCliente)
   {
          DefaultTableModel modeloCli;

        String[] titulosCli = {"Fecha_Prestamo","Fecha_Devolucion","LibroId_RevistaId","Tipo"};

        Object[] registroCli = new Object[4];    
        
        modeloCli = new DefaultTableModel(null, titulosCli);
        


        query ="SELECT * FROM Prestamo WHERE ClienteId="+idCliente;

        try {
            PreparedStatement st = com.prepareStatement(query);
            
            
            ResultSet rs = st.executeQuery();

            
            
            while (rs.next()) {
                registroCli[0] = rs.getString("Fecha_Prestamo");
                registroCli[1] = rs.getString("Fecha_Devolucion");
                registroCli[2] = rs.getString("LibroId_RevistaId");
                registroCli[3] = rs.getString("Tipo");
 
                modeloCli.addRow(registroCli);
            }
            return modeloCli;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
   
   }
    
}
