/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Calendar;

/**
 *
 * @author YonattanVisita
 */
public class Venta {
    public short idVenta;
    public String fecha;
    public Cliente cliente;
    public Usuario usuario;
    public FormaPago formaPago;
    public Estado estado;
}
