/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.controlador;

import com.OldSpace.gui.frame.Login;
import com.OldSpace.excepciones.MensajesPersonalizados;
import com.OldSpace.gui.frame.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.OldSpace.modelos.interfaces.DAOUsuario;
import com.OldSpace.modelos.beans.Usuario;
import com.OldSpace.modelos.dao.DAOUsuarioImpl;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author YonattanVisita
 */
public class ControladorLogin extends MouseAdapter implements ActionListener{

    private Login vLogin;
    private DAOUsuario dao;
    private Usuario usuario;
    
    public ControladorLogin(Login vLogin, DAOUsuario dao){
        this.vLogin = vLogin;
        this.dao = dao;
        this.vLogin.btnIngresar.addActionListener(this);
        this.vLogin.btnCerrar.addActionListener(this);
        this.vLogin.btnCerrar.addMouseListener(this);
        this.inicializarLogin();
    }
    
    private void inicializarLogin(){
        vLogin.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vLogin.btnIngresar){
            usuario = new Usuario();
            String user = vLogin.txtUser.getText();
            String password = String.copyValueOf(vLogin.txtPassword.getPassword());
            usuario.setNombre(user);
            usuario.setClave(password);
            if(dao.autenticarUsuario(usuario) != null){
                MensajesPersonalizados.mostrarValidacionCorrecta("Bienvanido " + DAOUsuarioImpl.getSesion().getNombre(),vLogin);
                //vLogin.setVisible(false);
                Principal principal = new Principal();
                ControladorPrincipal ctrPrincipal = new ControladorPrincipal(principal);
                vLogin.dispose();
            }
        }
        if(e.getSource() == vLogin.btnCerrar){
            vLogin.dispose();
        }
    }
    
    @Override
    public void mouseEntered​(MouseEvent e){
        if(e.getSource() == vLogin.btnCerrar){
            vLogin.btnCerrar.setForeground(Color.WHITE);
        }
    }
    @Override
    public void mouseExited​(MouseEvent e){
        if(e.getSource() == vLogin.btnCerrar){
            vLogin.btnCerrar.setForeground(Color.BLACK);
        }
    }
}
