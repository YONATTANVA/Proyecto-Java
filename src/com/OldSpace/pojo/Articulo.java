/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.pojo;

import java.io.File;

/**
 *
 * @author YonattanVisita
 */
public class Articulo {
    private int idArticulo;
    private String nombre;
    private String descripcion;
    private File imagen;
    private int stockRequerido;
    private String unidadMedida;
    private double precioCompra;
    private double precioVenta;
    private int stock;
    private int idCategoria;
    private int idProveedor;

    public Articulo(int idArticulo, String nombre, String descripcion, File imagen, int stockRequerido, String unidadMedida, double precioCompra, double precioVenta, int stock, int idCategoria, int idProveedor) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.stockRequerido = stockRequerido;
        this.unidadMedida = unidadMedida;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public File getImagen() {
        return imagen;
    }

    public void setImagen(File imagen) {
        this.imagen = imagen;
    }

    public int getStockRequerido() {
        return stockRequerido;
    }

    public void setStockRequerido(int stockRequerido) {
        this.stockRequerido = stockRequerido;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.getIdArticulo());
    }
}
