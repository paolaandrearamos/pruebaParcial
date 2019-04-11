/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.DaoGenerico;
import Modelo.Usuario;
import com.google.gson.Gson;

/**
 *
 * @author Lizeth1304
 */
public class CtlUsuario {
     String tabla = "Cliente";

    public CtlUsuario() {
    }

    public String convertitGson(Usuario us) {
        Gson gson = new Gson();
        String objeto = gson.toJson(us);
        return objeto;
    }

    public Usuario login(int user, int pass) {
        String consulta = "select * from " + tabla + " where Persona_cedula='" + user + "' and password='" + pass + "'";
        DaoGenerico usuarioDAO = new DaoGenerico();
        String res = usuarioDAO.login(consulta);
        Gson json = new Gson();
        Usuario usuario = json.fromJson(res, Usuario.class);
        return usuario;
    }
    
    public boolean guardar(Usuario usuario){
        DaoGenerico dao = new DaoGenerico();
        String objeto = convertitGson(usuario);
        return dao.guardar(objeto, tabla);
    }
    
    public Usuario SolicitudBuscar(int Persona_cedula) {
        DaoGenerico usuarioDAO = new DaoGenerico();
        String res = usuarioDAO.buscar(tabla, "idCliente", String.valueOf(Persona_cedula));
        Gson json = new Gson();
        Usuario mar = json.fromJson(res, Usuario.class);
        return mar;
    }
    

}
