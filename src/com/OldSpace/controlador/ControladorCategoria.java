/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.controlador;

import com.OldSpace.gui.dialog.NuevaCategoria;
import com.OldSpace.modelos.interfaces.DAOCategoria;
import com.OldSpace.modelos.pojos.Categoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author YonattanVisita
 */
public class ControladorCategoria implements ActionListener{
    
    private NuevaCategoria vNuevaCategoria = null;
    private DAOCategoria dao = null;
    private Categoria categoria = null;
    
    public ControladorCategoria(NuevaCategoria _vNuevaCategoria, DAOCategoria _dao){
        this.vNuevaCategoria = _vNuevaCategoria;
        this.dao = _dao;
        this.vNuevaCategoria.btnSave.addActionListener(this);
        this.vNuevaCategoria.btnCancel.addActionListener(this);
        inicializarNuevaCategoria();
    }
    
    private void inicializarNuevaCategoria(){
        vNuevaCategoria.setLocationRelativeTo(null);
        vNuevaCategoria.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        vNuevaCategoria.setAlwaysOnTop(true);
        vNuevaCategoria.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vNuevaCategoria.btnSave){
            short idCategoria;
            categoria = new Categoria();
            categoria.setCategoria(vNuevaCategoria.txtName.getText());
            categoria.setIdUsuario((short)3);
            idCategoria = dao.insertarCategoria(categoria);
            if(idCategoria != 0){
                JOptionPane.showMessageDialog(vNuevaCategoria,"Se registro con exito la categoria con Codigo: " + idCategoria);
            }else{
                JOptionPane.showMessageDialog(vNuevaCategoria,"Error al intentar registrar una categoria");
            }
        }
        if(e.getSource() == vNuevaCategoria.btnCancel){
            vNuevaCategoria.dispose();
        }
    }
    
    
}