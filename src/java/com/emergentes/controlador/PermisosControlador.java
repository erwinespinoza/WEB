
package com.emergentes.controlador;

import com.emergentes.dao.PermisosDAO;
import com.emergentes.dao.PermisosDAOimpl;
import com.emergentes.modelo.Permisos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PermisosControlador", urlPatterns = {"/PermisosControlador"})
public class PermisosControlador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Permisos cli = new Permisos();
            int id;
           PermisosDAO dao = new PermisosDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            
            switch(action){
                case "add":
                    request.setAttribute("permisos", cli);
                    request.getRequestDispatcher("frmpermisos.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    cli =  dao.getById(id);
                    request.setAttribute("permisos", cli);
                    request.getRequestDispatcher("frmpermisos.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("PermisosControlador");
                    break;
                case "view":
                    // Obtener la lista de registros
                    List<Permisos> lista = dao.getAll();
                    request.setAttribute("permisos",lista);
                    request.getRequestDispatcher("permisos.jsp").forward(request, response);
                    break;
            }
            
        }catch(Exception ex){
            System.out.println("Error " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");

        
        Permisos cli = new Permisos();
        
        cli.setId(id);
        cli.setDescripcion(descripcion);
        
        PermisosDAO dao = new PermisosDAOimpl();
        if (id == 0){
            try {
                // Nuevo registro
                dao.insert(cli);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ex.getMessage());
            }
        }
        else{
            try {
                // Edicion de registro
                dao.update(cli);
            } catch (Exception ex) {
                System.out.println("Error al editar "+ex.getMessage());
            }
        }
        response.sendRedirect("PermisosControlador");
    }

}
