/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
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
public class InmuebleData {
    private Connection connection = null;

    public InmuebleData(Conexion conexion)
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
    
    
    public void guardarInmueble(Inmueble inmueble)
    {
        try
        {
            
            String sql = "INSERT INTO inmueble (direccion, cantAmbientes, costo, disponible, idPropietario) VALUES ( ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, inmueble.getDireccion());
            statement.setInt(2, inmueble.getCantAmbientes());
            statement.setInt(3, inmueble.getCosto());
            statement.setBoolean(4, inmueble.isDisponible());
            statement.setInt(5, inmueble.getIdPropietario());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) 
            {
                inmueble.setIdInmueble(rs.getInt(1));
            }
            else 
            {
                System.out.println("No se pudo obtener el id luego de insertar un cliente");
            }
            statement.close();
    
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al insertar un inmueble: " + ex.getMessage());
        }
    }
    
    public List<Inmueble> obtenerInmuebles()
    {
        List<Inmueble> inmuebles = new ArrayList<Inmueble>();
            
        try
        {
            String sql = "SELECT * FROM inmueble;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Inmueble inmueble;
            
            while(resultSet.next())
            {
                inmueble = new Inmueble();
                
                inmueble.setIdInmueble(resultSet.getInt("idInmueble"));
                inmueble.setDireccion(resultSet.getString("direccion"));
                inmueble.setCantAmbientes(resultSet.getInt("cantAmbientes"));
                inmueble.setCosto(resultSet.getInt("costo"));
                inmueble.setDisponible(resultSet.getBoolean("disponible"));
                inmueble.setIdPropietario(resultSet.getInt("idPropietario"));

                inmuebles.add(inmueble);
            }      
            statement.close();
        }
        catch (SQLException ex) {
            System.out.println("Error al obtener los inmuebles: " + ex.getMessage());
        }
 
        return inmuebles;
    }

    public void borrarInmueble(int id)
    {
        try{
            
            String sql = "DELETE FROM inmueble WHERE idInmueble =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
  
            statement.executeUpdate();                       
            statement.close();
    
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al insertar un inmueble: " + ex.getMessage());
        }       
    }
    
    public void actualizarInmueble(Inmueble inmueble)
    {
        try 
        {
            
            String sql = "UPDATE inmueble SET direccion = ?, cantAmbientes = ? ,costo = ?, disponible = ?, idPropietario = ? WHERE idInmueble = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, inmueble.getDireccion());
            statement.setInt(2, inmueble.getCantAmbientes());    
            statement.setInt(3, inmueble.getCosto());
            statement.setInt(4, inmueble.getIdInmueble());
            statement.setBoolean(5, inmueble.isDisponible());
            statement.setInt(6, inmueble.getIdPropietario());
            
            statement.executeUpdate();
            statement.close();
    
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al insertar un inmueble: " + ex.getMessage());
        }
    
    }
    
    public Inmueble buscarInmueble(int id) {
      Inmueble inmueble = null;
        try
        {
            
            String sql = "SELECT * FROM inmueble WHERE idInmueble =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                inmueble = new Inmueble();
                inmueble.setIdInmueble(resultSet.getInt("idInmueble"));
                inmueble.setDireccion(resultSet.getString("direccion"));
                inmueble.setCantAmbientes(resultSet.getInt("cantAmbientes"));             
                inmueble.setCosto(resultSet.getInt("costo"));
                inmueble.setDisponible(resultSet.getBoolean("disponible"));
                inmueble.setIdPropietario(resultSet.getInt("idPropietario"));
            }  
            
            statement.close();        
            
        }
        catch (SQLException ex){
            System.out.println("Error al insertar un inmueble: " + ex.getMessage());
        }
        
        return inmueble;
    }
    
}
