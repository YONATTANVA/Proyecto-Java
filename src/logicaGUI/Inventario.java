/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaGUI;

import com.OldSpace.modelos.dao.DAOProductoImpl;
import com.OldSpace.modelos.interfaces.DAOProducto;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.OldSpace.modelos.pojos.Producto;

/**
 *
 * @author YonattanVisita
 */
public class Inventario {
    
    static DefaultTableModel modeloTabla = new DefaultTableModel();
    

    public static DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
    
    public static void generarColumnasTabla(){
        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Stock");
        modeloTabla.addColumn("Categoria");
    }
    
    public static void cargarTabla(String _filtro){
        limpiarTabla();
        DAOProducto dao = DAOProductoImpl.getInstancia();
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
    
    public static void limpiarTabla(){
        int cantidadItems = modeloTabla.getRowCount();
        //System.out.println(cantidadItems);
        for(int i = cantidadItems - 1; i >= 0 ; i--){
            modeloTabla.removeRow(i);
        }
    }
    
    public static void siguientePaginaConsulta(){
        short pagina;
        limpiarTabla();
        DAOProductoImpl dao = DAOProductoImpl.getInstancia();
        pagina = dao.getPagina();
        dao.setPagina(++pagina);
        cargarTabla("");
    }
    public static void anteriorPaginaConsulta(){
        short pagina;
        limpiarTabla();
        DAOProductoImpl dao = DAOProductoImpl.getInstancia();
        pagina = dao.getPagina();
        dao.setPagina(--pagina);
        cargarTabla("");
    }
    
    
}
