/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.DaoGenerico;
import Modelo.Movimiento;
import com.google.gson.Gson;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Lizeth1304
 */
public class CtlMovimiento {
    public static String tabla = "movimiento";
    public static String cbID= "idMovimiento";
    public static String cb = "monto";
    //public static String cbID = "idtipo_seguros";
    
    public CtlMovimiento(){
        
    }
    
    public String convertirGson(Movimiento us) {
        Gson gson = new Gson();
        String objeto = gson.toJson(us);
        return objeto;
    }
  
    public static DefaultComboBoxModel solicitudListarCombo() {
        DaoGenerico dao = new DaoGenerico();
        return dao.llenarCombo(tabla, cb);
    }
        public String buscaValor(String monto) {
        DaoGenerico DAO = new DaoGenerico();
        return DAO.buscarCombo(tabla, cb, cbID, monto);
    }
}
