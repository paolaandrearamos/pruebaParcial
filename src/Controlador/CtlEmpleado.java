/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.DaoGenerico;
import Modelo.ClsCargo;

import Modelo.ClsEmpleado;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author paola
 */
public class CtlEmpleado {
     String tabla = "Empleado";

    public CtlEmpleado() {
    }
     public String convertirGson(ClsEmpleado empleado) {
        Gson gson = new Gson();
        String objeto = gson.toJson(empleado);
        return objeto;
    }

    public boolean guardar(ClsEmpleado empleado) {
        DaoGenerico dao = new DaoGenerico();
        String objeto = convertirGson(empleado);
        return dao.guardar(objeto, tabla);
    }

    public ClsEmpleado SolicitudBuscar(int idEmpleado) {
        DaoGenerico dao = new DaoGenerico();
        String res = dao.buscar(tabla, "cedula", String.valueOf(idEmpleado));
        Gson json = new Gson();
        ClsEmpleado empl = json.fromJson(
                res, ClsEmpleado.class);
        return empl;
    }

     public boolean SolicitudModificar(int cedula,String nombre, String apellido,
             String fecha_nacimiento,String ciudad, String correo, String telefono, int Cargo_idCargo, int Sucursal_idSucursal  ) {
        ClsEmpleado empl= new ClsEmpleado(cedula, nombre, apellido, fecha_nacimiento, ciudad, correo, telefono, Cargo_idCargo, Sucursal_idSucursal);
        DaoGenerico usuDAO = new DaoGenerico();
        String objeto = convertirGson(empl);
        return usuDAO.modificar(objeto, tabla, "cedula", String.valueOf(empl.getCedula()));
     }

    public boolean solicitudEliminar(int empleado) {
        DaoGenerico dao = new DaoGenerico();
        return dao.eliminar(tabla, "cedula", String.valueOf(empleado));
    }

  
    
public ArrayList<ClsEmpleado> listar() {
        DaoGenerico dao = new DaoGenerico();
        String res = dao.listarTodo(tabla);
        Gson json = new Gson();
        Type tipo = new TypeToken<ArrayList<ClsEmpleado>>() {
        }.getType();
        System.out.println(res);
        ArrayList<ClsEmpleado> emp = json.fromJson(res, tipo);
        return emp;
    }
     
     public DefaultTableModel listaempleado(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<ClsEmpleado> empleados = listar();
        for (ClsEmpleado emp : empleados) {
            model.addRow(new Object[]{
                emp.getCedula(),
                emp.getNombre(),
                emp.getApellido(),
                emp.getFecha_nacimiento(),
                emp.getCiudad(),
                emp.getCorreo(),
                emp.getTelefono(),
                emp.getCargo_idCargo(),
                emp.getSucursal_idSucursal()
                     
            });
        }
        return model;
    }
}
