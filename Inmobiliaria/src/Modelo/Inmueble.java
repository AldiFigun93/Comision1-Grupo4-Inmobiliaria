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
public class Inmueble {
    private int idInmueble;
    private String direccion;
    private int cantAmbientes;
    private int costo;
    private boolean disponible;
    private int idPropietario;

    public Inmueble(int idInmueble, String direccion, int cantAmbientes, int costo, boolean disponible, int idPropietario) {
        this.idInmueble = idInmueble;
        this.direccion = direccion;
        this.cantAmbientes = cantAmbientes;
        this.costo = costo;
        this.disponible = disponible;
        this.idPropietario = idPropietario;
    }

    public Inmueble(String direccion, int cantAmbientes, int costo, boolean disponible, int idPropietario) {
        this.idInmueble = -1;
        this.direccion = direccion;
        this.cantAmbientes = cantAmbientes;
        this.costo = costo;
        this.disponible = disponible;
        this.idPropietario = idPropietario;
    }

    Inmueble() {
        this.idInmueble = -1;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantAmbientes() {
        return cantAmbientes;
    }

    public void setCantAmbientes(int cantAmbientes) {
        this.cantAmbientes = cantAmbientes;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

}
