/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author paola
 */
public class ClsCostos {
    int idCosto;
    String nombre;
     Double monto;

    public ClsCostos(int idCosto, String nombre, Double monto) {
        this.idCosto = idCosto;
        this.nombre = nombre;
        this.monto = monto;
    }

    public int getIdCosto() {
        return idCosto;
    }

    public void setIdCosto(int idCosto) {
        this.idCosto = idCosto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
     @Override
    public String toString() {
        return nombre; //To change body of generated methods, choose Tools | Templates.
    }  
}
