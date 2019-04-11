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
public class ClsSucursal {
    int idSucursal;
    String nombre;
    int Gerente_Sucursal_idGerente;
    String direccion;
    String municipio;

    public int getIdsucursal() {
        return idSucursal;
    }

    public void setIdsucursal(int idsucursal) {
        this.idSucursal = idsucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGerente_Sucursal_idGerente() {
        return Gerente_Sucursal_idGerente;
    }

    public void setGerente_Sucursal_idGerente(int Gerente_Sucursal_idGerente) {
        this.Gerente_Sucursal_idGerente = Gerente_Sucursal_idGerente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public ClsSucursal(int idsucursal, String nombre, int Gerente_Sucursal_idGerente, String direccion, String municipio) {
        this.idSucursal = idsucursal;
        this.nombre = nombre;
        this.Gerente_Sucursal_idGerente = Gerente_Sucursal_idGerente;
        this.direccion = direccion;
        this.municipio = municipio;
    }

    
  
     @Override
    public String toString() {
        return nombre; //To change body of generated methods, choose Tools | Templates.
    }
    
}
