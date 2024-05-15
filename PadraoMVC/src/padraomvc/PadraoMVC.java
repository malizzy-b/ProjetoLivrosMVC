/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package padraomvc;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import padraomvc.view.ManterLivros;
import padraomvc.view.ManterUsuario;
import padraomvc.view.ManterUsuarioLivros;

/**
 *
 * @author LAB 211
 */
public class PadraoMVC {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if(ManterUsuario.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Inválido");            
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 0 - Sair \n 1 - Usuario \n 2 - Sistema \n 3 - UsuarioSistema";

        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 0 : 
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
                if (sair > 0) menu();
                break;
            case 1 : 
                ManterUsuario mu = new ManterUsuario();
                mu.menu();
                break;
            case 2 : 
                ManterLivros ms = new ManterLivros();
                ms.menu();
                break;
            case 3 : 
                ManterUsuarioLivros mus = new ManterUsuarioLivros();
                mus.menu();
                break;
            default : 
                System.out.println("Opção inválido");
                break;
        }
    }
    
}
