/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.creadores.dao;

import java.util.List;
import mx.edu.utng.creadores.model.Estudiante;

/**
 *
 * @author Marco Antonio Mendiola Torres markochiva@gmail.com
 */
public interface EstudianteDAO {
    void agregarEstudiante(Estudiante estudiante);
    void borrarEstudiante(int idEstudiante);
    void cambiarEstudiante(Estudiante estudiante);
    List<Estudiante> desplegarEstudiantes();
    Estudiante elegirEstudiante(int idEstudiante);
}
