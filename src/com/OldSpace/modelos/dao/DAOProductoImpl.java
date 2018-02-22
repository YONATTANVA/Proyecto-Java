/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.dao;

import com.OldSpace.excepciones.Personalizado;
import com.OldSpace.modelos.interfaces.DAOProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.OldSpace.modelos.pojos.Producto;

/**
 *
 * @author YonattanVisita
 */
public class DAOProductoImpl extends DAO implements DAOProducto{
    final String CONSULTAR_PRODUCTOS = "SELECT id_producto,nombre,precio,stock,categoria FROM consultar_productos(?,?,?)";
    final String CONSULTAR_PRODUCTOS_CATEGORIA = "SELECT id_producto,nombre,precio,stock,categoria FROM consultar_productos_categoria(?,?,?)";
    final String INSERTAR_PRODUCTO = "SELECT insertar_producto(?,?,?,?,?)";
    private PreparedStatement pst =null;
    private ResultSet rs = null;
    private Connection cn = null;
    private short limitePagina = 10;
    private short pagina = 1;
    private static  DAOProductoImpl instancia = null;
    
    public short getLimitePagina() {
        return limitePagina;
    }

    public void setLimitePagina(short limitePagina) {
        this.limitePagina = limitePagina;
    }

    public short getPagina() {
        return pagina;
    }

    public void setPagina(short pagina) {
        this.pagina = pagina;
    }
    
    
    //patron singleton
    private DAOProductoImpl(){
        
    }
    public static DAOProductoImpl getInstancia(){
        if(instancia == null){
            instancia = new DAOProductoImpl();
        }
        return instancia;
    }

   
      
    
    @Override
    public List<Producto> listarTodosProductos(String _filtro) {
        List<Producto> productos = null;
        try {
            productos = new ArrayList<>();
            cn = conectar();
            pst = cn.prepareStatement(CONSULTAR_PRODUCTOS);
            pst.setString(1, _filtro);
            pst.setShort(2, getPagina());
            pst.setShort(3, getLimitePagina());
            rs = pst.executeQuery();
            while(rs.next()){
                productos.add(convertir(rs));
            }
        } catch (SQLException ex) {
            Personalizado.mostrarError(ex.toString());
        }finally{
            cerrar(pst, rs, cn);
        }
        return productos;
    }
    
    private Producto convertir(ResultSet rs){
        Producto producto = null;
        try {
            producto = new Producto();
            producto.setIdProducto(rs.getShort("id_producto"));
            producto.setNombre(rs.getString("nombre"));
            producto.setPrecio(rs.getFloat("precio"));
            producto.setStock(rs.getShort("stock"));
            producto.setCategoria(rs.getString("categoria"));
        } catch (SQLException ex) {
            Personalizado.mostrarError(ex.toString());
        }
        return producto;
    }

    @Override
    public List<Producto> listarTodosProductos(short _categoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public short insertarProducto(Producto producto) {
        short id_producto = 0;
        try {
            cn = conectar();
            pst = cn.prepareStatement(INSERTAR_PRODUCTO);
            pst.setString(1, producto.getNombre());
            pst.setFloat(2, producto.getPrecio());
            pst.setShort(3, producto.getStock());
            pst.setShort(4, producto.getIdCategoria());
            pst.setShort(5, producto.getUsuario());
            rs = pst.executeQuery();
            while(rs.next()){
                id_producto = rs.getShort(1);
            }
        } catch (SQLException ex) {
            Personalizado.mostrarError(ex.toString());
        }finally{
            cerrar(pst, rs, cn);
        }
        return id_producto;
    }


    

}
