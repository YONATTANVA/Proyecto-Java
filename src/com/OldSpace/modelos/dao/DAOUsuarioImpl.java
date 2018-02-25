/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OldSpace.modelos.dao;

import com.OldSpace.excepciones.MensajesPersonalizados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.OldSpace.modelos.interfaces.DAOUsuario;
import com.OldSpace.modelos.beans.Usuario;

/**
 *
 * @author YonattanVisita
 */
public final class DAOUsuarioImpl extends DAO implements DAOUsuario{
    private final String VALIDACION_LOGIN = "SELECT id_usuario,nombre,perfil FROM autenticar(?,?)";
    
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    private final static DAOUsuarioImpl INSTANCIA = new DAOUsuarioImpl();
    
    private Usuario usuario = null;
    
    
    private DAOUsuarioImpl(){
        
    }
    
    public static DAOUsuarioImpl getInstancia(){
        return INSTANCIA;
    }
    
    
    @Override
    public Usuario autenticarUsuario(Usuario usuario) {
        try {
            ps = conectar().prepareStatement(VALIDACION_LOGIN);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getClave());
            rs = ps.executeQuery();
            if(rs.next()){
                this.usuario = this.convertir(rs);
            }
        } catch (SQLException ex) {
            MensajesPersonalizados.mostrarErrorException(ex.toString());
        }
        return this.usuario;
    }

    private Usuario convertir(ResultSet rs) {
        try {
            usuario = new Usuario();
            usuario.setIdPsuario(rs.getShort("id_usuario"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setPerfil(rs.getString("perfil"));
        } catch (SQLException ex) {
            MensajesPersonalizados.mostrarErrorException(ex.toString());
        }
        return usuario;
    }
    
}
