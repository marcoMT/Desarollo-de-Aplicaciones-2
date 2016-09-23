/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.creadores.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.edu.utng.creadores.model.Creador;
import mx.edu.utng.creadores.util.UtilDB;

/**
 *
 * @author Marco Antonio Mendiola Torres markochiva@gmail.com
 */
public class CreadorDAOImp implements CreadorDAO{
    private Connection connection;
    
    public CreadorDAOImp(){
        connection = UtilDB.getConnection();
    }

    @Override
    public void agregarCreador(Creador creador) {
        try {
            String query = "INSERT INTO creadores (nombre,apellido,filiacion,area_actualizacion) VALUES (?,?,?,?)";
            PreparedStatement ps =connection.prepareStatement(query);
            ps.setString(1, creador.getNombre());
            ps.setString(2, creador.getApellido());
            ps.setString(3, creador.getFiliacion());
            ps.setString(4, creador.getArea_actualizacion());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarCreador(int idCreador) {
         try {
            String query = "DELETE FROM creadores WHERE id_creador = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idCreador);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarCreador(Creador creador) {
        try {
            String query = "UPDATE creadores SET nombre = ?,apellido = ?,filiacion = ?,area_actualizacion = ? WHERE id_creador = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, creador.getNombre());
            ps.setString(2, creador.getApellido());
            ps.setString(3, creador.getFiliacion());
            ps.setString(4, creador.getArea_actualizacion());
            ps.setInt(5, creador.getIdCreador());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Creador> desplegarCreadores() {
        List <Creador> creadores = new ArrayList<Creador>();
        
        try {
        if(connection!= null){
            Statement statement = connection.createStatement();
            ResultSet resultSet =statement.executeQuery("SELECT * FROM creadores");
            
            while(resultSet.next()){
                Creador creador = new Creador(
                resultSet.getInt("id_creador"),
                resultSet.getString("nombre"),
                resultSet.getString("apellido"),
                resultSet.getString("filiacion"),
                resultSet.getString("area_actualizacion"));
                creadores.add(creador);
            }
            resultSet.close();
            statement.close();
            
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return creadores;
    }

    @Override
    public Creador elegirCreador(int idCreador) {
        Creador creador = new Creador();
        
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM creadores WHERE id_creador = ?");
            statement.setInt(1, idCreador);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                creador.setIdCreador(resultSet.getInt("id_creador"));
                creador.setNombre(resultSet.getString("nombre"));
                creador.setApellido(resultSet.getString("apellido"));
                creador.setFiliacion(resultSet.getString("filiacion"));
                creador.setArea_actualizacion(resultSet.getString("area_actualizacion"));
            }
            resultSet.close();
            statement.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return creador;
    }
    
    
}
