/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.DaoGenerico;
import Modelo.ClsSucursal;
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
public class CtlSucursal {
     String tabla = "sucursal";

    public CtlSucursal() {
    }
     public String convertirGson(ClsSucursal sucursal) {
        Gson gson = new Gson();
        String objeto = gson.toJson(sucursal);
        return objeto;
    }

    public boolean guardar(ClsSucursal sucursal) {
        DaoGenerico dao = new DaoGenerico();
        String objeto = convertirGson(sucursal);
        return dao.guardar(objeto, tabla);
    }
    public ClsSucursal SolicitudBuscar(int codigo) {
        DaoGenerico usuarioDAO = new DaoGenerico();
        String res = usuarioDAO.buscar(tabla, "idSucursal", String.valueOf(codigo));
        Gson json = new Gson();
        ClsSucursal usu = json.fromJson(res, ClsSucursal.class);
        return usu;
    }
    
    
public ArrayList<ClsSucursal> listar() {
        DaoGenerico dao = new DaoGenerico();
        String res = dao.listarTodo(tabla);
        Gson json = new Gson();
        Type tipo = new TypeToken<ArrayList<ClsSucursal>>() {
        }.getType();
        ArrayList<ClsSucursal> sucursal = json.fromJson(res, tipo);
        return sucursal;
    }

   public DefaultTableModel listarCargos(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<ClsSucursal> sucursal = listar();
        for (ClsSucursal sucur : sucursal) {
            model.addRow(new Object[]{
                sucur.getIdsucursal(),
                sucur.getNombre(),
                sucur.getGerente_Sucursal_idGerente(),
                sucur.getDireccion(),
                sucur.getMunicipio()
                    
               
            });
        }
        return model;
    }
}
