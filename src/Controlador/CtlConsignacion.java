/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.DaoGenerico;
import Modelo.ClsCliente;
import Modelo.ClsConsignacion;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author Lizeth1304
 */
public class CtlConsignacion {
     public static String tabla = "Consignacion";

    public CtlConsignacion() {
    }
     public String convertirGson(ClsConsignacion consignacion) {
        Gson gson = new Gson();
        String objeto = gson.toJson(consignacion);
        return objeto;
    }

    public boolean guardar(ClsConsignacion consignacion) {
        DaoGenerico dao = new DaoGenerico();
        String objeto = convertirGson(consignacion);
        return dao.guardar(objeto, tabla);
    }
    
     public ArrayList<ClsConsignacion> listar() {
        DaoGenerico dao = new DaoGenerico();
        String res = dao.listarTodo(tabla);
        String respuesta = res.substring(0, res.length() - 2) + "}]";
         System.out.println("Test these lines");
         System.out.println(respuesta);
        Gson json = new Gson();
        Type tipo = new TypeToken<ArrayList<ClsConsignacion>>() {
        }.getType();
        ArrayList<ClsConsignacion> clsConsignacion = json.fromJson(respuesta, tipo);
        return clsConsignacion;
    }
     
     public ClsConsignacion SolicitudBuscar(int cuenta) {
        
        DaoGenerico usuarioDAO = new DaoGenerico();
        //se consume el servicio
        String res = usuarioDAO.buscar(tabla, "cuenta_origen", String.valueOf(cuenta));
        //Creamos el Gson
        Gson json = new Gson();
        //Convertimos la respuesta enviada desde el dao genérico y le decimos en clase lo queremos convertir
        //Primer valor es el json string que retornamos
        //Segundo valor es la clase en la que quieres convertir la cadena json
        //Es muy importante que los atributos de la ClUsuaio tengan el mismo nombre
        //que las  columnas de las tablas de la base de datos
        ClsConsignacion usu = json.fromJson(res, ClsConsignacion.class);
        return usu;
    }
//     
//     public boolean SolicitudModificar(int cedula, int telefono, String nombre, String apellido,  String ciudad, String correo, String oficio) {
//        DaoGenerico DAO = new DaoGenerico();
//        String objeto = convertirGson(cedula);
//        return DAO.modificar(objeto, tabla, "cedula", String.valueOf(cliente.getCedula()));
//    }
    
    
}
