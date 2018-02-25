/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.excepciones;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author YonattanVisita
 */
public class MensajesPersonalizados {
    
    private static StringBuilder cadena = null;
    
    public MensajesPersonalizados(){
        
    }
    
    public static void mostrarErrorException(String mensaje){
        cadena = new StringBuilder();
        cadena.append("Se lanzo la siguien excepcion: ");
        cadena.append(mensaje);
        JOptionPane.showMessageDialog(null, cadena);
    }
    
    public static void mostrarErrorValidacion(String mensaje, Component ventana){
        cadena = new StringBuilder();
        cadena.append("Datos invalidos: ");
        cadena.append(mensaje);
        JOptionPane.showMessageDialog(ventana, cadena,"Error",JOptionPane.ERROR_MESSAGE);
    }
    public static void mostrarValidacionCorrecta(String mensaje, Component ventana){
        
        JOptionPane.showMessageDialog(ventana, mensaje,"Correcto",JOptionPane.PLAIN_MESSAGE);
        
    }
}
