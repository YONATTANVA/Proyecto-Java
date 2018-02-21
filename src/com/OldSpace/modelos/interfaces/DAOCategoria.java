/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.interfaces;

import java.util.List;
import com.OldSpace.modelos.pojos.Categoria;

/**
 *
 * @author YonattanVisita
 */
public interface DAOCategoria {
    public abstract List<Categoria> listarCategorias();
}
