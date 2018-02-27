/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.controlador;

import com.OldSpace.excepciones.MensajesPersonalizados;
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
import com.OldSpace.modelos.beans.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.util.Arrays;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import libreriasPropias.GenericDomainTableModel;

/**
 *
 * @author YonattanVisita
 */
public class ControladorInventario implements ActionListener,KeyListener,MouseListener{

    
    private DAOProducto dao = null;
    private DAOProductoImpl daoP = null;
    private Inventario vInventario = null;
    private GenericDomainTableModel<Producto> modeloTabla = null;
    private Producto producto = null;
    private short paginaConsulta;
    private List<Producto> listaProductos = null;
    private Object[] columnasTabla = null;
    
    public ControladorInventario(JInternalFrame vInventario, DAOProducto dao){
        this.vInventario = (Inventario)vInventario;
        this.dao = dao;
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
        this.vInventario.tblListProducts.addMouseListener(this);
        this.inicializarInventario();
    }
    
    
    
    private void inicializarInventario() {
        this.desabilitarBotonesTabla();
        //long inicio = System.nanoTime();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)vInventario.getUI()).setNorthPane(null);
        daoP =(DAOProductoImpl)dao;
        paginaConsulta = 1;
        vInventario.txtNumberPage.setText(String.valueOf(this.paginaConsulta));
        vInventario.setLocation(0, 0);
        vInventario.setVisible(true);
        this.modelarTabla();
        this.cargarTabla(null);
        //System.out.println(System.nanoTime() - inicio);
    }
    
     private void cargarTabla(String filtro){
        modeloTabla.clearTableModelData();
        if(filtro == null){
           listaProductos = dao.listarTodosProductos();
        }else{
           listaProductos = dao.listarTodosProductos(filtro);
        }
        modeloTabla.addRows(listaProductos);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vInventario.btnNewProduct){
            NuevoProducto modal = new NuevoProducto(null, true);
            DAOProducto dao = DAOProductoImpl.getInstancia();
            ControladorNuevoProducto ctrNuevoProducto = new ControladorNuevoProducto(modal, dao);
            this.desabilitarBotonesTabla();
            producto = null;
            this.limpiarCampos();
            this.cargarTabla(null);
            
        }
        if(e.getSource() == vInventario.btnNewCategory){
            NuevaCategoria modal = new NuevaCategoria(null, true);
            DAOCategoria dao = DAOCategoriaImpl.getInstancia();
            ControladorNuevaCategoria ctrNuevCategoria = new ControladorNuevaCategoria(modal, dao);
            this.desabilitarBotonesTabla();
            producto = null;
            this.limpiarCampos();
            this.cargarTabla(null);
        }
        if(e.getSource() == vInventario.btnNewProvider){
            NuevoProveedor modal = new NuevoProveedor(null, true);
            DAOProveedor dao = DAOProveedorImpl.getInstancia();
            ControladorNuevoProveedor ctrNuevoProveedor = new ControladorNuevoProveedor(modal, dao);
            this.desabilitarBotonesTabla();
            producto = null;
            this.limpiarCampos();
            this.cargarTabla(null);
        }
        if(e.getSource() == vInventario.btnNexPage){
            paginaConsulta++;
            daoP.setPagina(this.paginaConsulta);
            this.cargarTabla(null);
            vInventario.txtNumberPage.setText(String.valueOf(this.paginaConsulta));
        }
        if(e.getSource() == vInventario.btnBackPage){
            paginaConsulta--;
            daoP.setPagina(this.paginaConsulta);
            this.cargarTabla(null);
            vInventario.txtNumberPage.setText(String.valueOf(this.paginaConsulta));
        }
        if(e.getSource() == vInventario.btnStarPage){
            paginaConsulta = 1;
            daoP.setPagina(this.paginaConsulta);
            this.cargarTabla(null);
            vInventario.txtNumberPage.setText(String.valueOf(this.paginaConsulta));
        }
        if(e.getSource() == vInventario.btnAddStock){
            short idProd;
            int stockActual = producto.getStock();
            int nuevoStock;
            producto.setStock(Short.parseShort(vInventario.txtAddStock.getText()));
            idProd = dao.actualizarProducto(producto);
            if( idProd >= 0 ){
                nuevoStock = stockActual + producto.getStock();
                MensajesPersonalizados.mostrarValidacionCorrecta("Stock actualizado a: " + nuevoStock, vInventario);
                this.limpiarCampos();
                producto = null;
                this.desabilitarBotonesTabla();
                this.cargarTabla(null);
            }else{
                MensajesPersonalizados.mostrarErrorValidacion("Stock", vInventario);
            }
        }
        if(e.getSource() == vInventario.btnDeleteProduct){
            int confirm = JOptionPane.showConfirmDialog(vInventario, "Esta seguro que desea eliminar el producto: " + producto.getNombre() + "\nAun cuenta con stock: " + producto.getStock(), "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if(JOptionPane.YES_OPTION == confirm){
                short idProducto;
                idProducto = dao.eliminarProducto(producto);
                if(idProducto > 0){
                    MensajesPersonalizados.mostrarValidacionCorrecta("Se elimino el producto con codigo: " + idProducto, vInventario);
                    this.limpiarCampos();
                    this.cargarTabla(null);
                    producto = null;
                    this.desabilitarBotonesTabla();
                }else{
                    MensajesPersonalizados.mostrarErrorValidacion("", vInventario);
                }
            }
        }
        
        if(e.getSource() == vInventario.btnUpdateProduct ){
            System.out.println(e.getActionCommand());
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
            paginaConsulta = 1;
            daoP.setPagina(paginaConsulta);
            String filtro = vInventario.txtSearchProduct.getText();
            this.cargarTabla(filtro);
            vInventario.txtNumberPage.setText(String.valueOf(paginaConsulta));
        }
    }
    
    
    private void limpiarCampos(){
        vInventario.txtCod.setText("");
        vInventario.txtName.setText("");
        vInventario.txtStock.setText("");
        vInventario.txtAddStock.setText("");
        vInventario.txtSearchProduct.setText("");
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == vInventario.tblListProducts){
            int row = vInventario.tblListProducts.getSelectedRow();
            producto = modeloTabla.getDomainObject(row);
            vInventario.txtCod.setText(String.valueOf(producto.getIdProducto()));
            vInventario.txtName.setText(producto.getNombre());
            vInventario.txtStock.setText(String.valueOf(producto.getStock()));
            this.habilitarBotonesTabla();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void modelarTabla(){
        columnasTabla = new Object[]{"Codigo","Nombre","Precio","Stock","Categoria"};
        modeloTabla = new GenericDomainTableModel<Producto>(Arrays.asList(columnasTabla)) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch(columnIndex){
                    case 0 : return Short.class;
                    case 1 : return String.class;
                    case 2 : return Float.class;
                    case 3 : return Short.class;
                    case 4 : return String.class;
                }
                throw new ArrayIndexOutOfBoundsException(columnIndex);
            }
            
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Producto producto = getDomainObject(rowIndex);
                switch(columnIndex){
                    case 0 : return producto.getIdProducto();
                    case 1 : return producto.getNombre();
                    case 2 : return producto.getPrecio();
                    case 3 : return producto.getStock();
                    case 4 : return producto.getCategoria();
                    default: throw new ArrayIndexOutOfBoundsException(columnIndex);
                }
            }
            
            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                Producto producto = getDomainObject(rowIndex);
                switch(columnIndex){
                    case 0 : producto.setIdProducto((Short)aValue);
                    break;
                    case 1 : producto.setNombre((String)aValue);
                    break;
                    case 2 : producto.setPrecio((Float)aValue);
                    break;
                    case 3 : producto.setStock((Short)aValue);
                    break;
                    case 4 : producto.setCategoria((String)aValue);
                    break;
                    default: throw new ArrayIndexOutOfBoundsException(columnIndex);
                }
                notifyTableCellUpdated(rowIndex, columnIndex);
            }
        };
        vInventario.tblListProducts.setModel(modeloTabla);
    }
    
    
    private void habilitarBotonesTabla(){
        vInventario.btnAddStock.setEnabled(true);
        vInventario.btnUpdateProduct.setEnabled(true);
        vInventario.btnDeleteProduct.setEnabled(true);
    }
    private void desabilitarBotonesTabla(){
        vInventario.btnAddStock.setEnabled(false);
        vInventario.btnUpdateProduct.setEnabled(false);
        vInventario.btnDeleteProduct.setEnabled(false);
    }

}
