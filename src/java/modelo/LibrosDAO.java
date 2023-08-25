
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cortez
 */
public class LibrosDAO {
    Connection conexion;
    
    public LibrosDAO(){
        Conexion con=new Conexion();
        conexion =con.getConexion();
    }
    
    public List<Libros>listarLibros(){
        PreparedStatement  ps;
        ResultSet rs;
        
        List<Libros> lista= new ArrayList<>();
        
        try{
            
            ps=conexion.prepareStatement("SELECT id,titulo,autor,fecha_publicacion FROM libros");
            rs=ps.executeQuery();
            
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String fechaPublicacion = rs.getString ("fecha_publicacion");

                Libros libros = new Libros(id,titulo, autor, fechaPublicacion);
                lista.add(libros);
            }
        
            return lista;
        }catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
        
    }
    
     public Libros mostrarLibros(int _id){
         
     
        PreparedStatement  ps;
        ResultSet rs;
        Libros libros = null;
  
        try{
            
            ps=conexion.prepareStatement("SELECT id,titulo,autor,fecha_publicacion FROM libros WHERE id=?");
            
            ps.setInt(1,_id);
            rs= ps.executeQuery();
  
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String fechaPublicacion = rs.getString ("fecha_publicacion");

                 libros = new Libros(id,titulo, autor, fechaPublicacion);
                
            }
        
            return libros;
        }catch (SQLException e) {
            System.out.println("Error al mostrar producto: " + e.toString());
            return null;     
        }
     }
     
     public boolean  insertar (Libros libros){
    PreparedStatement  ps;
  
        try{
            
            ps=conexion.prepareStatement("INSERT INTO  libros(titulo,autor,fecha_publicacion) VALUES (?,?,?)");
            
            ps.setString(1,libros.getTitulo());
            ps.setString(2,libros.getAutor());
            ps.setString(3,libros.getFechaPublicacion());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
     }
     
     
     public boolean  actualizar(Libros libros){
    PreparedStatement  ps;
  
        try{
            
            ps=conexion.prepareStatement("UPDATE  libros SET titulo=?,autor=?,fecha_publicacion=? WHERE id=?");
            
            
            ps.setString(1,libros.getTitulo());
            ps.setString(2,libros.getAutor());
            ps.setString(3,libros.getFechaPublicacion());
            ps.setInt(4,libros.getId());
            
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
     }
     
     public boolean  eliminar( int _id){
    PreparedStatement  ps;
  
        try{
            
            ps=conexion.prepareStatement("DELETE FROM libros WHERE id=?");
            
            ps.setInt(1,_id);
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
     }
}
        
    
    

