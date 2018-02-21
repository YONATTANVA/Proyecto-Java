/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_ventas;

import com.OldSpace.gui.frame.Login;
import com.OldSpace.controlador.ControladorLogin;
import com.OldSpace.modelos.dao.DAOUsuarioImpl;
import com.OldSpace.modelos.interfaces.DAOUsuario;

/**
 *
 * @author YonattanVisita
 */
public class Main {
    public static void main(String[] args) {
        DAOUsuario dao = DAOUsuarioImpl.getInstancia();
        Login login = new Login();
        ControladorLogin ctrLogin = new ControladorLogin(login, dao);
    }
}
