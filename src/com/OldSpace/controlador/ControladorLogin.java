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

/**
 *
 * @author YonattanVisita
 */
public class ControladorLogin implements ActionListener{

    private Login vLogin;
    private DAOUsuario dao;
    private Usuario usuario;
    private Usuario sesion = null;
    
    public ControladorLogin(Login vLogin, DAOUsuario dao){
        this.vLogin = vLogin;
        this.dao = dao;
        this.vLogin.btnIngresar.addActionListener(this);
        this.inicializarLogin();
    }
    
    private void inicializarLogin(){
        vLogin.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        usuario = new Usuario();
        String user = vLogin.txtUser.getText();
        String password = String.copyValueOf(vLogin.txtPassword.getPassword());
        usuario.setNombre(user);
        usuario.setClave(password);
        
        sesion = dao.autenticarUsuario(usuario);
        if(sesion != null){
            MensajesPersonalizados.mostrarValidacionCorrecta("Se logeo con exito",vLogin);
            vLogin.setVisible(false);
            Principal principal = new Principal();
            ControladorPrincipal ctrPrincipal = new ControladorPrincipal(principal);
        }
    }
    
}
