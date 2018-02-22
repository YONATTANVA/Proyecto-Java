/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.dao;

import com.OldSpace.excepciones.Personalizado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author YonattanVisita
 */
public class DAO {
    private String bd = "db_sistema_ventas";
    private String server = "127.0.0.1:5432";
    private String user = "postgres";
    private String password = "123";
    
    public Connection conectar(){
        Connection cn = null;
        try {
            //Class.forName("org.postgresql.Driver");
            cn = DriverManager.getConnection("jdbc:postgresql://" + server + "/" + bd, user, password);
        } catch (SQLException ex) {
            Personalizado.mostrarError(ex.toString());
        } 
        return cn;
    }
    
    public void cerrar(PreparedStatement pst, ResultSet rs, Connection cn){
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
            Personalizado.mostrarError(e.toString());
        }
    }
}
