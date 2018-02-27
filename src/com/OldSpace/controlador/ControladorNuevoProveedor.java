/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.controlador;

import com.OldSpace.excepciones.MensajesPersonalizados;
import com.OldSpace.gui.dialog.NuevoProveedor;
import com.OldSpace.modelos.interfaces.DAOProveedor;
import com.OldSpace.modelos.beans.Proveedor;
import com.OldSpace.modelos.dao.DAOUsuarioImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author YonattanVisita
 */
public class ControladorNuevoProveedor implements ActionListener{
    
    private NuevoProveedor vNuevoProveedor = null;
    private DAOProveedor dao = null;
    private Proveedor proveedor = null;
    
    public ControladorNuevoProveedor(NuevoProveedor vnuNuevoProveedor, DAOProveedor dao){
        this.vNuevoProveedor = vnuNuevoProveedor;
        this.dao = dao;
        this.vNuevoProveedor.btnSave.addActionListener(this);
        this.vNuevoProveedor.btnCancel.addActionListener(this);
        this.inicializarNuevoProveedor();
    }

    private void inicializarNuevoProveedor() {
        vNuevoProveedor.setAlwaysOnTop(true);
        vNuevoProveedor.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        vNuevoProveedor.setLocationRelativeTo(null);
        vNuevoProveedor.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vNuevoProveedor.btnSave){
            short idProveedor;
            proveedor = new Proveedor();
            proveedor.setNombreContacto(vNuevoProveedor.txtNameContac.getText());
            proveedor.setTelefono(vNuevoProveedor.txtPhone.getText());
            proveedor.setEmail(vNuevoProveedor.txtMail.getText());
            proveedor.setDireccion(vNuevoProveedor.txtAdress.getText());
            proveedor.setNombreEmpresa(vNuevoProveedor.txtName.getText());
            proveedor.setIdUsuario(DAOUsuarioImpl.getSesion().getIdUsuario());
            proveedor.setRuc(vNuevoProveedor.txtRuc.getText());
            
            idProveedor = dao.insertarProveedor(proveedor);
            if(idProveedor != 0){
                MensajesPersonalizados.mostrarValidacionCorrecta("Se registro con exito el proveedor con codigo: " + idProveedor, vNuevoProveedor);
                vNuevoProveedor.dispose();
            }else{
                MensajesPersonalizados.mostrarErrorValidacion("", vNuevoProveedor);
            }
        }
        if(e.getSource() == vNuevoProveedor.btnCancel){
            vNuevoProveedor.dispose();
        }
    }
}
