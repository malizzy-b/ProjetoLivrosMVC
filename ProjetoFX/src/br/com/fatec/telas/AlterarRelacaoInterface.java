/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.telas;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class AlterarRelacaoInterface implements Initializable {

    @FXML
    private Button btSalvar;

    @FXML
    private Label lbUsuario;

    @FXML
    private ComboBox<Usuario> cbUsuario;

    private ObservableList<Usuario> observableListUsuario;

    @FXML
    private Label lbLivro;

    @FXML
    private ComboBox<Livros> cbLivro;

    private ObservableList<Livros> observableListLivros;

    @FXML
    private Label lbObservacao;

    @FXML
    private TextField txtObservacao;

    @FXML
    private Button btVoltar;

    ControllerUsuario usuCont = null;

    ControllerLivros livCont = null;

    ControllerUsuarioLivros usuLivCont = null;

    List<Usuario> listaUsuario = null;

    List<Livros> listaLivros = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
        try {
            carregarComboBoxUsuarios();
            carregarComboBoxLivros();
        } catch (SQLException ex) {
            Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initComponentes() {
        usuCont = new ControllerUsuario();
        livCont = new ControllerLivros();

        btSalvar.setOnAction((ActionEvent event) -> {
            usuLivCont = new ControllerUsuarioLivros();
            UsuarioLivros usuLiv = new UsuarioLivros(
                    cbUsuario.getSelectionModel().getSelectedItem().getId(),
                    cbLivro.getSelectionModel().getSelectedItem().getId(),
                    txtObservacao.getText());
            try {
                usuLivCont.alterar(usuLiv);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Usuário-Livro alterado com sucesso!");
        });

        btVoltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
                Parent novatela = null;
                try {
                    novatela = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(novatela));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void carregarComboBoxUsuarios() throws SQLException, ClassNotFoundException {
        Usuario usu = new Usuario("");
        List<Object> listaObj = usuCont.listar(usu);
        listaUsuario = new ArrayList<>();

        for (Object objlista : listaObj) {
            listaUsuario.add((Usuario) objlista);
        }

        observableListUsuario = FXCollections.observableArrayList(listaUsuario);

        cbUsuario.setItems(observableListUsuario);
    }

    public void carregarComboBoxLivros() throws SQLException, ClassNotFoundException {
        Livros liv = new Livros("");
        List<Object> listaObj = livCont.listar(liv);
        listaLivros = new ArrayList<>();

        for (Object objlista : listaObj) {
            listaLivros.add((Livros) objlista);
        }

        observableListLivros = FXCollections.observableArrayList(listaLivros);

        cbLivro.setItems(observableListLivros);
    }
}

