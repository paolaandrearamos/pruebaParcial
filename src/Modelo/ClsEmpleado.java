/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author paola
 */
public class ClsEmpleado {
       int cedula;
   String nombre;
  String apellido;
  String fecha_nacimiento;
  String ciudad;
  String correo;
  String telefono;
  int Cargo_idCargo;
  int Sucursal_idSucursal;
          
//  String oficio=null;

    public ClsEmpleado(int cedula, String nombre, String apellido, String fecha_nacimiento, String ciudad, String correo, String telefono, int Cargo_idCargo, int Sucursal_idSucursal) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.ciudad = ciudad;
        this.correo = correo;
        this.telefono = telefono;
        this.Cargo_idCargo = Cargo_idCargo;
        this.Sucursal_idSucursal = Sucursal_idSucursal;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCargo_idCargo() {
        return Cargo_idCargo;
    }

    public void setCargo_idCargo(int Cargo_idCargo) {
        this.Cargo_idCargo = Cargo_idCargo;
    }

    public int getSucursal_idSucursal() {
        return Sucursal_idSucursal;
    }

    public void setSucursal_idSucursal(int Sucursal_idSucursal) {
        this.Sucursal_idSucursal = Sucursal_idSucursal;
    }

}
