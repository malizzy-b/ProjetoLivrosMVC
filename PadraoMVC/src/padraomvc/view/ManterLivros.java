/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerLivros;
import padraomvc.model.bean.Livros;
import padraomvc.util.ViewBasico;

/**
 *
 * @author LAB 211
 */
public class ManterLivros implements ViewBasico {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - Buscar \n 4 - Excluir \n 5 - Listar ";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcao inválida");
                break;
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        String titulo = JOptionPane.showInputDialog("Título");
        String isbn = JOptionPane.showInputDialog("ISBN");
        String genero = JOptionPane.showInputDialog("Gênero");
        String data_lancamento = JOptionPane.showInputDialog("Data de Lançamento (AAAA-MM-DD)");
        String data_emprestimo = JOptionPane.showInputDialog("Data de Empréstimo (AAAA-MM-DD)");
        String data_devolucao = JOptionPane.showInputDialog("Data de Devolução (AAAA-MM-DD)");
        
        Livros livrosEnt = new Livros(titulo, isbn, genero, data_lancamento, data_emprestimo, data_devolucao);
        ControllerLivros contLivros = new ControllerLivros();
        Livros livrosSaida = (Livros) contLivros.inserir(livrosEnt);
        JOptionPane.showMessageDialog(null, livrosSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String titulo = JOptionPane.showInputDialog("Título");
        String isbn = JOptionPane.showInputDialog("ISBN");
        String genero = JOptionPane.showInputDialog("Gênero");
        String data_lancamento = JOptionPane.showInputDialog("Data de Lançamento (AAAA-MM-DD)");
        String data_emprestimo = JOptionPane.showInputDialog("Data de Empréstimo (AAAA-MM-DD)");
        String data_devolucao = JOptionPane.showInputDialog("Data de Devolução (AAAA-MM-DD)");
        
        Livros livrosEnt = new Livros(id, titulo, isbn, genero, data_lancamento, data_emprestimo, data_devolucao);
        ControllerLivros contLivros = new ControllerLivros();
        Livros livrosSaida = (Livros) contLivros.alterar(livrosEnt);
        JOptionPane.showMessageDialog(null, livrosSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Livros livrosEnt = new Livros(id);
        ControllerLivros contLivros = new ControllerLivros();
        Livros livrosSaida = (Livros) contLivros.buscar(livrosEnt);
        JOptionPane.showMessageDialog(null, livrosSaida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Livros livrosEnt = new Livros(id);
        ControllerLivros contLivros = new ControllerLivros();
        Livros livrosSaida = (Livros) contLivros.excluir(livrosEnt);
        JOptionPane.showMessageDialog(null, livrosSaida.toString());
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String titulo = JOptionPane.showInputDialog("Título");
        Livros livrosEnt = new Livros(titulo);
        ControllerLivros contLivros = new ControllerLivros();
        List<Object> listaLivros = contLivros.listar(livrosEnt);
        for (Object obj : listaLivros) {
            Livros livros = (Livros) obj;
            JOptionPane.showMessageDialog(null, livros.toString());
        }
    }

}
