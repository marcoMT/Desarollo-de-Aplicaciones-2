/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.creadores.dao;

import java.util.List;
import mx.edu.utng.creadores.model.Creador;

/**
 *
 * @author Marco Antonio Mendiola Torres markochiva@gmail.com
 */
public interface CreadorDAO {
     void agregarCreador(Creador creador);
    void borrarCreador(int idCreador);
    void cambiarCreador(Creador creador);
    List<Creador> desplegarCreadores();
    Creador elegirCreador(int idCreador);
    
}
