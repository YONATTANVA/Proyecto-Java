/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.dao;

import com.OldSpace.excepciones.MensajesPersonalizados;
import com.OldSpace.modelos.interfaces.DAOProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.OldSpace.modelos.beans.Producto;
/**
 *
 * @author YonattanVisita
 */
public final class DAOProductoImpl extends DAO implements DAOProducto{
    final String CONSULTAR_PRODUCTOS = "SELECT id_producto,nombre,precio,stock,imagen,id_categoria,categoria,id_usuario,usuario FROM consultar_productos(?,?,?)";
    final String CONSULTAR_PRODUCTOS_CATEGORIA = "SELECT id_producto,nombre,precio,stock,imagen,id_categoria,categoria,id_usuario,nombre FROM consultar_productos_categoria(?,?,?)";
    final String INSERTAR_PRODUCTO = "SELECT insertar_producto(?,?,?,?,?,?)";
    final String ACTUALIZAR_PRODUCTO = "SELECT actualizar_producto(?,?,?,?,?,?,?)";
    final String ELIMINAR_PRODUCTO = "SELECT eliminar_producto(?)";
    
    private PreparedStatement ps =null;
    private ResultSet rs = null;
    private Connection cn = null;
    
    private short limitePagina = 10;
    private short pagina = 1;
    
    private final static  DAOProductoImpl INSTANCIA = new DAOProductoImpl();
    
    private Producto producto = null;
    private List<Producto> productos = null;
    
    
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
        return INSTANCIA;
    }

   
      
    
    @Override
    public List<Producto> listarTodosProductos(String _filtro) {
        try {
            productos = new ArrayList<>();
            cn = conectar();
            ps = cn.prepareStatement(CONSULTAR_PRODUCTOS);
            ps.setString(1, _filtro);
            ps.setShort(2, getPagina());
            ps.setShort(3, getLimitePagina());
            rs = ps.executeQuery();
            while(rs.next()){
                productos.add(this.convertir(rs));
            }
        } catch (SQLException ex) {
            MensajesPersonalizados.mostrarErrorException(ex.toString());
        }finally{
            cerrar(ps, rs, cn);
        }
        return productos;
    }
    
    private Producto convertir(ResultSet rs){
        try {
            producto = new Producto();
            producto.setIdProducto(rs.getShort("id_producto"));
            producto.setNombre(rs.getString("nombre"));
            producto.setPrecio(rs.getFloat("precio"));
            producto.setStock(rs.getShort("stock"));
            producto.setCategoria(rs.getString("categoria"));
            producto.setImagen(rs.getString("imagen"));
            producto.setIdCategoria(rs.getShort("id_categoria"));
            producto.setIdUsuario(rs.getShort("id_usuario"));
            producto.setUsuario(rs.getString("usuario"));
        } catch (SQLException ex) {
            MensajesPersonalizados.mostrarErrorException(ex.toString());
        }
        return producto;
    }

    @Override
    public List<Producto> listarTodosProductos(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public short insertarProducto(Producto producto) {
        short id_producto = 0;
        try {
            cn = conectar();
            ps = cn.prepareStatement(INSERTAR_PRODUCTO);
            ps.setString(1, producto.getNombre());
            ps.setFloat(2, producto.getPrecio());
            ps.setShort(3, producto.getStock());
            ps.setString(4, producto.getImagen());
            ps.setShort(5, producto.getIdCategoria());
            ps.setShort(6, producto.getIdUsuario());
            rs = ps.executeQuery();
            while(rs.next()){
                id_producto = rs.getShort(1);
            }
        } catch (SQLException ex) {
            MensajesPersonalizados.mostrarErrorException(ex.toString());
        }finally{
            cerrar(ps, rs, cn);
        }
        return id_producto;
    }

    @Override
    public short actualizarProducto(Producto producto) {
        short idPro = 0;
        try {
            cn = conectar();
            ps = cn.prepareStatement(ACTUALIZAR_PRODUCTO);
            ps.setShort(1, producto.getIdProducto());
            ps.setString(2, producto.getNombre());
            ps.setFloat(3, producto.getPrecio());
            ps.setShort(4, producto.getStock());
            ps.setString(5, producto.getImagen());
            ps.setShort(6, producto.getIdCategoria());
            ps.setShort(7, producto.getIdUsuario());
            rs = ps.executeQuery();
            if(rs.next()){
                idPro = rs.getShort(1);
            }
        } catch (SQLException ex) {
           MensajesPersonalizados.mostrarErrorException(ex.toString());
        }finally{
            cerrar(ps, rs, cn);
        }
        return idPro;
    }

    @Override
    public short eliminarProducto(Producto producto) {
        short idProducto = 0;
        try {
            cn = conectar();
            ps = cn.prepareStatement(ELIMINAR_PRODUCTO);
            ps.setShort(1, producto.getIdProducto());
            rs = ps.executeQuery();
            if(rs.next()){
                idProducto = rs.getShort(1);
            }
        } catch (SQLException ex) {
            MensajesPersonalizados.mostrarErrorException(ex.toString());
        }
        return idProducto;
    }


    

}
