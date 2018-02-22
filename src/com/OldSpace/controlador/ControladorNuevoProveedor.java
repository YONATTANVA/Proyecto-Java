/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.controlador;

import com.OldSpace.gui.dialog.NuevoProveedor;
import com.OldSpace.modelos.interfaces.DAOProveedor;
import com.OldSpace.modelos.pojos.Proveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author YonattanVisita
 */
public class ControladorNuevoProveedor implements ActionListener{
    private NuevoProveedor vnuNuevoProveedor = null;
    private DAOProveedor dao = null;
    private Proveedor proveedor = null;
    
    public ControladorNuevoProveedor(NuevoProveedor _vnuNuevoProveedor, DAOProveedor _dao){
        this.vnuNuevoProveedor = _vnuNuevoProveedor;
        this.dao = _dao;
        this.vnuNuevoProveedor.btnSave.addActionListener(this);
        this.vnuNuevoProveedor.btnCancel.addActionListener(this);
        inicializarNuevoProveedor();
    }

    private void inicializarNuevoProveedor() {
        vnuNuevoProveedor.setAlwaysOnTop(true);
        vnuNuevoProveedor.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        vnuNuevoProveedor.setLocationRelativeTo(null);
        vnuNuevoProveedor.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vnuNuevoProveedor.btnSave){
            short idProveedor;
            proveedor = new Proveedor();
            proveedor.setNombreContacto(vnuNuevoProveedor.txtNameContac.getText());
            proveedor.setTelefono(vnuNuevoProveedor.txtPhone.getText());
            proveedor.setEmail(vnuNuevoProveedor.txtMail.getText());
            proveedor.setDireccion(vnuNuevoProveedor.txtAdress.getText());
            proveedor.setNombreEmpresa(vnuNuevoProveedor.txtName.getText());
            proveedor.setIdUsuario((short)3);
            proveedor.setRuc(vnuNuevoProveedor.txtRuc.getText());
            
            idProveedor = dao.insertarProveedor(proveedor);
            if(idProveedor != 0){
                JOptionPane.showMessageDialog(vnuNuevoProveedor, "Se registro con exito el proveedor con codigo: " + idProveedor);
            }else{
                JOptionPane.showMessageDialog(vnuNuevoProveedor, "Error al intentar registrar un proveedor");
            }
        }
        if(e.getSource() == vnuNuevoProveedor.btnCancel){
            this.vnuNuevoProveedor.dispose();
        }
    }
}
