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
public class ClsCuenta {
  int idCliente, Persona_cedula,Cuenta_idCuenta,Cuenta_Tipo_cuenta_idTipo_cuenta;
          String password;

    public ClsCuenta() {
    }

    public ClsCuenta(int idCliente, int Persona_cedula, int Cuenta_idCuenta, int Cuenta_Tipo_cuenta_idTipo_cuenta, String password) {
        this.idCliente = idCliente;
        this.Persona_cedula = Persona_cedula;
        this.Cuenta_idCuenta = Cuenta_idCuenta;
        this.Cuenta_Tipo_cuenta_idTipo_cuenta = Cuenta_Tipo_cuenta_idTipo_cuenta;
        this.password = password;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getPersona_cedula() {
        return Persona_cedula;
    }

    public void setPersona_cedula(int Persona_cedula) {
        this.Persona_cedula = Persona_cedula;
    }

    public int getCuenta_idCuenta() {
        return Cuenta_idCuenta;
    }

    public void setCuenta_idCuenta(int Cuenta_idCuenta) {
        this.Cuenta_idCuenta = Cuenta_idCuenta;
    }

    public int getCuenta_Tipo_cuenta_idTipo_cuenta() {
        return Cuenta_Tipo_cuenta_idTipo_cuenta;
    }

    public void setCuenta_Tipo_cuenta_idTipo_cuenta(int Cuenta_Tipo_cuenta_idTipo_cuenta) {
        this.Cuenta_Tipo_cuenta_idTipo_cuenta = Cuenta_Tipo_cuenta_idTipo_cuenta;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  
    
    
    
}
