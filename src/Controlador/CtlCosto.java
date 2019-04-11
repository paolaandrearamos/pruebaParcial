/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.DaoGenerico;
import Modelo.ClsBanco;
import Modelo.ClsCostos;
import Modelo.ClsTipoCuenta;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author paola
 */
public class CtlCosto {
    String tabla = "Costo";

    public CtlCosto() {
    }
     public String convertirGson(ClsCostos costo) {
        Gson gson = new Gson();
        String objeto = gson.toJson(costo);
        return objeto;
    }

    public boolean guardar(ClsCostos costo) {
        DaoGenerico dao = new DaoGenerico();
        String objeto = convertirGson(costo);
        return dao.guardar(objeto, tabla);
    }

    public ArrayList<ClsCostos> listar() {
        DaoGenerico dao = new DaoGenerico();
        String res = dao.listarTodo(tabla);
        Gson json = new Gson();
        Type tipo = new TypeToken<ArrayList<ClsCostos>>() {
        }.getType();
        ArrayList<ClsCostos> tipos = json.fromJson(res, tipo);
        return tipos;
    }
   
}
