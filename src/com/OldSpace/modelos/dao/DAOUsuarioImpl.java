/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.dao;

import com.OldSpace.excepciones.Personalizado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.OldSpace.modelos.interfaces.DAOUsuario;
import com.OldSpace.modelos.pojos.Usuario;

/**
 *
 * @author YonattanVisita
 */
public class DAOUsuarioImpl extends DAO implements DAOUsuario{
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private static DAOUsuarioImpl instancia = null;
    
    private final String VALIDACION_LOGIN = "SELECT id_usuario,nombre,perfil FROM autenticar(?,?)";
    
    private DAOUsuarioImpl(){
        
    }
    
    public static DAOUsuarioImpl getInstancia(){
        if(instancia == null){
            instancia = new DAOUsuarioImpl();
        }
        return instancia;
    }
    
    
    @Override
    public Usuario autenticar(String _usuario, String _password) {
        Usuario usuario = null;
        try {
            ps = conectar().prepareStatement(VALIDACION_LOGIN);
            ps.setString(1, _usuario);
            ps.setString(2, _password);
            rs = ps.executeQuery();
            if(rs.next()){
                usuario = convertir(rs);
            }
        } catch (SQLException ex) {
            Personalizado.mostrarError(ex.toString());
        }
        return usuario;
    }

    private Usuario convertir(ResultSet rs) {
        Usuario usuario = null;
        try {
            usuario = new Usuario();
            usuario.setIdPsuario(rs.getShort("id_usuario"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setPerfil(rs.getString("perfil"));
        } catch (SQLException ex) {
            Personalizado.mostrarError(ex.toString());
        }
        return usuario;
    }
    
}
