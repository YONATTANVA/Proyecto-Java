/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.dao;

import com.OldSpace.excepciones.MensajesPersonalizados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author YonattanVisita
 */
public class DAO {
    private String bd = "db_sistema_ventas";
    private String server = "127.0.0.1:5432";
    private String user = "yonattan";
    private String password = "123";
    private Connection cn = null;
    
    public Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            cn = DriverManager.getConnection("jdbc:postgresql://" + server + "/" + bd, user, password);
        } catch (SQLException ex) {
            MensajesPersonalizados.mostrarErrorException(ex.toString());
        } catch (ClassNotFoundException ex) { 
            MensajesPersonalizados.mostrarErrorException(ex.toString());
        }
        return cn;
    }
    
    public void cerrar(PreparedStatement ps, ResultSet rs, Connection cn){
        try {
            if(ps != null){
                ps.close();
            }
            if(rs != null){
                rs.close();
            }
            if(cn != cn){
                cn.close();
            }
        } catch (Exception e) {
            MensajesPersonalizados.mostrarErrorException(e.toString());
        }
    }
}
