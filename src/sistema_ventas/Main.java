/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_ventas;

import com.OldSpace.gui.frame.Login;
import com.OldSpace.controlador.ControladorLogin;
import com.OldSpace.controlador.ControladorPrincipal;
import com.OldSpace.gui.frame.Principal;
import com.OldSpace.gui.internalFrame.Venta;
import com.OldSpace.modelos.dao.DAOUsuarioImpl;
import com.OldSpace.modelos.interfaces.DAOUsuario;
import javax.swing.UIManager;

/**
 *
 * @author YonattanVisita
 */
public class Main {
    public static void main(String[] args) {
          try {
		//UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
                //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    //new Demo().createAndShowGui();
            } catch (Exception e) {
                    e.printStackTrace();
            }  
      
        
//        DAOUsuario dao = DAOUsuarioImpl.getInstancia();
//        Login login = new Login();
//        ControladorLogin ctrLogin = new ControladorLogin(login, dao);
           
          Principal principal = new Principal();
          ControladorPrincipal ctrPrincipal = new ControladorPrincipal(principal);
    }
}
