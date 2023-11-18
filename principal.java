/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ProductosDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author catas
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        // paso 0 = conexion exitosa
        
            Conexion conexion=new Conexion();
            Connection con = conexion.conexionBD();
            
            
            
            //Paso 1 = Realizar la consulta 
            //METODO MOSTRAR
            
            /*String sql="SELECT * FROM libreria";
           
            //Paso 2 = Preparar la consulta
            try{
            PreparedStatement preparar = con.prepareStatement(sql);
            ResultSet set=preparar.executeQuery();
            while(set.next()){
                System.out.println(set.getString("tituoLibro"));
                
            }
            //PASO 4 = Cerrar preparacion y la conexion
            preparar.close();
            con.close();
            
            }catch(SQLException ex){
                System.out.println("Error:" +ex.getMessage());
                
                
            }
           */
            //Metodo insertar
            
            String sql = "INSERT INTO producto(idProducto, categoriaProducto, nombreProducto, precioProducto, cantidadProducto) VALUES(?,?,?,?,?)";
            
            try{
                PreparedStatement preparar = con.prepareStatement(sql);
                preparar.setInt(1, 750);
                preparar.setString(2, "Bebidas");
                preparar.setString(3, "Coca-Cola");
                preparar.setInt(4, 2500);
                preparar.setInt(5, 15);
                preparar.executeUpdate();
                
                preparar.close();
                con.close();
                System.out.println("Se ingreso correctamente el producto");
            }catch(SQLException ex){
                System.out.println("Error:" +ex.getMessage());
                
                
            }
            
    //Metodo Eliminar
       
try {
    con = conexion.conexionBD(); // Reabrir la conexión antes de la eliminación

    int idProductoAEliminar = 750; // Reemplaza esto con el ID del producto que deseas eliminar

    String deleteSql = "DELETE FROM producto WHERE idProducto=?";
    PreparedStatement deleteStatement = con.prepareStatement(deleteSql);
    deleteStatement.setInt(1, idProductoAEliminar);
    int filasAfectadas = deleteStatement.executeUpdate();
    deleteStatement.close();

    if (filasAfectadas > 0) {
        System.out.println("Producto con ID " + idProductoAEliminar + " eliminado correctamente.");
    } else {
        System.out.println("No se encontró un producto con el ID especificado.");
    }

} catch (SQLException ex) {
    System.out.println("Error al eliminar: " + ex.getMessage());
} finally {
    con.close(); // Cerrar la conexión después de la eliminación
}


    //Metodo Modificar
    
try {
    con = conexion.conexionBD(); // Reabrir la conexión antes de la actualización

    int idProductoAActualizar = 3; // Reemplaza esto con el ID del producto que deseas actualizar

    // Obtener los nuevos valores para el producto
    String nuevaCategoria = "Bebidas";
    String nuevoNombre = "Sprite";
    int nuevoPrecio = 2000;
    int nuevaCantidad = 20;

    // Consulta de actualización
    String updateSql = "UPDATE producto SET categoriaProducto=?, nombreProducto=?, precioProducto=?, cantidadProducto=? WHERE idProducto=?";
    PreparedStatement updateStatement = con.prepareStatement(updateSql);
    updateStatement.setString(1, nuevaCategoria);
    updateStatement.setString(2, nuevoNombre);
    updateStatement.setInt(3, nuevoPrecio);
    updateStatement.setInt(4, nuevaCantidad);
    updateStatement.setInt(5, idProductoAActualizar);

    int filasAfectadas = updateStatement.executeUpdate();
    updateStatement.close();

    if (filasAfectadas > 0) {
        System.out.println("Producto con ID " + idProductoAActualizar + " actualizado correctamente.");
    } else {
        System.out.println("No se encontró un producto con el ID especificado.");
    }

} catch (SQLException ex) {
    System.out.println("Error al actualizar: " + ex.getMessage());
} finally {
    con.close(); // Cerrar la conexión después de la actualización
}
           
    }            
}  
