/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.controlador;

import com.OldSpace.gui.dialog.NuevaCategoria;
import com.OldSpace.gui.dialog.NuevoProducto;
import com.OldSpace.modelos.dao.DAOCategoriaImpl;
import com.OldSpace.modelos.interfaces.DAOCategoria;
import com.OldSpace.modelos.interfaces.DAOProducto;
import com.OldSpace.modelos.pojos.Categoria;
import com.OldSpace.modelos.pojos.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author YonattanVisita
 */
public class ControladorNuevoProducto implements ActionListener{
    
    private NuevoProducto vNuevoProducto = null;
    private DAOProducto dao = null;
    private DefaultComboBoxModel<Categoria> modeloComboCat = null;
    
    public ControladorNuevoProducto(NuevoProducto _vNuevoProducto, DAOProducto _dao){
        this.vNuevoProducto = _vNuevoProducto;
        this.dao = _dao;
        this.vNuevoProducto.btnSave.addActionListener(this);
        this.vNuevoProducto.btnCancel.addActionListener(this);
        this.vNuevoProducto.btnNewCategory.addActionListener(this);
        modeloComboCat = new DefaultComboBoxModel<>();
        inicializarNuevoProducto();
    }
    
    private void inicializarNuevoProducto() {
        vNuevoProducto.cbCategory.setModel(modeloComboCat);
        cargarModeloComboCat();
        vNuevoProducto.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        vNuevoProducto.setAlwaysOnTop(true);
        vNuevoProducto.setLocationRelativeTo(null);
        vNuevoProducto.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vNuevoProducto.btnNewCategory){
            NuevaCategoria modal = new NuevaCategoria(null, true);
            DAOCategoria dao = DAOCategoriaImpl.getInstancia();
            ControladorCategoria ctrNuevCategoria = new ControladorCategoria(modal, dao);
        }
        if(e.getSource() == vNuevoProducto.btnCancel){
            this.vNuevoProducto.dispose();
        }
        if(e.getSource() == vNuevoProducto.btnSave){
            short idProducto;
            Producto producto = new Producto();
            Categoria cat = (Categoria)vNuevoProducto.cbCategory.getSelectedItem();
            producto.setNombre(vNuevoProducto.txtName.getText());
            producto.setPrecio(Float.parseFloat(vNuevoProducto.txtPrice.getText()));
            producto.setStock(Short.parseShort(vNuevoProducto.txtStock.getText()));
            producto.setIdCategoria(cat.getIdCategoria());
            producto.setUsuario((short)2);
            
            idProducto = dao.insertarProducto(producto);
            if(idProducto != 0){
                JOptionPane.showMessageDialog(vNuevoProducto, "Se ingreso un producto con el Codigo: " + idProducto);
            }else{
                JOptionPane.showMessageDialog(vNuevoProducto, "Error al intentar registrar un producto");
            }
        }
    }
    
    private void cargarModeloComboCat(){
        
        DAOCategoria daoC = DAOCategoriaImpl.getInstancia();
        List<Categoria> listaCat = daoC.listarCategorias();
        for (Categoria categoria : listaCat) {
            modeloComboCat.addElement(categoria);
        }
    }
}   
