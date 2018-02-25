/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.dao;

import com.OldSpace.excepciones.MensajesPersonalizados;
import com.OldSpace.modelos.interfaces.DAOCategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.OldSpace.modelos.beans.Categoria;

/**
 *
 * @author YonattanVisita
 */
public final class DAOCategoriaImpl extends  DAO implements DAOCategoria{

    final String CONSULTAR_CATEGORIAS = "SELECT id_categoria,categoria,id_usuario,usuario FROM consultar_categorias()";
    final String INSERTAR_CATEGORIA = "SELECT insertar_categoria(?,?)";
    
    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    private List<Categoria> categorias = null;
    private Categoria cat = null;
    
    private final static DAOCategoriaImpl INSTANCIA = new DAOCategoriaImpl();;
    
    private DAOCategoriaImpl(){
        
    }
    
    public static DAOCategoriaImpl getInstancia(){
        return INSTANCIA;
    }
    
    @Override
    public List<Categoria> listarCategorias() {
        try {
            categorias = new ArrayList<>();
            cn = conectar();
            ps = cn.prepareStatement(CONSULTAR_CATEGORIAS);
            rs = ps.executeQuery();
            while(rs.next()){
                categorias.add(this.convertir(rs));
            }
        } catch (SQLException ex) {
            MensajesPersonalizados.mostrarErrorException(ex.toString());
        }finally{
            cerrar(ps, rs, cn);
        }
        return categorias;
    }

    private Categoria convertir(ResultSet rs) {
        try {
            cat = new Categoria();
            cat.setIdCategoria(rs.getShort("id_categoria"));
            cat.setCategoria(rs.getString("categoria"));
            cat.setIdUsuario(rs.getShort("id_usuario"));
            cat.setUsuario(rs.getString("usuario"));
        } catch (SQLException ex) {
            MensajesPersonalizados.mostrarErrorException(ex.toString());
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
            MensajesPersonalizados.mostrarErrorException(ex.toString());
        }finally{
            cerrar(ps, rs, cn);
        }
       return idCategoria;
    }
    
}
