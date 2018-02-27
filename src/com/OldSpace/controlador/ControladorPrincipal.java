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
import com.OldSpace.modelos.dao.DAOUsuarioImpl;
import com.OldSpace.modelos.interfaces.DAOProducto;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;

/**
 *
 * @author YonattanVisita
 */
public class ControladorPrincipal extends MouseAdapter implements ActionListener{
    private Principal principal = null;
    private JDesktopPane contenedor = null;
    
    private Venta ventaFrame = null;
    private Inventario inventarioFrame = null;
    
    public ControladorPrincipal(Principal principal){
        this.principal = principal;
        contenedor = this.principal.contenedorModulos;
        this.principal.btnInventario.addActionListener(this);
        this.principal.btnVenta.addActionListener(this);
        this.principal.btnCerrar.addMouseListener(this);
        this.principal.btnCerrar.addActionListener(this);
        this.inicializarPrincipal();
    }
    private void inicializarPrincipal() {
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
        principal.lblPerfil.setText(DAOUsuarioImpl.getSesion().getPerfil());
        principal.lblUsuario.setText(DAOUsuarioImpl.getSesion().getNombre());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.principal.btnInventario){
            if(inventarioFrame == null){
                long inicio = System.nanoTime();
                inventarioFrame = new Inventario();
                contenedor.add(inventarioFrame);
                DAOProducto dao = DAOProductoImpl.getInstancia();
                ControladorInventario ctrInventario = new ControladorInventario(inventarioFrame,dao);
                contenedor.getDesktopManager().maximizeFrame(inventarioFrame);
                System.out.println(System.nanoTime() - inicio);
            }else{
                contenedor.getDesktopManager().maximizeFrame(inventarioFrame);
            }
        }
        if(e.getSource() == this.principal.btnVenta){
            //FALTA EL MODULO VENTAS
            if(ventaFrame == null){
                long inicio = System.nanoTime();
                ventaFrame = new Venta();
                contenedor.add(ventaFrame);
                ventaFrame.setLocation(0, 0);
                ((javax.swing.plaf.basic.BasicInternalFrameUI)ventaFrame.getUI()).setNorthPane(null);
                ventaFrame.setVisible(true);
                contenedor.getDesktopManager().maximizeFrame(ventaFrame);
                System.out.println(System.nanoTime() - inicio);
            }else{
                contenedor.getDesktopManager().maximizeFrame(ventaFrame);
            }
        }
        if(e.getActionCommand() == "x"){
            principal.dispose();
        }
        
    }

    @Override
        public void mouseEntered​(MouseEvent e){
            if(e.getSource() == principal.btnCerrar){
                principal.btnCerrar.setForeground(Color.WHITE);
            }
        }
        @Override
        public void mouseExited​(MouseEvent e){
            if(e.getSource() == principal.btnCerrar){
                principal.btnCerrar.setForeground(Color.BLACK);
            }
        }
    
}
