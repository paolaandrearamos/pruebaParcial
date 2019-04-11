/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ClsCuenta;
import Dao.DaoGenerico;
import Modelo.ClsCliente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
/**
 *
 * @author Lizeth1304
 */
public class CtlCuenta {
      public static String tabla = "Cliente";

    public CtlCuenta() {
    }
     public String convertirGson(ClsCuenta cuenta) {
        Gson gson = new Gson();
        String objeto = gson.toJson(cuenta);
        return objeto;
    }

    public boolean guardar(ClsCuenta cuenta) {
        DaoGenerico dao = new DaoGenerico();
        String objeto = convertirGson(cuenta);
        return dao.guardar(objeto, tabla);
    }
    
     public ArrayList<ClsCuenta> listar() {
        DaoGenerico dao = new DaoGenerico();
        String res = dao.listarTodo(tabla);
        String respuesta = res.substring(0, res.length() - 2) + "]";
         System.out.println("Test these lines");
         System.out.println(respuesta);
        Gson json = new Gson();
        Type tipo = new TypeToken<ArrayList<ClsCuenta>>() {
        }.getType();
        ArrayList<ClsCuenta> clsCuenta = json.fromJson(respuesta, tipo);
        return clsCuenta;
    }
     
     public ClsCuenta SolicitudBuscar(int Cuenta_idCuenta) {
        
        DaoGenerico usuarioDAO = new DaoGenerico();
        //se consume el servicio
        String res = usuarioDAO.buscar(tabla, "Cuenta_idCuenta", String.valueOf(Cuenta_idCuenta));
        //Creamos el Gson
        Gson json = new Gson();
        //Convertimos la respuesta enviada desde el dao genérico y le decimos en clase lo queremos convertir
        //Primer valor es el json string que retornamos
        //Segundo valor es la clase en la que quieres convertir la cadena json
        //Es muy importante que los atributos de la ClUsuaio tengan el mismo nombre
        //que las  columnas de las tablas de la base de datos
        ClsCuenta usu = json.fromJson(res, ClsCuenta.class);
        return usu;
    }
}
