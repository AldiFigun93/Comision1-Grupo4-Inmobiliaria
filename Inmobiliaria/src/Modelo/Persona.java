/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Aldana
 */
public class Persona {
    private int idPersona;
    private String nombreCompleto;
    private String dni;
    private String celular;
    private int idPropietario;

    public Persona(int idPersona, String nombreCompleto, String dni, String celular, int idPropietario) {
        this.idPersona = idPersona;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.celular = celular;
        this.idPropietario = idPropietario;
    }
    
    public Persona(String nombreCompleto, String dni, String celular, int idPropietario) {
        this.idPersona = -1;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.celular = celular;
        this.idPropietario = idPropietario;
    }

    Persona() {
        this.idPersona = -1;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }
    
}
