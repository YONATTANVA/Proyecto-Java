/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.interfaces;

import java.util.List;
import com.OldSpace.modelos.beans.Proveedor;

/**
 *
 * @author YonattanVisita
 */
public interface DAOProveedor {
    public abstract List<Proveedor> listarProveedores();
    
    public abstract short insertarProveedor(Proveedor proveedor);
}
