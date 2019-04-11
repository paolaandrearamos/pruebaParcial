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
public class Movimiento {
    Double monto;
    int idMovimiento;

    public Movimiento() {
    }

    public Movimiento(Double monto, int idMovimiento) {
        this.monto = monto;
        this.idMovimiento = idMovimiento;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }
    
    
}
