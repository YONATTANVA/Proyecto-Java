/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.dao;

import com.OldSpace.modelos.interfaces.DAOCategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.OldSpace.modelos.pojos.Categoria;

/**
 *
 * @author YonattanVisita
 */
public class DAOCategoriaImpl implements DAOCategoria{

    private Connection cn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    
    final String CONSULTAR_CATEGORIAS = "SELECT id_categoria,categoria FROM consultar_categorias()";
    
    private static DAOCategoriaImpl instancia = null;
    
    private DAOCategoriaImpl(){
        
    }
    
    public static DAOCategoriaImpl getInstancia(){
        if(instancia == null){
            instancia = new DAOCategoriaImpl();
        }
        return instancia;
    }
    
    @Override
    public List<Categoria> listarCategorias() {
        List<Categoria> categorias = null;
        try {
            categorias = new ArrayList<>();
            cn = DAO.conectar();
            pst = cn.prepareStatement(CONSULTAR_CATEGORIAS);
            rs = pst.executeQuery();
            while(rs.next()){
                categorias.add(convertir(rs));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            DAO.cerrar(pst, rs, cn);
        }
        return categorias;
    }

    private Categoria convertir(ResultSet rs) {
        Categoria cat = null;
        try {
            cat = new Categoria();
            cat.setIdCategoria(rs.getShort("id_categoria"));
            cat.setCategoria(rs.getString("categoria"));
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return cat;
    }
    
}
