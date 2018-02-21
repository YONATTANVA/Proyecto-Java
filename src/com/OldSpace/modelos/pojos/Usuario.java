/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.pojos;

/**
 *
 * @author YonattanVisita
 */
public class Usuario {
    private short idPsuario;
    private String nombre;
    private String clave;
    private String perfil;

    public short getIdPsuario() {
        return idPsuario;
    }

    public void setIdPsuario(short idPsuario) {
        this.idPsuario = idPsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
}
