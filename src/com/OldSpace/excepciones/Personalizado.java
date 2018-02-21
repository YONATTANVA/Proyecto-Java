/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.excepciones;

import javax.swing.JOptionPane;

/**
 *
 * @author YonattanVisita
 */
public class Personalizado {
    
    public Personalizado(){
        
    }
    
    public static void mostrarError(String _mensaje){
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Se lanzo la siguien excepcion: ");
        mensaje.append(_mensaje);
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
}
