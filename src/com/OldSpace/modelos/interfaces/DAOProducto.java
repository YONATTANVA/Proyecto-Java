/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.interfaces;

import java.util.List;
import com.OldSpace.modelos.beans.Producto;

/**
 *
 * @author YonattanVisita
 */
public interface DAOProducto {
    
    public abstract List<Producto> listarTodosProductos();
    
    public abstract List<Producto> listarTodosProductos(String _filtro);
    
    public short insertarProducto(Producto producto);
    
    public short actualizarProducto(Producto producto);
    
    public short eliminarProducto(Producto producto);
}
