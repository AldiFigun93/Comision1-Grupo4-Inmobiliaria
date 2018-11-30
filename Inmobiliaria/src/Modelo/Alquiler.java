/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Aldana
 */
public class Alquiler {
    private int idPersona;
    private int idInmueble;
    private java.util.Date fechaInicio;
    private java.util.Date finContrato;
    private double costo;

    public Alquiler(int idPersona, int idInmueble, Date fechaInicio, Date finContrato, double costo) {
        this.idPersona = idPersona;
        this.idInmueble = idInmueble;
        this.fechaInicio = fechaInicio;
        this.finContrato = finContrato;
        this.costo = costo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Date getFinContrato() {
        return finContrato;
    }

    public void setFinContrato(Date finContrato) {
        this.finContrato = finContrato;
    } 
}
