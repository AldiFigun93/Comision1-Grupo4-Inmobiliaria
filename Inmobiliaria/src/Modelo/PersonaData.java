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
public class PersonaData {
    private Connection connection = null;

    public PersonaData(Conexion conexion)
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
    
    
    public void guardarPersona(Persona persona)
    {
        try
        {
            
            String sql = "INSERT INTO persona (nombreCompleto, dni, celular, idPropietario) VALUES ( ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, persona.getNombreCompleto());
            statement.setString(2, persona.getDni());
            statement.setString(3, persona.getCelular());
            statement.setInt(4, persona.getIdPropietario());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) 
            {
                persona.setIdPersona(rs.getInt(1));
            }
            else 
            {
                System.out.println("No se pudo obtener el id luego de insertar una persona");
            }
            statement.close();
    
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al insertar una persona: " + ex.getMessage());
        }
    }
    
    public List<Persona> obtenerPersonas()
    {
        List<Persona> personas = new ArrayList<Persona>();
            
        try
        {
            String sql = "SELECT * FROM persona;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Persona persona;
            
            while(resultSet.next())
            {
                persona = new Persona();
                
                persona.setIdPersona(resultSet.getInt("idPersona"));
                persona.setNombreCompleto(resultSet.getString("nombreCompleto"));
                persona.setDni(resultSet.getString("dni"));
                persona.setCelular(resultSet.getString("celular"));
                persona.setIdPropietario(resultSet.getInt("idPropietario"));

                personas.add(persona);
            }      
            statement.close();
        }
        catch (SQLException ex) {
            System.out.println("Error al obtener las personas: " + ex.getMessage());
        }
 
        return personas;
    }

    public void borrarPersona(int id)
    {
        try{
            
            String sql = "DELETE FROM persona WHERE idPersona =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
  
            statement.executeUpdate();                       
            statement.close();
    
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al insertar una persona: " + ex.getMessage());
        }       
    }
    
    public void actualizarPersona(Persona persona)
    {
        try 
        {
            
            String sql = "UPDATE persona SET nombreCompleto = ?, dni = ? , celular = ?, idPropietario = ? WHERE idPersona = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, persona.getNombreCompleto());
            statement.setString(2, persona.getDni());    
            statement.setString(3, persona.getCelular());
            statement.setInt(4, persona.getIdPropietario());
            statement.setInt(5, persona.getIdPersona());
            
            statement.executeUpdate();
            statement.close();
    
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al insertar una persona: " + ex.getMessage());
        }
    
    }
    
    public Persona buscarPersona(int id)
    {
      Persona persona=null;
        try
        {
            
            String sql = "SELECT * FROM persona WHERE idPersona =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                persona = new Persona();
                persona.setIdPersona(resultSet.getInt("idPersona"));
                persona.setNombreCompleto(resultSet.getString("nombreCompleto"));
                persona.setDni(resultSet.getString("dni"));             
                persona.setCelular(resultSet.getString("celular"));
                persona.setIdPropietario(resultSet.getInt("idPropietario"));
     
            }      
            statement.close();        
        }catch (SQLException ex){
            System.out.println("Error al insertar una persona: " + ex.getMessage());
        }
        
        return persona;
    }
    
}
