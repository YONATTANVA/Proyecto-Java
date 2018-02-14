/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author YonattanVisita
 */
public class DAO {
    Connection cn = null;
    static String bd = "db_sistema_ventas";
    static String server = "127.0.0.1";
    static String user = "yonattan";
    static String password = "123";
    
    public static Connection conectar(){
        Connection cn = null;
        try {
            cn = DriverManager.getConnection("jdbc:postgresql//" + server + "/" + bd, user, password);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }
        return cn;
    }
    
    public static void cerrar(PreparedStatement pst, ResultSet rs, Connection cn){
        try {
            if(pst != null){
                pst.close();
            }
            if(rs != null){
                rs.close();
            }
            if(cn != cn){
                cn.close();
            }
        } catch (Exception e) {
        }
    }
}
