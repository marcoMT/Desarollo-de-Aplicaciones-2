
package mx.edu.utng.creadores.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.utng.creadores.dao.EstudianteDAO;
import mx.edu.utng.creadores.dao.EstudianteDAOImp;
import mx.edu.utng.creadores.model.Estudiante;

public class EstudianteController extends HttpServlet {
    public static final String LISTA_ESTUDIANTES = 
            "/lista_estudiantes.jsp";

    private static final String AGREGAR_O_CAMBIAR = "estudiante.jsp";
    
    private EstudianteDAO dao;
    
    public EstudianteController(){
        dao = new EstudianteDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String forward = "";
       String action = request.getParameter("action");
       if(action.equalsIgnoreCase("borrar")){
           forward = LISTA_ESTUDIANTES;
           int idEstudiante = Integer.parseInt(request.getParameter("idEstudiante"));
           dao.borrarEstudiante(idEstudiante);
           request.setAttribute("estudiantes",dao.desplegarEstudiantes());
       }
       else if(action.equalsIgnoreCase("cambiar")){
           forward = AGREGAR_O_CAMBIAR;
           int idEstudiante = Integer.parseInt(request.getParameter("idEstudiante"));
           Estudiante estudiante = dao.elegirEstudiante(idEstudiante);
           System.out.println(estudiante.toString());
           request.setAttribute("estudiante", estudiante);
           
       }else if (action.equalsIgnoreCase("agregar")){
           forward = AGREGAR_O_CAMBIAR;
           
       }else{
           forward = LISTA_ESTUDIANTES;
           request.setAttribute("estudiantes",dao.desplegarEstudiantes());
       }
       
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
       
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(request.getParameter("nombre"));
        estudiante.setApellidos(request.getParameter("apellidos"));
        estudiante.setCurso(request.getParameter("curso"));
        estudiante.setAnio(Integer.parseInt(request.getParameter("anio")));
        
        String idEstudiante = request.getParameter("idEstudiante");
        
        if(idEstudiante==null || idEstudiante.isEmpty()){
            dao.agregarEstudiante(estudiante);
            
        }else{
            estudiante.setIdEstudiante(Integer.parseInt(idEstudiante));
            dao.cambiarEstudiante(estudiante);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(LISTA_ESTUDIANTES);
        
        request.setAttribute("estudiantes", dao.desplegarEstudiantes());
        view.forward(request, response);
        
        
    }


}
