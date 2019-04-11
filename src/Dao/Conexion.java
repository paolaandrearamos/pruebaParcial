/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author paola
 */
public class Conexion {
     protected String driver = "org.gjt.mm.mysql.Driver"; //nombre del driver
    public String db = "mydb";
    protected String connectString = "jdbc:mysql://localhost:3306/" + db; //ubicacion de la base de datos, para postgres esta es por defecto
    protected String user = "root"; //usuario de la base de datos
    protected String password = ""; //password de la base de dato o admin
    protected Connection conexionDB; // variable que permite la conexion
    protected Statement sentenciaSQL; //permite la ejecucion de sentencias SQL
    public ResultSet resultadoDB;//almacena el resultado de una consulta

    /**
     * Permite la conexion de la base de datos
     */
    public void conectar() {
        try {
            Class.forName(driver); //se carga el driver en memoria
            conexionDB = DriverManager.getConnection(connectString, user, password);//conexion a la base de datos
            sentenciaSQL = conexionDB.createStatement();//variable que permite ejecutar las sentencias SQL                                
        } catch (ClassNotFoundException | SQLException e) {
          
       
        System.out.println(e.getMessage());
         e.printStackTrace();
        }
    }

    public Connection conectarReporte() {
        try {
            Class.forName(driver); //se carga el driver en memoria
            conexionDB = DriverManager.getConnection(connectString, user, password);//conexion a la base de datos
            sentenciaSQL = conexionDB.createStatement();//variable que permite ejecutar las sentencias SQL                                
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return conexionDB;
    }

    /**
     * Desconecta la conexion de la base de datos
     */
    public void desconectar() {
        try {
            //sentenciaSQL.close();//cierra la consulta
            conexionDB.close();//cierra conexion
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean ejecutar(String sentencia) {
        try {
            conectar();
            sentenciaSQL.executeUpdate(sentencia);
            desconectar();
        } catch (Exception e){
             e.printStackTrace();
            return false;
            //esta
        }
        return true;
    }

    public void ejecutarRetorno(String sentencia) {
        try {
            conectar();
            resultadoDB = sentenciaSQL.executeQuery(sentencia);
            //desconectar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
