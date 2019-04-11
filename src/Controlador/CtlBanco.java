/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.DaoGenerico;
import Modelo.ClsBanco;
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
public class CtlBanco {
     String tabla = "Banco";

    public CtlBanco() {
    }
     public String convertirGson(ClsBanco banco) {
        Gson gson = new Gson();
        String objeto = gson.toJson(banco);
        return objeto;
    }

    public boolean guardar(ClsBanco banco) {
        DaoGenerico dao = new DaoGenerico();
        String objeto = convertirGson(banco);
        return dao.guardar(objeto, tabla);
    }

    public ClsBanco SolicitudBuscar(int id_banco) {
        DaoGenerico dao = new DaoGenerico();
        String res = dao.buscar(tabla, "idBanco", String.valueOf(id_banco));
        Gson json = new Gson();
        ClsBanco ban = json.fromJson(
                res, ClsBanco.class);
        return ban;
    }

   public boolean SolicitudModificar(int idBanco,String nombre_banco,int nit,String mision,String vision,String direccion) {
        ClsBanco banco= new ClsBanco(idBanco, nombre_banco, nit, mision, vision, direccion);
        DaoGenerico usuDAO = new DaoGenerico();
        String objeto = convertirGson(banco);
        return usuDAO.modificar(objeto, tabla, "idBanco", String.valueOf(banco.getIdBanco()));
    }
    public boolean solicitudEliminar(int banco) {
        DaoGenerico dao = new DaoGenerico();
        return dao.eliminar(tabla, "idBanco", String.valueOf(banco));
    }

    public ArrayList<ClsBanco> listar() {
        DaoGenerico dao = new DaoGenerico();
        String res = dao.listarTodo(tabla);
        Gson json = new Gson();
        Type tipo = new TypeToken<ArrayList<ClsBanco>>() {
        }.getType();
        ArrayList<ClsBanco> bancos = json.fromJson(res, tipo);
        return bancos;
    }
     public DefaultTableModel listarBanco(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<ClsBanco> bancos = listar();
        for (ClsBanco carg : bancos) {
            model.addRow(new Object[]{
                carg.getIdBanco(),
                carg.getNombre_banco(),
                carg.getNit(),
                carg.getMision(),
                carg.getVision(),
                carg.getDireccion()
                 
                    
               
            });
        }
        return model;
    }
}
