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
public class ClsTipoCuenta {
     int idTipo_cuenta;
  String descripcion;

    public ClsTipoCuenta(int idTipo_cuenta, String descripcion) {
        this.idTipo_cuenta = idTipo_cuenta;
        this.descripcion = descripcion;
    }

    public int getIdTipo_cuenta() {
        return idTipo_cuenta;
    }

    public void setIdTipo_cuenta(int idTipo_cuenta) {
        this.idTipo_cuenta = idTipo_cuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public String toString() {
        return descripcion; //To change body of generated methods, choose Tools | Templates.
    }
}
