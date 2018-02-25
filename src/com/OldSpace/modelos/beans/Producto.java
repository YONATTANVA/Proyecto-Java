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
public class Producto implements Serializable {
    private short idProducto;
    private String nombre;
    private float precio;
    private short stock;
    private String imagen;
    private String categoria;
    private short idCategoria;
    private String usuario;
    private short idUsuario;

    public short getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(short idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public short getStock() {
        return stock;
    }

    public void setStock(short stock) {
        this.stock = stock;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public short getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(short idCategoria) {
        this.idCategoria = idCategoria;
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
