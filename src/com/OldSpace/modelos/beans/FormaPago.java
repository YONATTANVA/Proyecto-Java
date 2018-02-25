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
public class FormaPago implements Serializable{
    private short idFormaPago;
    private String formaPago;
    private String usuario;
    private short idUsuario;
    
    public short getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(short idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public short getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(short idUsuario) {
        this.idUsuario = idUsuario;
    }
}
