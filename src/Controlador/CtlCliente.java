/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.DaoGenerico;
import Modelo.ClsCliente;
import Vista.Cliente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author Lizeth1304
 */
public class CtlCliente {
    public static String tabla = "Persona";

    public CtlCliente() {
    }
     public String convertirGson(ClsCliente cliente) {
        Gson gson = new Gson();
        String objeto = gson.toJson(cliente);
        return objeto;
    }

    public boolean guardar(ClsCliente cliente) {
        DaoGenerico dao = new DaoGenerico();
        String objeto = convertirGson(cliente);
        return dao.guardar(objeto, tabla);
    }
    
     public ArrayList<ClsCliente> listar() {
        DaoGenerico dao = new DaoGenerico();
        String res = dao.listarTodo(tabla);
        String respuesta = res.substring(0, res.length() - 2) + "]";
         System.out.println("Test these lines");
         System.out.println(respuesta);
        Gson json = new Gson();
        Type tipo = new TypeToken<ArrayList<ClsCliente>>() {
        }.getType();
        ArrayList<ClsCliente> clsCliente = json.fromJson(respuesta, tipo);
        return clsCliente;
    }
     
     public ClsCliente SolicitudBuscar(int cedula) {
        
        DaoGenerico usuarioDAO = new DaoGenerico();
        //se consume el servicio
        String res = usuarioDAO.buscar(tabla, "cedula", String.valueOf(cedula));
        //Creamos el Gson
        Gson json = new Gson();
        //Convertimos la respuesta enviada desde el dao genérico y le decimos en clase lo queremos convertir
        //Primer valor es el json string que retornamos
        //Segundo valor es la clase en la que quieres convertir la cadena json
        //Es muy importante que los atributos de la ClUsuaio tengan el mismo nombre
        //que las  columnas de las tablas de la base de datos
        ClsCliente usu = json.fromJson(res, ClsCliente.class);
        return usu;
    }
//     
//     public boolean SolicitudModificar(int cedula, int telefono, String nombre, String apellido,  String ciudad, String correo, String oficio) {
//        DaoGenerico DAO = new DaoGenerico();
//        String objeto = convertirGson(cedula);
//        return DAO.modificar(objeto, tabla, "cedula", String.valueOf(cliente.getCedula()));
//    }
    
     public boolean SolicitudModificar(int cedula, int telefono, String nombre, String fecha_nacimiento,String apellido, String ciudad, String correo, String oficio) {
        ClsCliente usuario = new ClsCliente(cedula, telefono, nombre, apellido,null, ciudad, correo, oficio);
        DaoGenerico usuDAO = new DaoGenerico();
        String objeto = convertirGson(usuario);
        return usuDAO.modificar(objeto, tabla);
    }
}
