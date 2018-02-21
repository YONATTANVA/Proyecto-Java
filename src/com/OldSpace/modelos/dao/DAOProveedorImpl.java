/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.dao;

import com.OldSpace.modelos.interfaces.DAOProveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.OldSpace.modelos.pojos.Proveedor;

/**
 *
 * @author YonattanVisita
 */
public class DAOProveedorImpl implements DAOProveedor{

    private Connection cn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    
    final String CONSULTAR_PROVEEDORES = "SELECT id_proveedor,nombre_contacto,telefono,email,nombre_empresa,ruc,direccion FROM consultar_proveedores()";
    
    private static DAOProveedorImpl instancia = null;
    
    private DAOProveedorImpl(){
        
    }
    
    public static DAOProveedorImpl getInstancia(){
        if(instancia == null){
            instancia = new DAOProveedorImpl();
        }
        return instancia;
    }
    
    
    @Override
    public List<Proveedor> listarProveedores() {
        List<Proveedor> listaProve = null;
        
        try {
            listaProve = new ArrayList<>();
            cn =  DAO.conectar();
            pst = cn.prepareStatement(CONSULTAR_PROVEEDORES);
            rs = pst.executeQuery();
            while(rs.next()){
                listaProve.add(convertir(rs));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            DAO.cerrar(pst, rs, cn);
        }
        return listaProve;
    }

    private Proveedor convertir(ResultSet rs) {
        Proveedor pro = null;
        try {
            pro = new Proveedor();
            pro.setIdProveedor(rs.getShort("id_proveedor"));
            pro.setNombreContacto(rs.getString("nombre_contacto"));
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return pro;
    }

    
}
