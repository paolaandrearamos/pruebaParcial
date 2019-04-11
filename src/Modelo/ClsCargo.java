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
public class ClsCargo {
     int idCargo;
   String nombre;
  String horario;
  Double salario;
  String descripcion;
  int Banco_idBanco;

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getBanco_idBanco() {
        return Banco_idBanco;
    }

    public void setBanco_idBanco(int Banco_idBanco) {
        this.Banco_idBanco = Banco_idBanco;
    }

    public ClsCargo(int idCargo, String nombre, String horario, Double salario, String descripcion, int Banco_idBanco) {
        this.idCargo = idCargo;
        this.nombre = nombre;
        this.horario = horario;
        this.salario = salario;
        this.descripcion = descripcion;
        this.Banco_idBanco = Banco_idBanco;
    }

    @Override
    public String toString() {
        return nombre; //To change body of generated methods, choose Tools | Templates.
    }
}
