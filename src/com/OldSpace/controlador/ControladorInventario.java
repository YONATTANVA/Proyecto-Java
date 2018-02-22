/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.controlador;

import com.OldSpace.gui.dialog.NuevaCategoria;
import com.OldSpace.gui.dialog.NuevoProducto;
import com.OldSpace.gui.dialog.NuevoProveedor;
import com.OldSpace.gui.internalFrame.Inventario;
import com.OldSpace.modelos.dao.DAOCategoriaImpl;
import com.OldSpace.modelos.dao.DAOProductoImpl;
import com.OldSpace.modelos.dao.DAOProveedorImpl;
import com.OldSpace.modelos.interfaces.DAOCategoria;
import com.OldSpace.modelos.interfaces.DAOProducto;
import com.OldSpace.modelos.interfaces.DAOProveedor;
import com.OldSpace.modelos.pojos.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YonattanVisita
 */
public class ControladorInventario implements ActionListener,KeyListener{

    
    private DAOProducto dao = null;
    DAOProductoImpl daoP = null;
    private Inventario vInventario = null;
    private DefaultTableModel modeloTabla = null;
    private short paginaConsulta;
    
    public ControladorInventario(Inventario _vInventario, DAOProducto _dao){
        this.vInventario = _vInventario;
        this.dao = _dao;
        this.modeloTabla = new DefaultTableModel();
        this.vInventario.btnAddStock.addActionListener(this);
        this.vInventario.btnDeleteProduct.addActionListener(this);
        this.vInventario.btnUpdateProduct.addActionListener(this);
        this.vInventario.btnNewProduct.addActionListener(this);
        this.vInventario.btnNewProvider.addActionListener(this);
        this.vInventario.btnNewCategory.addActionListener(this);
        this.vInventario.btnNexPage.addActionListener(this);
        this.vInventario.btnBackPage.addActionListener(this);
        this.vInventario.btnStarPage.addActionListener(this);
        this.vInventario.txtSearchProduct.addKeyListener(this);
        inicializarInventario();
    }
    
    
    
    private void inicializarInventario() {
        daoP =(DAOProductoImpl)dao;
        this.paginaConsulta = 1;
        vInventario.tblListProducts.setModel(modeloTabla);
        vInventario.txtNumberPage.setText(String.valueOf(this.paginaConsulta));
        vInventario.setLocation(0, 0);
        vInventario.setVisible(true);
        generarColumnasTabla();
        cargarTabla("");
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vInventario.btnNewProduct){
            NuevoProducto modal = new NuevoProducto(null, true);
            DAOProducto dao = DAOProductoImpl.getInstancia();
            ControladorNuevoProducto ctrNuevoProducto = new ControladorNuevoProducto(modal, dao);
        }
        if(e.getSource() == vInventario.btnNewCategory){
            NuevaCategoria modal = new NuevaCategoria(null, true);
            DAOCategoria dao = DAOCategoriaImpl.getInstancia();
            ControladorCategoria ctrNuevCategoria = new ControladorCategoria(modal, dao);
        }
        if(e.getSource() == vInventario.btnNewProvider){
            NuevoProveedor modal = new NuevoProveedor(null, true);
            DAOProveedor dao = DAOProveedorImpl.getInstancia();
            ControladorNuevoProveedor ctrNuevoProveedor = new ControladorNuevoProveedor(modal, dao);
        }
        if(e.getSource() == vInventario.btnNexPage){
            this.paginaConsulta++;
            daoP.setPagina(this.paginaConsulta);
            cargarTabla("");
            vInventario.txtNumberPage.setText(String.valueOf(this.paginaConsulta));
        }
        if(e.getSource() == vInventario.btnBackPage){
            this.paginaConsulta--;
            daoP.setPagina(this.paginaConsulta);
            cargarTabla("");
            vInventario.txtNumberPage.setText(String.valueOf(this.paginaConsulta));
        }
        if(e.getSource() == vInventario.btnStarPage){
            this.paginaConsulta = 1;
            daoP.setPagina(this.paginaConsulta);
            cargarTabla("");
            vInventario.txtNumberPage.setText(String.valueOf(this.paginaConsulta));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == vInventario.txtSearchProduct){
            this.paginaConsulta = 1;
            daoP.setPagina(this.paginaConsulta);
            String filtro = vInventario.txtSearchProduct.getText();
            cargarTabla(filtro);
            vInventario.txtNumberPage.setText(String.valueOf(this.paginaConsulta));
        }
    }
    
    
    private void generarColumnasTabla(){
        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Stock");
        modeloTabla.addColumn("Categoria");
    }
    
    private void cargarTabla(String _filtro){
        limpiarTabla();
        List<Producto> listaProductos = dao.listarTodosProductos(_filtro);
        int cantidadFilas = listaProductos.size();
        modeloTabla.setNumRows(cantidadFilas);
        for (int i = 0; i < cantidadFilas; i++) {
            Producto pro = listaProductos.get(i);
            modeloTabla.setValueAt(pro.getIdProducto(), i, 0);
            modeloTabla.setValueAt(pro.getNombre(), i, 1);
            modeloTabla.setValueAt(pro.getPrecio(), i, 2);
            modeloTabla.setValueAt(pro.getStock(), i, 3);
            modeloTabla.setValueAt(pro.getCategoria(), i, 4);
        }
    }
    
    private void limpiarTabla(){
        int cantidadItems = modeloTabla.getRowCount();
        //System.out.println(cantidadItems);
        for(int i = cantidadItems - 1; i >= 0 ; i--){
            modeloTabla.removeRow(i);
        }
    }
    
    
    
    
}
