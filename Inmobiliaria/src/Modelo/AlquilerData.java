/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aldana
 */
public class AlquilerData {
    private Connection connection = null;

    public AlquilerData(Conexion conexion)
    {
        try 
        {
            connection = conexion.getConexion();
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al obtener conexion");
        }
    }
    
    
    public void guardarAlquiler(Alquiler alquiler)
    {
        try
        {
            
            String sql = "INSERT INTO alquiler (idPersona, idInmueble, fechaInicio, finContrato, costo) VALUES ( ? , ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, alquiler.getIdPersona());
            statement.setInt(2, alquiler.getIdInmueble());
            statement.setDate(3, (Date) alquiler.getFechaInicio());
            statement.setDate(3, (Date) alquiler.getFinContrato());
            statement.setDouble(5, alquiler.getCosto());
            
            statement.executeUpdate();
            
            statement.close();
    
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al insertar un alquiler: " + ex.getMessage());
        }
    }
    
    public List<Alquiler> obtenerAlquileres()
    {
        List<Alquiler> alquileres = new ArrayList<Alquiler>();
            
        try
        {
            String sql = "SELECT * FROM alquiler;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            Alquiler alquiler;
            
            while(resultSet.next())
            {
                alquiler = new Alquiler();
                
                alquiler.setIdPersona(resultSet.getInt("idPersona"));
                alquiler.setIdInmueble(resultSet.getInt("idInmueble"));
                alquiler.setFechaInicio(resultSet.getDate("fechaInicio"));
                alquiler.setFinContrato(resultSet.getDate("finContrato"));
                alquiler.setCosto(resultSet.getDouble("costo"));

                alquileres.add(alquiler);
            }      
            statement.close();
        }
        catch (SQLException ex) {
            System.out.println("Error al obtener los alquileres: " + ex.getMessage());
        }
 
        return alquileres;
    }

    public void borrarAlquiler(int idPersona, int idInmueble)
    {
        try{
            
            String sql = "DELETE FROM alquiler WHERE idPersona =? AND idInmueble =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idPersona);
            statement.setInt(2, idInmueble);
  
            statement.executeUpdate();                       
            statement.close();
    
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al insertar un alquiler: " + ex.getMessage());
        }       
    }
    
    public void actualizarAlquiler(Alquiler alquiler)
    {
        try 
        {
            
            String sql = "UPDATE alquiler SET idPersona = ?, fechaInicio = ? , finContrato = ? , costo = ? WHERE idInmueble = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, alquiler.getIdPersona()); 
            statement.setDate(2, (Date) alquiler.getFechaInicio());
            statement.setDate(3, (Date) alquiler.getFinContrato());
            statement.setDouble(4, alquiler.getCosto());
            statement.setInt(5, alquiler.getIdInmueble());
            
            statement.executeUpdate();
            statement.close();
    
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al insertar un alquiler: " + ex.getMessage());
        }
    
    }
    
    public Alquiler buscarAlquiler(int idPersona, int idInmueble)
    {
      Alquiler alquiler=null;
        try
        {
            
            String sql = "SELECT * FROM alquiler WHERE idPersona =? AND idInmueble =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idPersona);
            statement.setInt(2, idInmueble);
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                alquiler = new Alquiler();
                
                alquiler.setIdPersona(resultSet.getInt("idPersona"));
                alquiler.setIdInmueble(resultSet.getInt("idInmueble"));
                alquiler.setFechaInicio(resultSet.getDate("fechaInicio"));
                alquiler.setFinContrato(resultSet.getDate("finContrato"));
                alquiler.setCosto(resultSet.getDouble("costo"));
     
            }      
            statement.close();        
        }catch (SQLException ex){
            System.out.println("Error al insertar un alquiler: " + ex.getMessage());
        }
        
        return alquiler;
    }

}
