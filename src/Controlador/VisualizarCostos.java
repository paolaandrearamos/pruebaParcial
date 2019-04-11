/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.DaoGenerico;
import Modelo.ClsCuentaCosto;
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
public class VisualizarCostos {
      String tabla = "Cuenta_costo";
 public ArrayList<ClsCuentaCosto> listar() {
        DaoGenerico dao = new DaoGenerico();
        String res = dao.listarTodo(tabla);
        Gson json = new Gson();
        Type tipo = new TypeToken<ArrayList<ClsCuentaCosto>>() {
        }.getType();
        ArrayList<ClsCuentaCosto> tipos = json.fromJson(res, tipo);
        return tipos;
    }
   public DefaultTableModel listarcuentacosto(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<ClsCuentaCosto> tipos = listar();
        for (ClsCuentaCosto tipo : tipos) {
            model.addRow(new Object[]{
                tipo.getDescripcion(),
                tipo.getTipo_cuenta_idTipo_cuenta(),
              
               
                 
                    
               
            });
        }
        return model;
    }
}

