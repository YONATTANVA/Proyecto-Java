/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Categoria;
import modelos.Producto;

/**
 *
 * @author YonattanVisita
 */
public class ProductoDAO {
    final String CONSULTA = "SELECT id_producto,nombre,precio,stock,categoria FROM consultar_productos()";
    private PreparedStatement pst;
    private ResultSet rs = null;
    private Connection cn = null;
    
    public List<Producto> listaProductos(){
        List<Producto> productos = new ArrayList<>();
        try {
            cn = DAO.conectar();
            rs = pst.executeQuery(CONSULTA);
            while(rs.next()){
                productos.add(convertir(rs));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            DAO.cerrar(pst, rs, cn);
        }
        return productos;
    }
    
    private Producto convertir(ResultSet rs){
        Producto producto = new Producto();
        try {
            producto.idProducto = rs.getShort("id_producto");
            producto.nombre = rs.getString("nombre");
            producto.precio = rs.getFloat("precio");
            producto.stock = rs.getShort("stock");
            //producto.categoria = rs.getObject("categoria",Categoria );
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return producto;
    }
    
}
