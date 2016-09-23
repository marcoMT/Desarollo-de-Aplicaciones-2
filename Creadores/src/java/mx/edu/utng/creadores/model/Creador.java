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
public class Creador {
    private int idCreador;
    private String nombre;
    private String apellido;
    private String filiacion;
    private String area_actualizacion;
    
    public Creador(){
        this(0,"","","","");
    }

    public Creador(int idCreador, String nombre, String apellido, String filiacion, String area_actualizacion) {
        this.idCreador = idCreador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.filiacion = filiacion;
        this.area_actualizacion = area_actualizacion;
    }

    public int getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(int idCreador) {
        this.idCreador = idCreador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFiliacion() {
        return filiacion;
    }

    public void setFiliacion(String filiacion) {
        this.filiacion = filiacion;
    }

    public String getArea_actualizacion() {
        return area_actualizacion;
    }

    public void setArea_actualizacion(String area_actualizacion) {
        this.area_actualizacion = area_actualizacion;
    }

    @Override
    public String toString() {
        return "Creador{" + "idCreador=" + idCreador + ", nombre=" + nombre + ", apellido=" + apellido + ", filiacion=" + filiacion + ", area_actualizacion=" + area_actualizacion + '}';
    }
    
    
    
    
    
}
