/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.DaoGenerico;
import Modelo.ClsBanco;
import Modelo.ClsCargo;

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
public class CtlCargo {
     String tabla = "Cargo";

    public CtlCargo() {
    }
     public String convertirGson(ClsCargo cargo) {
        Gson gson = new Gson();
        String objeto = gson.toJson(cargo);
        return objeto;
    }

    public boolean guardar(ClsCargo cargo) {
        DaoGenerico dao = new DaoGenerico();
        String objeto = convertirGson(cargo);
        return dao.guardar(objeto, tabla);
    }
    public ClsCargo SolicitudBuscar(int cedula) {
        DaoGenerico usuarioDAO = new DaoGenerico();
        String res = usuarioDAO.buscar(tabla, "idCargo", String.valueOf(cedula));
        Gson json = new Gson();
        ClsCargo usu = json.fromJson(res, ClsCargo.class);
        return usu;
    }
    
//     public boolean SolicitudModificar(int idCargo,String nombre, String horario, Double salario,String direccion,int Banco_idBanco  ) {
//        ClsCargo carg= new ClsCargo(idCargo, nombre, horario, salario, direccion, Banco_idBanco);
//        DaoGenerico usuDAO = new DaoGenerico();
//        String objeto = convertirGson(carg);
//        return usuDAO.modificar(objeto, tabla, "idCargo", String.valueOf(carg.getIdCargo()));
//    
//    
//     }
    public boolean SolicitudModificar(ClsCargo cargo) {
        DaoGenerico DAO = new DaoGenerico();
        String objeto = convertirGson(cargo);
        return DAO.modificar(objeto, tabla, "idCargo", String.valueOf(cargo.getIdCargo()));
    }
    
public ArrayList<ClsCargo> listar() {
        DaoGenerico dao = new DaoGenerico();
        String res = dao.listarTodo(tabla);
        Gson json = new Gson();
        Type tipo = new TypeToken<ArrayList<ClsCargo>>() {
        }.getType();
        ArrayList<ClsCargo> cargo = json.fromJson(res, tipo);
        return cargo;
    }

   public DefaultTableModel listarCargos(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<ClsCargo> cargos = listar();
        for (ClsCargo carg : cargos) {
            model.addRow(new Object[]{
                carg.getIdCargo(),
                carg.getNombre(),
                carg.getHorario(),
                carg.getSalario(),
                carg.getDescripcion(),
                carg.getBanco_idBanco()
                 
                    
               
            });
        }
        return model;
    }
}
