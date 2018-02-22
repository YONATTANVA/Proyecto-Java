/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.dao;

import com.OldSpace.excepciones.Personalizado;
import com.OldSpace.modelos.interfaces.DAOProveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.OldSpace.modelos.pojos.Proveedor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YonattanVisita
 */
public class DAOProveedorImpl extends DAO implements DAOProveedor{

    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    final String CONSULTAR_PROVEEDORES = "SELECT id_proveedor,nombre_contacto,telefono,email,nombre_empresa,ruc,direccion FROM consultar_proveedores()";
    final String INSERTAR_PROVEEDOR = "SELECT insertar_proveedor(?,?,?,?,?,?,?)";
    
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
            cn = conectar();
            ps = cn.prepareStatement(CONSULTAR_PROVEEDORES);
            rs = ps.executeQuery();
            while(rs.next()){
                listaProve.add(convertir(rs));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            cerrar(ps, rs, cn);
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

    @Override
    public short insertarProveedor(Proveedor proveedor) {
        short idProveedor = 0;
        try {
            cn = conectar();
            ps = cn.prepareStatement(INSERTAR_PROVEEDOR);
            ps.setString(1, proveedor.getNombreContacto());
            ps.setString(2, proveedor.getTelefono());
            ps.setString(3, proveedor.getEmail());
            ps.setString(4, proveedor.getNombreEmpresa());
            ps.setString(5, proveedor.getRuc());
            ps.setString(6, proveedor.getDireccion());
            ps.setShort(7, proveedor.getIdUsuario());
            rs = ps.executeQuery();
            if(rs.next()){
                idProveedor = rs.getShort(1);
            }
        } catch (SQLException ex) {
            Personalizado.mostrarError(ex.toString());
        }finally{
            cerrar(ps, rs, cn);
        }
        
        return idProveedor;
    }

    
}
