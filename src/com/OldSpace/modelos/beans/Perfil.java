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
public class Perfil implements Serializable {
    private short idPerfil;
    private String perfil;
    private String usuario;
    private short idUsuario;

    public short getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(short idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
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
