/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.interfaces;

import java.util.List;
import com.OldSpace.modelos.beans.Categoria;

/**
 *
 * @author YonattanVisita
 */
public interface DAOCategoria {
    public abstract List<Categoria> listarCategorias();
    
    public abstract short insertarCategoria(Categoria categoria);
}
