/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.dao;

import com.OldSpace.excepciones.Personalizado;
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
public class DAOCategoriaImpl extends  DAO implements DAOCategoria{

    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    final String CONSULTAR_CATEGORIAS = "SELECT id_categoria,categoria FROM consultar_categorias()";
    final String INSERTAR_CATEGORIA = "SELECT insertar_categoria(?,?)";
    
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
            cn = conectar();
            ps = cn.prepareStatement(CONSULTAR_CATEGORIAS);
            rs = ps.executeQuery();
            while(rs.next()){
                categorias.add(convertir(rs));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            cerrar(ps, rs, cn);
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

    @Override
    public short insertarCategoria(Categoria categoria) {
       short idCategoria = 0;
        try {
            cn = conectar();
            ps = cn.prepareStatement(INSERTAR_CATEGORIA);
            ps.setString(1, categoria.getCategoria());
            ps.setShort(2, categoria.getIdUsuario());
            rs = ps.executeQuery();
            if(rs.next()){
                idCategoria = rs.getShort(1);
            }
        } catch (SQLException ex) {
            Personalizado.mostrarError(ex.toString());
        }finally{
            cerrar(ps, rs, cn);
        }
       return idCategoria;
    }
    
}
