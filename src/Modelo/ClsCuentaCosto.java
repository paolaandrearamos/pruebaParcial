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
public class ClsCuentaCosto {

    int idCuenta_costo;
    String descripcion;
    int Tipo_cuenta_idTipo_cuenta;
    int Costo_idCosto;

    public ClsCuentaCosto(int idCuenta_costo, String descripcion, int Tipo_cuenta_idTipo_cuenta, int Costo_idCosto) {
        this.idCuenta_costo = idCuenta_costo;
        this.descripcion = descripcion;
        this.Tipo_cuenta_idTipo_cuenta = Tipo_cuenta_idTipo_cuenta;
        this.Costo_idCosto = Costo_idCosto;
    }

    public int getIdCuenta_costo() {
        return idCuenta_costo;
    }

    public void setIdCuenta_costo(int idCuenta_costo) {
        this.idCuenta_costo = idCuenta_costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTipo_cuenta_idTipo_cuenta() {
        return Tipo_cuenta_idTipo_cuenta;
    }

    public void setTipo_cuenta_idTipo_cuenta(int Tipo_cuenta_idTipo_cuenta) {
        this.Tipo_cuenta_idTipo_cuenta = Tipo_cuenta_idTipo_cuenta;
    }

    public int getCosto_idCosto() {
        return Costo_idCosto;
    }

    public void setCosto_idCosto(int Costo_idCosto) {
        this.Costo_idCosto = Costo_idCosto;
    }

}
