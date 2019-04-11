/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Lizeth1304
 */
public class ClsConsignacion {
    double monto;
    String password;
    
    int cuenta_destino,cuenta_origen;

    public ClsConsignacion() {
    }

    public ClsConsignacion(double monto, String password, int cuenta_origen, int cuenta_destino) {
        this.monto = monto;
        this.password = password;
        this.cuenta_origen = cuenta_origen;
        this.cuenta_destino = cuenta_destino;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCuenta_origen() {
        return cuenta_origen;
    }

    public void setCuenta_origen(int cuenta_origen) {
        this.cuenta_origen = cuenta_origen;
    }

    public int getCuenta_destino() {
        return cuenta_destino;
    }

    public void setCuenta_destino(int cuenta_destino) {
        this.cuenta_destino = cuenta_destino;
    }
    
    
}
