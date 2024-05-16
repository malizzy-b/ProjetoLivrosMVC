/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.telas;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerLivros;
import padraomvc.model.bean.Livros;
import projetofx.ProjetoFX;
/**
 *
 * @author Marina
 */
public class InserirLivrosInterface implements Initializable {

    @FXML
    private Button btSalvar;

    @FXML
    private Button btVoltar;

    @FXML
    private Label lbTitulo;

    @FXML
    private Label lbISBN;

    @FXML
    private Label lbGenero;

    @FXML
    private Label lbDataLancamento;

    @FXML
    private Label lbDataEmprestimo;

    @FXML
    private Label lbDataDevolucao;

    @FXML
    private TextField txtTitulo;

    @FXML
    private TextField txtISBN;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtDataLancamento;

    @FXML
    private TextField txtDataEmprestimo;

    @FXML
    private TextField txtDataDevolucao;

    ControllerLivros livrosCont = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }

    private void initComponentes() {
        btSalvar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                livrosCont = new ControllerLivros();
                String dataLancamento = txtDataLancamento.getText();
                String dataEmprestimo = txtDataEmprestimo.getText();
                String dataDevolucao = txtDataDevolucao.getText();

                Livros livro = new Livros(txtTitulo.getText(), txtISBN.getText(), txtGenero.getText(), dataLancamento, dataEmprestimo, dataDevolucao);
                try {
                    livro = (Livros) livrosCont.inserir(livro);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(InserirLivrosInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Livro inserido: " + livro.getTitulo());
            }
        });

        btVoltar.setOnAction((ActionEvent event) -> {
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
            Parent novatela = null;
            try {
                novatela = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(novatela));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(InserirLivrosInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}