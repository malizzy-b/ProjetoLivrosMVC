/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.telas;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerLivros;
import padraomvc.controller.ControllerUsuario;
import padraomvc.controller.ControllerUsuarioLivros;
import padraomvc.model.bean.Livros;
import padraomvc.model.bean.Usuario;
import padraomvc.model.bean.UsuarioLivros;
import projetofx.ProjetoFX;

/**
 *
 * @author Marina
 */
public class InserirRelacaoInterface implements Initializable {
    @FXML
    private Button btSalvar;

    @FXML
    private Button btVoltar;

    @FXML
    private ComboBox<Livros> comboBoxLivro;

    @FXML
    private ComboBox<Usuario> comboBoxUsuario;

    @FXML
    private Label labelUsuario;

    @FXML
    private Label labelRelacao;

    @FXML
    private Label labelLivro;

    @FXML
    private TextField txtRelacao;

    private final ControllerUsuario controllerUsuario = new ControllerUsuario();
    private final ControllerLivros controllerLivro = new ControllerLivros();
    private final ControllerUsuarioLivros controllerUsuarioLivros = new ControllerUsuarioLivros();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            List<Object> listaUsuarios = controllerUsuario.listar(new Usuario(""));
            ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
            for (Object obj : listaUsuarios) {
                Usuario usuario = (Usuario) obj;
                usuarios.add(usuario);
            }
            comboBoxUsuario.setItems(usuarios);

            List<Object> listaLivros = controllerLivro.listar(new Livros(""));
            ObservableList<Livros> livros = FXCollections.observableArrayList();
            for (Object obj : listaLivros) {
                Livros livro = (Livros) obj;
                livros.add(livro);
            }
            comboBoxLivro.setItems(livros);
        } catch (Exception e) {
            e.printStackTrace();
            // Lida com possíveis erros ao carregar a lista de usuários e livros
        }

        btVoltar.setOnAction((ActionEvent event) -> {
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
            Parent novatela = null;
            try {
                novatela = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(novatela));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(InserirRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void salvarRelacao() {
        Livros livroSelecionado = comboBoxLivro.getValue();
        Usuario usuarioSelecionado = comboBoxUsuario.getValue();
        String relacao = txtRelacao.getText();

        if (livroSelecionado == null || usuarioSelecionado == null || relacao.isEmpty()) {
            System.out.println("Por favor, preencha todos os campos.");
            return;
        }

        // Cria um objeto UsuarioLivros com os dados selecionados
        UsuarioLivros usuarioLivros = new UsuarioLivros(usuarioSelecionado.getId(), livroSelecionado.getId(), relacao);
        try {
            usuarioLivros = (UsuarioLivros) controllerUsuarioLivros.inserir(usuarioLivros);
        } catch (SQLException ex) {
            Logger.getLogger(InserirRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InserirRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Relação entre usuário e livro inserida com sucesso.");
    }
    
    // Classe para converter o título do livro em String e vice-versa
    private static class TituloLivroConverter extends javafx.util.StringConverter<Livros> {
        @Override
        public String toString(Livros livro) {
            return livro.getTitulo(); // Retorna o título do livro
        }

        @Override
        public Livros fromString(String titulo) {
            return null; // Não é necessário implementar
        }
    }

    // Classe para converter o nome do usuário em String e vice-versa
    private static class NomeUsuarioConverter extends javafx.util.StringConverter<Usuario> {
        @Override
        public String toString(Usuario usuario) {
            return usuario.getLogin(); // Retorna o nome do usuário
        }

        @Override
        public Usuario fromString(String nome) {
            return null; // Não é necessário implementar
        }
    }
}
    



