/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.controlador;

import com.OldSpace.excepciones.MensajesPersonalizados;
import com.OldSpace.gui.dialog.NuevaCategoria;
import com.OldSpace.gui.dialog.NuevoProducto;
import com.OldSpace.modelos.dao.DAOCategoriaImpl;
import com.OldSpace.modelos.interfaces.DAOCategoria;
import com.OldSpace.modelos.interfaces.DAOProducto;
import com.OldSpace.modelos.beans.Categoria;
import com.OldSpace.modelos.beans.Producto;
import com.OldSpace.modelos.dao.DAOUsuarioImpl;
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
    
    public ControladorNuevoProducto(NuevoProducto vNuevoProducto, DAOProducto dao){
        this.vNuevoProducto = vNuevoProducto;
        this.dao = dao;
        this.vNuevoProducto.btnSave.addActionListener(this);
        this.vNuevoProducto.btnCancel.addActionListener(this);
        this.vNuevoProducto.btnNewCategory.addActionListener(this);
        modeloComboCat = new DefaultComboBoxModel<>();
        this.inicializarNuevoProducto();
    }
    
    private void inicializarNuevoProducto() {
        vNuevoProducto.cbCategory.setModel(modeloComboCat);
        this.cargarModeloComboCat();
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
            ControladorNuevaCategoria ctrNuevCategoria = new ControladorNuevaCategoria(modal, dao);
        }
        
        if(e.getSource() == vNuevoProducto.btnCancel){
            vNuevoProducto.dispose();
        }
        
        if(e.getSource() == vNuevoProducto.btnSave){
            short idProducto;
            Producto producto = new Producto();
            Categoria cat = (Categoria)vNuevoProducto.cbCategory.getSelectedItem();
            producto.setNombre(vNuevoProducto.txtName.getText());
            producto.setPrecio(Float.parseFloat(vNuevoProducto.txtPrice.getText()));
            producto.setStock(Short.parseShort(vNuevoProducto.txtStock.getText()));
            producto.setIdCategoria(cat.getIdCategoria());
            producto.setIdUsuario(DAOUsuarioImpl.getSesion().getIdUsuario());
            
            idProducto = dao.insertarProducto(producto);
            if(idProducto != 0){
                MensajesPersonalizados.mostrarValidacionCorrecta("Se ingreso un producto con el Codigo: "+ idProducto, vNuevoProducto);
                vNuevoProducto.dispose();
            }else{
                MensajesPersonalizados.mostrarErrorValidacion("", vNuevoProducto);
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
