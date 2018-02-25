/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.beans;

import java.io.Serializable;

/**
 *
 * @author YonattanVisita
 */
public class Categoria implements Serializable{
    private short idCategoria;
    private String categoria;
    private short idUsuario;
    private String usuario;

    public short getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(short idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public short getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(short idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    @Override
    public String toString(){
        return this.getCategoria();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
