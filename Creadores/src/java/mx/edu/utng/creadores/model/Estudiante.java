/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.creadores.model;

/**
 *
 * @author Marco Antonio Mendiola Torres markochiva@gmail.com
 */
public class Estudiante {
    private String nombre;
    private String apellidos;
    private String curso;
    private int anio;
    private int idEstudiante;

    public Estudiante() {
        this(0,"","","",0);
    }

    public Estudiante(int idEstudiante,String nombre, String apellidos, String curso, int anio) {
         this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        this.anio = anio;
       
    }
    

    
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", curso=" + curso + ", anio=" + anio + ", idEstudiante=" + idEstudiante + '}';
    }

    
    
   
    
    
}
