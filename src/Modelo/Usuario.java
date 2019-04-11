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
public class Usuario {
    int Persona_cedula,password;

    public Usuario() {
    }

    public Usuario(int Persona_cedula, int password) {
        this.Persona_cedula = Persona_cedula;
        this.password = password;
    }

    public int getPersona_cedula() {
        return Persona_cedula;
    }

    public void setPersona_cedula(int Persona_cedula) {
        this.Persona_cedula = Persona_cedula;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
    
}
