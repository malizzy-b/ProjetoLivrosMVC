/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.view;

import padraomvc.controller.ControllerUsuarioLivros;
import padraomvc.model.bean.UsuarioLivros;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import padraomvc.util.ViewBasico;

/**
 *
 * @author User
 */
public class ManterUsuarioLivros implements ViewBasico{
    
    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1 : 
                inserir();
                break;
            case 2 : 
                alterar();
                break;
            case 3 : 
                buscar();
                break;
            case 4 : 
                excluir();
                break;
            case 5 : 
                listar();
                break;
            default : 
                System.out.println("Opcao inválida");
                break;
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        int idU = Integer.parseInt(JOptionPane.showInputDialog("IDU"));
        int idL = Integer.parseInt(JOptionPane.showInputDialog("IDL"));
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioLivros usuEnt = new UsuarioLivros(idU, idL, obs);
        ControllerUsuarioLivros contUsu = new ControllerUsuarioLivros();
        UsuarioLivros usuSaida = (UsuarioLivros) contUsu.inserir(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idU = Integer.parseInt(JOptionPane.showInputDialog("IDU"));
        int idL = Integer.parseInt(JOptionPane.showInputDialog("IDL"));
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioLivros usuEnt = new UsuarioLivros(id,idU, idL, obs);
        ControllerUsuarioLivros contUsu = new ControllerUsuarioLivros();
        UsuarioLivros usuSaida = (UsuarioLivros) contUsu.alterar(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuarioLivros usuEnt = new UsuarioLivros(id);
        ControllerUsuarioLivros contUsu = new ControllerUsuarioLivros();
        UsuarioLivros usuSaida = (UsuarioLivros) contUsu.buscar(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuarioLivros usuEnt = new UsuarioLivros(id);
        ControllerUsuarioLivros contUsu = new ControllerUsuarioLivros();
        UsuarioLivros usuSaida = (UsuarioLivros) contUsu.excluir(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
    }

   @Override
     public void listar() throws SQLException, ClassNotFoundException {
         String id = JOptionPane.showInputDialog("Id");
         UsuarioLivros usuEnt = new UsuarioLivros(id);
         ControllerUsuarioLivros contUsu = new ControllerUsuarioLivros();
         List<Object> listaUsuario = contUsu.listar(usuEnt);
         for (Object usuObj : listaUsuario) {
             UsuarioLivros usuSaida = (UsuarioLivros) usuObj;
             JOptionPane.showMessageDialog(null,usuSaida.toString());
             JOptionPane.showMessageDialog(null,usuSaida.getUsu().toString());
             JOptionPane.showMessageDialog(null,usuSaida.getLiv().toString());
         }
     }

}
