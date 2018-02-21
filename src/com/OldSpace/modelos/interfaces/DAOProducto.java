/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.interfaces;

import java.util.List;
import com.OldSpace.modelos.pojos.Producto;

/**
 *
 * @author YonattanVisita
 */
public interface DAOProducto {
    
    public abstract List<Producto> listarTodosProductos(String _filtro);
    
    public abstract List<Producto> listarTodosProductos(short _categoria);
    
    public short insertarProducto(Producto producto);
}
