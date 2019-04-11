/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author paola
 */
public class DaoGenerico extends Conexion{
    public boolean guardar(String objeto, String tabla) {
        System.out.println(objeto);

        JsonParser parser = new JsonParser();
        JsonObject jobject = parser.parse(objeto).getAsJsonObject();
        Set<String> keys = jobject.keySet();

        ArrayList<String> listCampos = new ArrayList(keys);
        ArrayList<String> listValores = new ArrayList();
        for (int i = 0; i < listCampos.size(); i++) {
            System.out.println(listCampos.get(i));
            String valor = jobject.get(listCampos.get(i)).getAsString();
            listValores.add(valor);
        }
        for (int i = 0; i < listValores.size(); i++) {
            System.out.println(listValores.get(i));
        }
        String consulta = "insert into " + tabla + "(";
        Iterator<String> itrCampos = listCampos.iterator();

        while (itrCampos.hasNext()) {
            Object atributo = itrCampos.next();
            consulta = consulta + "" + atributo.toString().toLowerCase();
            if (itrCampos.hasNext()) {
                consulta = consulta + ",";
            } else {
                consulta = consulta + ") values (";
            }

        }
        Iterator<String> itrValores = listValores.iterator();
        while (itrValores.hasNext()) {
            Object valor = itrValores.next();
            consulta = consulta + "'" + valor;
            if (itrValores.hasNext()) {
                consulta = consulta + "',";
            } else {
                consulta = consulta + "');";
            }

        }
        System.out.println(consulta);

        return super.ejecutar(consulta);
    }

    /**
     * Método para buscar de manera genérica en cualquier tabla de base de datos
     *
     * @param tabla, la tabla en la que se desea realizar la búsqueda
     * @param campo, el campo que se usará para la búsqueda (preferiblemente
     * llave primaria)
     * @param id, la llave primaria de la tabla.
     * @return un string con el resultado de la búsqueda
     */
    public String buscar(String tabla, String campo, String id) {
        //se concatena un select * from... donde se indica la tabla, el campo y el id
        String consulta = "select * from " + tabla + " where " + campo + "='" + id + "'";
        super.ejecutarRetorno(consulta);
        //Se inicia un string que va a crear la cadena json
        String resultado = "{ ";
        try {
            //Si hay un resultado
            if (resultadoDB.next()) {
                //se toma la cantidad de columnas en la búsqueda
                int res = resultadoDB.getMetaData().getColumnCount();
                //pasamos por cada una de las columnas
                for (int i = 1; i <= res; i++) {
                    //se concatena en forma de llave : valor cada resultado en la búsqueda
                    resultado += "'" + resultadoDB.getMetaData().getColumnName(i) + "' : '";
                    //si es la última columna no se separa por coma, por suu condición de último
                    if (i == res) {
                        resultado += resultadoDB.getString(i) + "'";
                    } else {
                        //De lo contrario agrega una coma para terminar el valor clave
                        resultado += resultadoDB.getString(i) + "', ";
                    }
                }
            }
            //finalizo el objeto json con }
            resultado += "}";
            System.out.println(resultado);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Esto se tosto");
        }
        return resultado;
    }

    /**
     * Función genérica para editar un registro en base de datos
     *
     * @param objeto, el objeto actualizado
     * @param tabla, la tabla donde se quiere eliminar
     * @param campo, el campo de la tabla que servirá de filtro
     * @param id, el dato del campo para filtrar
     * @return
     */
  public boolean modificar(String objeto, String tabla) {

        JsonParser parser = new JsonParser();
        JsonObject jobject = parser.parse(objeto).getAsJsonObject();
        Set<String> keys = jobject.keySet();

        ArrayList<String> listCampos = new ArrayList(keys);
        ArrayList<String> listValores = new ArrayList();

        for (int i = 0; i < listCampos.size(); i++) {

            listValores.add(jobject.get(listCampos.get(i)).getAsString());
        }

        String consulta = "update " + tabla + " SET";

        Iterator<String> itrCampos = listCampos.iterator();
        Iterator<String> itrValores = listValores.iterator();

        while (itrCampos.hasNext() && itrValores.hasNext()) {

            Object campo = itrCampos.next();
            Object valor = itrValores.next();

            consulta = consulta + " " + campo.toString().toLowerCase();

            if (itrCampos.hasNext()) {
                consulta = consulta + "= '";
                if (itrValores.hasNext()) {
                    consulta = consulta + valor + "',";

                }
            } else {
                consulta = consulta + "= '" + valor + "' where " + listCampos.get(0) + "='" + listValores.get(0) + "'";
            }

        }

        System.out.println(consulta);

        return super.ejecutar(consulta);
    }
     

    /**
     * Función genérica para eliminar un registro de la tabla indicada y por el
     * campo indicado
     *
     * @param tabla, la tabla de donde se desea eliminar el registro
     * @param campo, el campor para filtrar la eliminación
     * @param id, el dato del campo elegido para la eliminación de la tabla
     * @return
     */
    public boolean eliminar(String tabla, String campo, String id) {
        String consulta = "delete from " + tabla + " where " + campo + "='" + id + "'";
        return super.ejecutar(consulta);
    }

    public String listarTodo(String tabla) {
        //se concatena un select * from... donde se indica la tabla, el campo y el id
        String consulta = "select * from " + tabla;
        super.ejecutarRetorno(consulta);
        //Se inicia un string que va a crear la cadena json
        String resultado = "[ ";
        try {
            //Si hay un resultado
            while (resultadoDB.next()) {
                resultado += "{";
                //se toma la cantidad de columnas en la búsqueda
                int res = resultadoDB.getMetaData().getColumnCount();
                //pasamos por cada una de las columnas
                for (int i = 1; i <= res; i++) {
                    //se concatena en forma de llave : valor cada resultado en la búsqueda
                    resultado += "'" + resultadoDB.getMetaData().getColumnName(i) + "' : '";
                    //si es la última columna no se separa por coma, por suu condición de último
                    if (i == res) {
                        resultado += resultadoDB.getString(i) + "'";
                    } else {
                        //De lo contrario agrega una coma para terminar el valor clave
                        resultado += resultadoDB.getString(i) + "', ";
                    }
                }
                if (!resultadoDB.isLast()) {
                    resultado += "},";
                } else {
                    resultado += "}";
                }

            }
            //finalizo el objeto json con }
            resultado += "]";
            System.out.println(resultado);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Esto se tosto");
        }
        return resultado;
    }
//
//    public String listar(String tabla, String campo, String id) {
//        //se concatena un select * from... donde se indica la tabla, el campo y el id
//        String consulta = "select * from " + tabla + " where " + campo + "='" + id + "'";
//        super.ejecutarRetorno(consulta);
//        //Se inicia un string que va a crear la cadena json
//        String resultado = "[ ";
//        try {
//            //Si hay un resultado
//            while (resultadoDB.next()) {
//                resultado += "{";
//                //se toma la cantidad de columnas en la búsqueda
//                int res = resultadoDB.getMetaData().getColumnCount();
//                //pasamos por cada una de las columnas
//                for (int i = 1; i <= res; i++) {
//                    //se concatena en forma de llave : valor cada resultado en la búsqueda
//                    resultado += "'" + resultadoDB.getMetaData().getColumnName(i) + "' : '";
//                    //si es la última columna no se separa por coma, por suu condición de último
//                    if (i == res) {
//                        resultado += resultadoDB.getString(i) + "'";
//                    } else {
//                        //De lo contrario agrega una coma para terminar el valor clave
//                        resultado += resultadoDB.getString(i) + "', ";
//                    }
//                }
//                if (!resultadoDB.isLast()) {
//                    resultado += "},";
//                } else {
//                    resultado += "}";
//                }
//
//            }
//            //finalizo el objeto json con }
//            resultado += "]";
//            System.out.println(resultado);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            System.out.println("Esto se tosto");
//        }
//        return resultado;
//    }
//    
    public String login(String consulta) {
        //se concatena un select * from... donde se indica la tabla, el campo y el id
        super.ejecutarRetorno(consulta);
        //Se inicia un string que va a crear la cadena json
        String resultado = "{ ";
        try {
            //Si hay un resultado
            if (resultadoDB.next()) {
                //se toma la cantidad de columnas en la búsqueda
                int res = resultadoDB.getMetaData().getColumnCount();
                //pasamos por cada una de las columnas
                for (int i = 1; i <= res; i++) {
                    //se concatena en forma de llave : valor cada resultado en la búsqueda
                    resultado += "'" + resultadoDB.getMetaData().getColumnName(i) + "' : '";
                    //si es la última columna no se separa por coma, por suu condición de último
                    if (i == res) {
                        resultado += resultadoDB.getString(i) + "'";
                    } else {
                        //De lo contrario agrega una coma para terminar el valor clave
                        resultado += resultadoDB.getString(i) + "', ";
                    }
                }
            }
            //finalizo el objeto json con }
            resultado += "}";
            System.out.println(resultado);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Esto se tosto");
        }
        return resultado;
    }
 public String listar(String tabla, String campo, String id) {
        //se concatena un select * from... donde se indica la tabla, el campo y el id
        String consulta = "select * from " + tabla + " where " + campo + "='" + id + "'";
        super.ejecutarRetorno(consulta);
        //Se inicia un string que va a crear la cadena json
        String resultado = "[ ";
        try {
            //Si hay un resultado
            while (resultadoDB.next()) {
                resultado += "{";
                //se toma la cantidad de columnas en la búsqueda
                int res = resultadoDB.getMetaData().getColumnCount();
                //pasamos por cada una de las columnas
                for (int i = 1; i <= res; i++) {
                    //se concatena en forma de llave : valor cada resultado en la búsqueda
                    resultado += "'" + resultadoDB.getMetaData().getColumnName(i) + "' : '";
                    //si es la última columna no se separa por coma, por suu condición de último
                    if (i == res) {
                        resultado += resultadoDB.getString(i) + "'";
                    } else {
                        //De lo contrario agrega una coma para terminar el valor clave
                        resultado += resultadoDB.getString(i) + "', ";
                    }
                }
                resultado += "},";

            }
            //finalizo el objeto json con }
            resultado += "]";
            System.out.println(resultado);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Esto se tosto");
        }
        return resultado;
    }
    
 public DefaultComboBoxModel llenarCombo(String tabla,String cb) {
        DefaultComboBoxModel cbx = new DefaultComboBoxModel();
        cbx.addElement(tabla);

        String consulta = "select * FROM " + tabla;
        super.ejecutarRetorno(consulta);
        System.out.println(consulta);

        try {
            while (resultadoDB.next()) {
                cbx.addElement(resultadoDB.getString(cb));
            }
        } catch (SQLException ex) {
            System.out.println("esto se tosto");
        }
        return cbx;
    }
 public String buscarCombo(String tabla, String cb, String cbID, String nombre) {
        String consulta = "SELECT " + cbID + " FROM " + tabla + " WHERE " + cb + " ='" + nombre + "'";
        super.ejecutarRetorno(consulta);
        System.out.println(consulta);
        String cedula = "";
        try {
            if (resultadoDB.next()) {

                cedula = (resultadoDB.getString("idMovimiento"));
            }
        } catch (SQLException ex) {
            System.out.println("Esto se tosto");

        }
        return cedula;
    }
 public boolean modificar(String objeto, String tabla, String campo, String id) {
        System.out.println(objeto);

        JsonParser parser = new JsonParser();
        JsonObject jobject = parser.parse(objeto).getAsJsonObject();
        Set<String> keys = jobject.keySet();

        ArrayList<String> listCampos = new ArrayList(keys);
        ArrayList<String> listValores = new ArrayList();

        for (int i = 0; i < listCampos.size(); i++) {
            System.out.println(listCampos.get(i));
            listValores.add(jobject.get(listCampos.get(i)).getAsString());
        }
        //se empieza a crear la consulta
        String consulta = "update " + tabla + " SET ";

        for (int i = 0; i < listCampos.size(); i++) {
            //Si es el último registro de la lista no se concatena la última coma
            if (i == listCampos.size() - 1) {
                consulta += listCampos.get(i) + "='" + listValores.get(i) + "' ";
            } else {
                consulta += listCampos.get(i) + "='" + listValores.get(i) + "', ";
            }
        }
        consulta += "WHERE " + campo + "='" + id + "'";

        System.out.println(consulta);

        return super.ejecutar(consulta);
    }
}
