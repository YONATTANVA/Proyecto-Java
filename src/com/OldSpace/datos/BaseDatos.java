/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.datos;

import com.OldSpace.pojo.Articulo;
import com.OldSpace.pojo.Categoria;
import com.OldSpace.pojo.DetalleVenta;
import com.OldSpace.pojo.Proveedor;
import com.OldSpace.pojo.Venta;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YonattanVisita
 */
public class BaseDatos {
    Connection conex;
    ResultSet rs;
    String sql;
    PreparedStatement st;
    public BaseDatos(){
        
    }
    
    public void insertarArticulo( Articulo articulo ){
        try {
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            
            File fotoArticulo = articulo.getImagen();
            FileInputStream fotoStream = new FileInputStream(fotoArticulo);
            
            sql = "INSERT INTO articulo VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            
            st = conex.prepareStatement(sql);
            
            st.setInt(1, articulo.getIdArticulo());
            st.setString(2, articulo.getNombre());
            st.setString(3, articulo.getDescripcion());
            st.setBinaryStream(4, fotoStream,fotoArticulo.length());
            st.setInt(5, articulo.getStockRequerido());
            st.setString(6, articulo.getUnidadMedida());
            st.setDouble(7, articulo.getPrecioCompra());
            st.setDouble(8, articulo.getPrecioVenta());
            st.setInt(9, articulo.getStock());
            st.setInt(10, articulo.getIdCategoria());
            st.setInt(11, articulo.getIdProveedor());
            
            st.executeUpdate();

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                st.close();
                conex.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public void insertarCategoria( Categoria categoria){
        try {
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            
            sql = "INSERT INTO categoria_articulo VALUES (?,?,?)";
            
            st = conex.prepareStatement(sql);
            st.setInt(1, categoria.getIdCategoria());
            st.setString(2, categoria.getNombre());
            st.setString(3, categoria.getDescripcion());
            
            st.executeUpdate();

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                st.close();
                conex.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public void insertarProveedor( Proveedor proveedor ){
        try {
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            
            sql = "INSERT INTO proveedor VALUES (?,?,?,?,?,?)";
            
            st = conex.prepareStatement(sql);
            st.setInt(1, proveedor.getIdProveedor());
            st.setString(2, proveedor.getNombre());
            st.setString(3, proveedor.getDireccion());
            st.setString(4, proveedor.getTelefono());
            st.setString(5, proveedor.getCorreo());
            st.setString(6, proveedor.getNombreContacto());
            
            st.executeUpdate();

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                st.close();
                conex.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public void insertarVenta ( Venta venta ){
        try {
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            
            sql = "INSERT INTO venta VALUES (?,?)";
            
            st = conex.prepareStatement(sql);
            st.setInt(1, venta.getIdVenta());
            st.setDate(2, venta.getFecha());
            
            st.executeUpdate();

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                st.close();
                conex.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public void insertarDetalleVenta( DetalleVenta dv){
        try {
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            
            sql = "INSERT INTO detalle_venta VALUES (?,?,?,?)";
            
            st = conex.prepareStatement(sql);
            st.setInt(1, dv.getIdDetalleVenta());
            st.setInt(2, dv.getCantidad());
            st.setInt(3, dv.getIdArticulo());
            st.setInt(4, dv.getIdVenta());
            
            st.executeUpdate();

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                st.close();
                conex.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public void actualizarDetalleVenta( DetalleVenta dv){
        try {
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            
            sql = "UPDATE detalle_venta SET cantidad_detvent = ?, id_art = ?, id_vent = ? WHERE id_detavent = ?";
            
            st = conex.prepareStatement(sql);
            
            st.setInt(1, dv.getCantidad());
            st.setInt(2, dv.getIdArticulo());
            st.setInt(3, dv.getIdVenta());
            st.setInt(4, dv.getIdDetalleVenta());
            
            st.executeUpdate();

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                st.close();
                conex.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    public void actualizarArticulo( Articulo articulo){
        try {
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            
            sql = "UPDATE articulo SET nombre_art = ?, descripcion_art = ?, , stock_requerido_art = ?, unidad_medida_art = ?, precio_compra_art = ?,"
                    + " precio_vemta_art = ?, stock_art = ?, id_cat = ?, id_prov = ? WHERE id_art = ?";
            
            st = conex.prepareStatement(sql);
            
            
            st.setString(1, articulo.getNombre());
            st.setString(2, articulo.getDescripcion());
            //st.setByte(3, articulo.getImagen());
            st.setInt(3, articulo.getStockRequerido());
            st.setString(4, articulo.getUnidadMedida());
            st.setDouble(5, articulo.getPrecioCompra());
            st.setDouble(6, articulo.getPrecioVenta());
            st.setInt(7, articulo.getStock());
            st.setInt(8, articulo.getIdCategoria());
            st.setInt(9, articulo.getIdProveedor());
            st.setInt(10, articulo.getIdArticulo());
            
            st.executeUpdate();

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                st.close();
                conex.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    public void actualizarProveedor( Proveedor proveedor){
        try {
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            
            sql = "UPDATE proveedor SET nombre_prov = ?, direccion_prov = ?, telefono_prov = ?, correo_prov = ?, nombre_contacto_prov = ? WHERE id_prov = ?";
            
            st = conex.prepareStatement(sql);
            
            
            st.setString(1, proveedor.getNombre());
            st.setString(2, proveedor.getDireccion());
            st.setString(3, proveedor.getTelefono());
            st.setString(4, proveedor.getCorreo());
            st.setString(5, proveedor.getNombreContacto());
            st.setInt(6, proveedor.getIdProveedor());
            
            st.executeUpdate();

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                st.close();
                conex.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    public void actualizarVenta( Venta venta){
        try {
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            
            sql = "UPDATE venta SET (fecha_vent = ?) WHERE id_vent = ?";
            
            st = conex.prepareStatement(sql);
            
            st.setDate(1, venta.getFecha());
            st.setInt(2, venta.getIdVenta());
            
            st.executeUpdate();

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                st.close();
                conex.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    public void actualizarCategoria( Categoria categoria){
        try {
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            
            sql = "UPDATE categoria_articulo SET (nombre_cat = ?, descripcion_cat = ?) WHERE id_cat = ?";
            
            st = conex.prepareStatement(sql);
            
            
            st.setString(1, categoria.getNombre());
            st.setString(2, categoria.getDescripcion());
            st.setInt(3, categoria.getIdCategoria());
            
            st.executeUpdate();

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                st.close();
                conex.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public void eliminarVenta(Venta venta){
        
        try {
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            sql = "DELETE FROM venta WHERE id_vent = ?";
            st = conex.prepareStatement(sql);
            
            st.setInt(1, venta.getIdVenta());
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                st.close();
                conex.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        
    }
    
    public void eliminarArticulo(Articulo articulo){
        
        try {
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            sql = "DELETE FROM articulo WHERE id_art = ?";
            st = conex.prepareStatement(sql);
            
            st.setInt(1, articulo.getIdArticulo());
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                st.close();
                conex.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        
    }
    
    public void eliminarProveedor(Proveedor proveedor){
        
        try {
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            sql = "DELETE FROM proveedor WHERE id_prov = ?";
            st = conex.prepareStatement(sql);
            
            st.setInt(1, proveedor.getIdProveedor());
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                st.close();
                conex.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        
    }
    
    public void eliminarCategoria(Categoria categoria){
        
        try {
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            sql = "DELETE FROM categoria_articulo WHERE id_cat = ?";
            st = conex.prepareStatement(sql);
            
            st.setInt(1, categoria.getIdCategoria());
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                st.close();
                conex.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        
    }
    
    public void eliminarDetalleVenta(DetalleVenta dv){
        
        try {
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            sql = "DELETE FROM detalle_venta WHERE id_detven = ?";
            st = conex.prepareStatement(sql);
            
            st.setInt(1, dv.getIdDetalleVenta());
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                st.close();
                conex.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        
    }
    
    
    public ArrayList<Articulo> listarArticulos(){
        
        ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();
        try {
            Class.forName("org.postgresql.Driver");
            
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            
            sql = "SELECT * FROM articulo ORDER BY nombre_art ASC";
            st = conex.prepareStatement(sql);
            
            rs = st.executeQuery();
            
            while(rs.next()){
                Articulo articulo = new Articulo(rs.getInt(1), rs.getString(2), rs.getString(3), null, rs.getInt(5), rs.getString(6), rs.getDouble(7), rs.getDouble(8),rs.getInt(9), rs.getInt(10), rs.getInt(11));
                listaArticulos.add(articulo);
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                st.close();
                conex.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        return listaArticulos;
    }
    
    public ArrayList<Categoria> listarCategorias(){
        
        ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
        try {
            Class.forName("org.postgresql.Driver");
            
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            
            sql = "SELECT * FROM categoria_articulo";
            st = conex.prepareStatement(sql);
            
            rs = st.executeQuery();
            
            while(rs.next()){
                Categoria categoria = new Categoria(rs.getInt(1), rs.getString(2), rs.getString(3));
                listaCategorias.add(categoria);
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                st.close();
                conex.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        return listaCategorias;
    }
    
    public ArrayList<Proveedor> listarProveedores(){
        
        ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
        try {
            Class.forName("org.postgresql.Driver");
            
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            
            sql = "SELECT * FROM proveedor";
            st = conex.prepareStatement(sql);
            
            rs = st.executeQuery();
            
            while(rs.next()){
                Proveedor proveedor = new Proveedor(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6));
                listaProveedores.add(proveedor);
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                st.close();
                conex.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        return listaProveedores;
    }
    
    public void actualizarStockArticulo(int stock, int id){
        try {
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBVentas", "postgres", "123");
            sql = "UPDATE articulo SET stock_art = ? WHERE id_art = ?";
            st = conex.prepareStatement(sql);
            st.setInt(2, id);
            st.setInt(1, stock);
            st.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                conex.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
            
        }
        
    }
    
    
}
