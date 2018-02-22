/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.controlador;

import com.OldSpace.gui.frame.Principal;
import com.OldSpace.gui.internalFrame.Inventario;
import com.OldSpace.gui.internalFrame.Venta;
import com.OldSpace.modelos.dao.DAOProductoImpl;
import com.OldSpace.modelos.interfaces.DAOProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;

/**
 *
 * @author YonattanVisita
 */
public class ControladorPrincipal implements ActionListener{
    private Principal principal = null;
    private JDesktopPane contenedor = null;
    
    Venta ventaFrame = null;
    Inventario inventarioFrame = null;
    
    public ControladorPrincipal(Principal _principal){
        this.principal = _principal;
        this.contenedor = _principal.contenedorModulos;
        this.principal.btnInventario.addActionListener(this);
        this.principal.btnVenta.addActionListener(this);
        inicializarPrincipal();
    }
    private void inicializarPrincipal() {
        this.principal.setVisible(true);
      
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.principal.btnInventario){
            if(inventarioFrame == null){
                inventarioFrame = new Inventario();
                contenedor.add(inventarioFrame);
                DAOProducto dao = DAOProductoImpl.getInstancia();
                ControladorInventario ctrInventario = new ControladorInventario(inventarioFrame,dao);
                contenedor.getDesktopManager().maximizeFrame(inventarioFrame);
            }else{
                contenedor.getDesktopManager().maximizeFrame(inventarioFrame);
            }
        }
        if(e.getSource() == this.principal.btnVenta){
            //FALTA EL MODULO VENTAS
            if(ventaFrame == null){
                ventaFrame = new Venta();
                contenedor.add(ventaFrame);
                ventaFrame.setLocation(0, 0);
                ventaFrame.setVisible(true);
                contenedor.getDesktopManager().maximizeFrame(ventaFrame);
            }else{
                contenedor.getDesktopManager().maximizeFrame(ventaFrame);
            }
        }
    }

    
    
}
