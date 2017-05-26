
package Negocio;
import Datos.*;
import Presentacion.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NLibro {

   String query;
   private Conexion con=new Conexion();
   private Connection com=con.Conectar();
    
    public NLibro() {
    }
    
        /**
         * Retorna el resultado de la consulta a la tabla libros 
         * recibe como parametro un where especificanco las condiciones de la consulta
         * si no tiene condicionales envia el "filtro" vaciao ""
         * @param filtro
         * @return  DefaultTableModel
         */
    
    public DefaultTableModel fillDataTable(String filtro) {
        DefaultTableModel modelo;

        String[] titulos = {"ID","Titulo","Categoria","Autor","Status"};

        Object[] registro = new Object[5];

        JButton btnEliminar=new JButton("Editar");
        
        modelo = new DefaultTableModel(null, titulos);
        


        query ="SELECT  li.LibroId,li.Nombre,ca.Nombre as Categoria,li.Autor,Li.[Status] FROM Libro li left join Categoria ca on li.CategoriaId=ca.CategoriaId "+filtro;

        try {
            PreparedStatement st = com.prepareStatement(query);
            
            
            ResultSet rs = st.executeQuery();

            
            
            while (rs.next()) {
                registro[0] = rs.getString("LibroId");
                registro[1] = rs.getString("Nombre");
                registro[2] = rs.getString("Categoria");
                registro[3] = rs.getString("Autor");
                registro[4] = rs.getString("Status");
             
 
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        }
        
    
    //====================LLENAR COMBOBOX CON LAS CATEGORIAS=======================================
    
        public DefaultComboBoxModel fillComboBox() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

       

        Object[] registro = new Object[2];

    
 
        query ="SELECT * FROM Categoria";

        try {
            PreparedStatement st = com.prepareStatement(query);
            
            
            ResultSet rs = st.executeQuery();

            
            
            while (rs.next()) {
                registro[0] = rs.getString("CategoriaId");
                registro[1] = rs.getString("Nombre");
                
             
 
                modelo.addElement(registro[1]);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        }
    
    
    
        
   //=================INSERTAR DATOS  ====================================================
        
    public boolean insertar(DLibro Libro) {
      
        boolean result=false;
        query = "INSERT INTO Libro (Nombre,Categoria,Autor,Status)"
        + "values (?,?,?,?)";
      
        try {

            PreparedStatement pst = com.prepareStatement(query);
            

            pst.setString(1, Libro.getNombre());
            pst.setInt(2, Libro.getCategoria());
            pst.setString(3, Libro.getAutor());
            pst.setString(4, Libro.getStatus());
          

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
    public boolean actualizar(DLibro Libro) {
      
        boolean result=false;
        query = "UPDATE Libro SET Nombre=?,Categoria=?,Autor=?,Status=? WHERE LibroId=?"
        + "values (?,?,?,?,?)";
      
        try {

            PreparedStatement pst = com.prepareStatement(query);
            

            pst.setString(1, Libro.getNombre());
            pst.setInt(2, Libro.getCategoria());
            pst.setString(3, Libro.getAutor());
            pst.setString(4, Libro.getStatus());
            pst.setInt(5,Libro.getLibroId());
          

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
       
    public boolean eliminar(DLibro Libro) {
      
        boolean result=false;
        query = "DELETE FROM Libro WHERE LibroId=?";

      
        try {

            PreparedStatement pst = com.prepareStatement(query);
  
            pst.setInt(1,Libro.getLibroId());
          

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
            
  
}
