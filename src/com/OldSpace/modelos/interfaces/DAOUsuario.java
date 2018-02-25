/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.interfaces;

import com.OldSpace.modelos.beans.Usuario;

/**
 *
 * @author YonattanVisita
 */
public interface DAOUsuario {
    public abstract Usuario autenticarUsuario(Usuario usuario);
}
