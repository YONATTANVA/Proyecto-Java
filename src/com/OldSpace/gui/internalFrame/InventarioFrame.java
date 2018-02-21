/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.gui.internalFrame;

import com.OldSpace.gui.dialog.ArticuloDialog;
import com.OldSpace.gui.dialog.CategoriaDialog;
import com.OldSpace.gui.dialog.ProveedorDialog;
import javax.swing.JDialog;
import logicaGUI.Inventario;

/**
 *
 * @author YonattanVisita
 */
public class InventarioFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form InventarioFrame
     */
    

    
    public InventarioFrame() {
        initComponents();
        Inventario.generarColumnasTabla();
        Inventario.cargarTabla("");
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNewArticle = new javax.swing.JButton();
        btnNewCategory = new javax.swing.JButton();
        btnNewProvider = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdInve = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNameInve = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtStockInve = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListInve = new javax.swing.JTable();
        lblImage = new javax.swing.JLabel();
        btnUpdateArticle = new javax.swing.JButton();
        btnDeleteArticle = new javax.swing.JButton();
        btnAddStock = new javax.swing.JButton();
        txtNewStock = new javax.swing.JTextField();
        txtSearchArticle = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnNexPage = new javax.swing.JButton();
        btnStarPage = new javax.swing.JButton();
        txtNumberPage = new javax.swing.JTextField();
        btnBackPage = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setTitle("Invetario");
        setMaximumSize(new java.awt.Dimension(1400, 600));

        btnNewArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewArticleActionPerformed(evt);
            }
        });

        btnNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCategoryActionPerformed(evt);
            }
        });

        btnNewProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProviderActionPerformed(evt);
            }
        });

        jLabel1.setText("Inventario ");

        jLabel2.setText("Id");

        jLabel3.setText("Nombre");

        jLabel4.setText("Existencia");

        tblListInve.setModel(Inventario.getModeloTabla());
        tblListInve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListInveMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListInve);

        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
        });

        btnUpdateArticle.setText("Modificar Articulo");

        btnDeleteArticle.setText("Eliminar Articulo");

        btnAddStock.setText("Agregar");
        btnAddStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStockActionPerformed(evt);
            }
        });

        txtSearchArticle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchArticleKeyReleased(evt);
            }
        });

        jLabel5.setText("Ingresar al inventario");

        jLabel6.setText("Buscar");

        btnNexPage.setText(">");
        btnNexPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNexPageActionPerformed(evt);
            }
        });

        btnStarPage.setText("|<");

        btnBackPage.setText("<");
        btnBackPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackPageActionPerformed(evt);
            }
        });

        jLabel7.setText("Pagina :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumberPage, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStarPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBackPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNexPage))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnNewArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnNewCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnNewProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtSearchArticle, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel1)
                                        .addComponent(txtIdInve, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtStockInve, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(31, 31, 31)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3)
                                        .addComponent(txtNameInve, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                        .addComponent(txtNewStock)
                                        .addComponent(jLabel5))))
                            .addGap(18, 18, 18)
                            .addComponent(btnAddStock, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdateArticle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteArticle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewArticle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdInve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNameInve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtStockInve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNewStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddStock)))
                            .addComponent(jLabel5)))
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(txtSearchArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUpdateArticle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteArticle)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumberPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNexPage)
                        .addComponent(btnBackPage)
                        .addComponent(btnStarPage)
                        .addComponent(jLabel7)))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewArticleActionPerformed
        ArticuloDialog modal = new ArticuloDialog(null, true);
        modal.setVisible(true);
        modal.setAlwaysOnTop(true);
        modal.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        modal.setLocation(300, 300);
    }//GEN-LAST:event_btnNewArticleActionPerformed

    private void btnNewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCategoryActionPerformed
        CategoriaDialog modal = new CategoriaDialog(null, true);
        modal.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        modal.setAlwaysOnTop(true);
        modal.setVisible(true);
        modal.setLocation(300,300);
    }//GEN-LAST:event_btnNewCategoryActionPerformed

    private void btnNewProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProviderActionPerformed
        ProveedorDialog modal = new ProveedorDialog(null, true);
        modal.setAlwaysOnTop(true);
        modal.setVisible(true);
        modal.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        modal.setLocation(300, 300);
    }//GEN-LAST:event_btnNewProviderActionPerformed

    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_lblImageMouseClicked

    private void tblListInveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListInveMouseClicked
        
        int fila = tblListInve.getSelectedRow();
        //JOptionPane.showMessageDialog(this, modeloTabla.getValueAt(fila, 0));
        
        
    }//GEN-LAST:event_tblListInveMouseClicked

    private void btnAddStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStockActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(txtIdInve.getText());
        int stockActual = Integer.parseInt(txtStockInve.getText());
        int nuevoStock = Integer.parseInt(txtNewStock.getText());
        int stockTotal = stockActual + nuevoStock;
    }//GEN-LAST:event_btnAddStockActionPerformed

    private void txtSearchArticleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchArticleKeyReleased
        // TODO add your handling code here:
        Inventario.cargarTabla(txtSearchArticle.getText());
    }//GEN-LAST:event_txtSearchArticleKeyReleased

    private void btnNexPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNexPageActionPerformed
        Inventario.siguientePaginaConsulta();
    }//GEN-LAST:event_btnNexPageActionPerformed

    private void btnBackPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackPageActionPerformed
       Inventario.anteriorPaginaConsulta();
    }//GEN-LAST:event_btnBackPageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddStock;
    private javax.swing.JButton btnBackPage;
    private javax.swing.JButton btnDeleteArticle;
    private javax.swing.JButton btnNewArticle;
    private javax.swing.JButton btnNewCategory;
    private javax.swing.JButton btnNewProvider;
    private javax.swing.JButton btnNexPage;
    private javax.swing.JButton btnStarPage;
    private javax.swing.JButton btnUpdateArticle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTable tblListInve;
    private javax.swing.JTextField txtIdInve;
    private javax.swing.JTextField txtNameInve;
    private javax.swing.JTextField txtNewStock;
    private javax.swing.JTextField txtNumberPage;
    private javax.swing.JTextField txtSearchArticle;
    private javax.swing.JTextField txtStockInve;
    // End of variables declaration//GEN-END:variables
}