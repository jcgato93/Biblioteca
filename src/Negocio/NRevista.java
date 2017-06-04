
package Negocio;

import Datos.DRevista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Autonoma
 */
public class NRevista {
     String query;
   private Conexion con=new Conexion();
   private Connection com=con.Conectar();
    
    public NRevista() {
    }
    
        /**
         * Retorna el resultado de la consulta a la tabla libros 
         * recibe como parametro un where especificanco las condiciones de la consulta
         * si no tiene condicionales envia el "filtro" vaciao ""
         * @param filtro
         * @return  DefaultTableModel
         */
    
    public DefaultTableModel fillDataTable(String filtro) {
        DefaultTableModel modeloRe;

        String[] titulosRe = {"Id","Titulo","Categoria","Status"};

        Object[] registroRe = new Object[4];    
        
        modeloRe = new DefaultTableModel(null, titulosRe);
        


        query ="SELECT  re.RevistaId,re.Nombre,ca.Nombre as Categoria,re.[Status] FROM Revista re left join Categoria ca on re.CategoriaId=ca.CategoriaId "+filtro;

        try {
            PreparedStatement st = com.prepareStatement(query);
            
            
            ResultSet rs = st.executeQuery();

            
            
            while (rs.next()) {
                registroRe[0] = rs.getString("RevistaId");
                registroRe[1] = rs.getString("Nombre");
                registroRe[2] = rs.getString("Categoria");
                registroRe[3] = rs.getString("Status");
             
 
                modeloRe.addRow(registroRe);
            }
            return modeloRe;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        }
        
    
    //====================LLENAR COMBOBOX CON LAS CATEGORIAS=======================================
    
        public DefaultComboBoxModel fillComboBox() {
        DefaultComboBoxModel modeloRevista = new DefaultComboBoxModel();

       

        Object[] registroRevista = new Object[2];

    
 
        query ="SELECT * FROM Categoria";

        try {
            PreparedStatement st = com.prepareStatement(query);
            
            
            ResultSet rs = st.executeQuery();

            
            
            while (rs.next()) {
                registroRevista[0] = rs.getString("CategoriaId");
                registroRevista[1] = rs.getString("Nombre");
                
             
 
                modeloRevista.addElement(registroRevista[1]);
            }
            return modeloRevista;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        }
    
    
    
        
   //=================INSERTAR DATOS  ====================================================
        
    public boolean insertar(DRevista Revista) {
      
        boolean result=false;
        query = "INSERT INTO Revista (Nombre,CategoriaId,Status)"
        + "values (?,?,?)";
      
        try {

            PreparedStatement pst = com.prepareStatement(query);
            

            pst.setString(1, Revista.getNombre());
            pst.setInt(2, Revista.getCategoriaId());
            pst.setString(3, Revista.getStatus());
           
          

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
    public boolean actualizar(DRevista Revista) {
      
        boolean result=false;
        query = "UPDATE Revista SET Nombre=?,CategoriaId=?,Status=? WHERE RevistaId=?";
        
      
        try {

            PreparedStatement pst = com.prepareStatement(query);
            

            pst.setString(1, Revista.getNombre());
            pst.setInt(2, Revista.getCategoriaId());          
            pst.setString(3, Revista.getStatus());
          
          

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
       
       
   //=========================BORRAR DATOS===============================================================
       
    public boolean eliminar(DRevista Revista) {
      
        boolean result=false;
        query = "DELETE FROM Revista WHERE RevistaId=?";

      
        try {

            PreparedStatement pst = com.prepareStatement(query);
  
            pst.setInt(1,Revista.getRevistaId());
          

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
            
  
    //=========================VERIFICA SI EXISTE LIBRO=============================================
          public boolean verificaRevista(DRevista Revista) {
              
        query ="SELECT * FROM Revista WHERE Nombre=? AND CategoriaId=? ";

        int contador=0;
        boolean result=false;
        
        try {
            PreparedStatement st = com.prepareStatement(query);
            
           st.setString(1, Revista.getNombre());
           st.setInt(2, Revista.getCategoriaId());
            
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

    
    
    
    
    
    
    
    

