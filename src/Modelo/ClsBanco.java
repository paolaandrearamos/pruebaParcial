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
public class ClsBanco {
  
    int idBanco;
    String nombre_banco;
    int nit;
    String mision;
    String vision;
    String direccion;

    public ClsBanco(int idbanco, String nombre_banco, int nit, String mision, String vision, String direccion) {
        this.idBanco = idbanco;
        this.nombre_banco = nombre_banco;
        this.nit = nit;
        this.mision = mision;
        this.vision = vision;
        this.direccion = direccion;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idbanco) {
        this.idBanco = idbanco;
    }

    public String getNombre_banco() {
        return nombre_banco;
    }

    public void setNombre_banco(String nombre_banco) {
        this.nombre_banco = nombre_banco;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return nombre_banco; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
