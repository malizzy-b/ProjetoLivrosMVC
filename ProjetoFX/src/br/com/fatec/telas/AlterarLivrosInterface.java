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
public class AlterarLivrosInterface implements Initializable {
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
    private Label lbId;

    @FXML
    private Label lbIdT;

    @FXML
    private TextField txtGenero;
    
    @FXML
    private TextField txtDataLancamento;

    @FXML
    private TextField txtISBN;

    @FXML
    private TextField txtTitulo;

    ControllerLivros livrosCont = null;
    
    Livros livro = null;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         initComponentes(); 
    }    

    private void initComponentes (){

        livrosCont = new ControllerLivros();
        ConsultarLivrosInterface telaAnterior = new ConsultarLivrosInterface();
        setLivro(telaAnterior.getLivro());

        btVoltar.setOnAction((ActionEvent event) -> {
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
            Parent novatela = null;
            try {
                novatela = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(novatela));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(AlterarLivrosInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        btSalvar.setOnAction((ActionEvent event) -> {
            livro = new Livros(Integer.parseInt(lbIdT.getText()),
                              txtTitulo.getText(),
                              txtISBN.getText(),
                              txtGenero.getText(),
                              txtDataLancamento.getText(),
                              null, // Como a data de empréstimo e devolução não foi alterada, não há necessidade de pegar esses valores aqui
                              null);

            try {
                livrosCont.alterar(livro);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(AlterarLivrosInterface.class.getName()).log(Level.SEVERE, null, ex);
            } 
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
            Parent novatela = null;
            try {
                novatela = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(novatela));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(AlterarLivrosInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
    
    public void setLivro(Livros livro) {
        JOptionPane.showMessageDialog(null, livro.getTitulo());
        this.lbIdT.setText(String.valueOf(livro.getId()));
        this.txtTitulo.setText(livro.getTitulo());
        this.txtISBN.setText(livro.getIsbn());
        this.txtGenero.setText(livro.getGenero());
        this.txtDataLancamento.setText(livro.getData_lancamento());
    }
}