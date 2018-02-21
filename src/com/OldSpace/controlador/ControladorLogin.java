/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.controlador;

import com.OldSpace.gui.frame.Login;
import com.OldSpace.excepciones.Personalizado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.OldSpace.modelos.interfaces.DAOUsuario;
import com.OldSpace.modelos.pojos.Usuario;

/**
 *
 * @author YonattanVisita
 */
public class ControladorLogin implements ActionListener{

    private Login vLogin = null;
    private DAOUsuario dao = null;
    
    public ControladorLogin(Login _vLogin, DAOUsuario _dao){
        this.vLogin = _vLogin;
        this.dao = _dao;
        this.vLogin.btnIngresar.addActionListener(this);
        this.inicializarLogin();
    }
    
    public void inicializarLogin(){
        this.vLogin.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Usuario usuario = null;
        String user = this.vLogin.txtUser.getText();
        String password = String.copyValueOf(this.vLogin.txtPassword.getPassword());
        usuario = this.dao.autenticar(user, password);
        if(usuario != null){
            Personalizado.mostrarError("Se logeo con exito");
            this.vLogin.setVisible(false);
            
        }
    }
    
}
