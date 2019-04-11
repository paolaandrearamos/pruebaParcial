/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.DaoGenerico;
import Modelo.ClsBanco;
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
public class CtlTipoCuenta {
     String tabla = "Tipo_cuenta";

    public CtlTipoCuenta() {
    }
     public String convertirGson(ClsTipoCuenta tipocuenta) {
        Gson gson = new Gson();
        String objeto = gson.toJson(tipocuenta);
        return objeto;
    }

    public boolean guardar(ClsTipoCuenta tipocuenta) {
        DaoGenerico dao = new DaoGenerico();
        String objeto = convertirGson(tipocuenta);
        return dao.guardar(objeto, tabla);
    }

    public ClsTipoCuenta SolicitudBuscar(int id_tipo) {
        DaoGenerico dao = new DaoGenerico();
        String res = dao.buscar(tabla, "idTipo_cuenta", String.valueOf(id_tipo));
        Gson json = new Gson();
        ClsTipoCuenta tipo = json.fromJson(
                res, ClsTipoCuenta.class);
        return tipo;
    }

  public boolean SolicitudModificar(int idTipo_cuenta, String descripcion) {
        ClsTipoCuenta tipo= new ClsTipoCuenta(idTipo_cuenta,descripcion);
        DaoGenerico usuDAO = new DaoGenerico();
        String objeto = convertirGson(tipo);
        return usuDAO.modificar(objeto, tabla, "idTipo_cuenta", String.valueOf(tipo.getIdTipo_cuenta()));
    }

    public boolean solicitudEliminar(int tipocuenta) {
        DaoGenerico dao = new DaoGenerico();
        return dao.eliminar(tabla, "idTipo_cuenta", String.valueOf(tipocuenta));
    }

    public ArrayList<ClsTipoCuenta> listar() {
        DaoGenerico dao = new DaoGenerico();
        String res = dao.listarTodo(tabla);
        Gson json = new Gson();
        Type tipo = new TypeToken<ArrayList<ClsTipoCuenta>>() {
        }.getType();
        ArrayList<ClsTipoCuenta> tipos = json.fromJson(res, tipo);
        return tipos;
    }
     public DefaultTableModel listartipocuenta(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<ClsTipoCuenta> tipos = listar();
        for (ClsTipoCuenta tipo : tipos) {
            model.addRow(new Object[]{
                tipo.getIdTipo_cuenta(),
                tipo.getDescripcion(),
               
                 
                    
               
            });
        }
        return model;
    }
}
