/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.creadores.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.utng.creadores.dao.CreadorDAO;
import mx.edu.utng.creadores.dao.CreadorDAOImp;
import mx.edu.utng.creadores.model.Creador;

/**
 *
 * @author Marco Antonio Mendiola Torres markochiva@gmail.com
 */
public class CreadorController extends HttpServlet{
    
    public static final String LISTA_CREADORES = 
            "/lista_creadores.jsp";

    private static final String AGREGAR_O_CAMBIAR = "creador.jsp";
    
    private CreadorDAO dao;
    
    public CreadorController(){
        dao = new CreadorDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               String forward = "";
       String action = request.getParameter("action");
       if(action.equalsIgnoreCase("borrar")){
           forward = LISTA_CREADORES;
           int idCreador = Integer.parseInt(request.getParameter("idCreador"));
           dao.borrarCreador(idCreador);
           request.setAttribute("creadores",dao.desplegarCreadores());
       }
       else if(action.equalsIgnoreCase("cambiar")){
           forward = AGREGAR_O_CAMBIAR;
           int idCreador = Integer.parseInt(request.getParameter("idCreador"));
           Creador creador = dao.elegirCreador(idCreador);
           System.out.println(creador.toString());
           request.setAttribute("creador", creador);
           
       }else if (action.equalsIgnoreCase("agregar")){
           forward = AGREGAR_O_CAMBIAR;
           
       }else{
           forward = LISTA_CREADORES;
           request.setAttribute("creadores",dao.desplegarCreadores());
       }
       
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Creador creador = new Creador();
        creador.setNombre(request.getParameter("nombre"));
        creador.setApellido(request.getParameter("apellido"));
        creador.setFiliacion(request.getParameter("filiacion"));
        creador.setArea_actualizacion(request.getParameter("area_actualizacion"));
        
        String idCreador = request.getParameter("idCreador");
        
        if(idCreador==null || idCreador.isEmpty()){
            dao.agregarCreador(creador);
            
        }else{
            creador.setIdCreador(Integer.parseInt(idCreador));
            dao.cambiarCreador(creador);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(LISTA_CREADORES);
        
        request.setAttribute("creadores", dao.desplegarCreadores());
        view.forward(request, response);
    }
    
    
    
}
