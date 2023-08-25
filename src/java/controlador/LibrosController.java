package controlador;

import java.io.IOException;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Libros;
import modelo.LibrosDAO;

/**
 *
 * @author Cortez
 */
@WebServlet(name = "LibrosController", urlPatterns = {"/LibrosController"})
public class LibrosController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        LibrosDAO librosDAO = new LibrosDAO();
        String accion;
        RequestDispatcher dispatcher=null;
        
        accion=request.getParameter("accion");
        
        if(accion==null||accion.isEmpty()){
            dispatcher=request.getRequestDispatcher("vistas/index.jsp");
       
        List<Libros>listalibros =librosDAO.listarLibros();
         request.setAttribute("lista",listalibros);
        
        }else if("nuevo".equals(accion)){
             dispatcher=request.getRequestDispatcher("vistas/nuevo.jsp");
             
        }else if("insertar".equals(accion)){
            
            String titulo=request.getParameter("titulo");
            String autor=request.getParameter("autor");
            String fechaPublicacion=request.getParameter("fechaPublicacion");
            
            Libros libros = new Libros(0,titulo, autor, fechaPublicacion);
            
            librosDAO.insertar(libros);
             dispatcher=request.getRequestDispatcher("vistas/index.jsp");
             List<Libros>listalibros =librosDAO.listarLibros();
             
         request.setAttribute("lista",listalibros);
         
        }else if("modificar".equals(accion)){
             dispatcher=request.getRequestDispatcher("vistas/modificar.jsp");
             
              int id =Integer.parseInt(request.getParameter("id"));
              Libros libros =librosDAO.mostrarLibros(id);
              request.setAttribute("libros",libros);
              
              
        }else if("actualizar".equals(accion)){
           int id =Integer.parseInt(request.getParameter("id"));
           
            String titulo=request.getParameter("titulo");
            String autor=request.getParameter("autor");
            String fechaPublicacion=request.getParameter("fechaPublicacion");
            
            Libros libros = new Libros(id,titulo, autor, fechaPublicacion);
           librosDAO.actualizar(libros);
             dispatcher=request.getRequestDispatcher("vistas/index.jsp");
             List<Libros>listalibros =librosDAO.listarLibros();
         request.setAttribute("lista",listalibros);
        
         
         
        }else if("eliminar".equals(accion)){
          int id =Integer.parseInt(request.getParameter("id"));
           librosDAO.eliminar(id);
             dispatcher=request.getRequestDispatcher("vistas/index.jsp");
             List<Libros>listalibros =librosDAO.listarLibros();
         request.setAttribute("lista",listalibros);
         
         
        } else {
            dispatcher=request.getRequestDispatcher("vistas/index.jsp");
             List<Libros>listalibros =librosDAO.listarLibros();
         request.setAttribute("lista",listalibros);
        }
        dispatcher.forward(request,response);
     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
      
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
