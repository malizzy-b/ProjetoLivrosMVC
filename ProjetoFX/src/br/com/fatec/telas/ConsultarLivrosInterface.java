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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerLivros;
import padraomvc.model.bean.Livros;
import projetofx.ProjetoFX;

/**
 *
 * @author Marina
 */
public class ConsultarLivrosInterface implements Initializable {

    @FXML
    private Button btAlterar;

    @FXML
    private Button btConsultar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btVoltar;

    @FXML
    private Label lbTitulo;

    @FXML
    private TableView<Livros> listaLivros;

    @FXML
    private TableColumn<Livros, String> tDataLancamento;

    @FXML
    private TableColumn<Livros, String> tGenero;

    @FXML
    private TableColumn<Livros, String> tISBN;

    @FXML
    private TableColumn<Livros, String> tTitulo;

    @FXML
    private TextField txtTitulo;

    ControllerLivros livroCont = null;

    ObservableList<Livros> oList = null;

    List<Livros> lista = null;

    public static Livros livroSaidaTela = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }       

    private void initComponentes() {

        livroCont = new ControllerLivros();

        btConsultar.setOnAction((ActionEvent event) -> {
            Livros livro = new Livros(txtTitulo.getText());
            try {
                montaLista(livro);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ConsultarLivrosInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro na lista");
            }
        });

        btAlterar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TablePosition pos = listaLivros.getSelectionModel().getSelectedCells().get(0);
                int row = pos.getRow();
                setLivro(listaLivros.getItems().get(row));
                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/AlterarLivrosInterface.fxml"));
                Parent novatela = null;
                try {
                    novatela = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(novatela));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(ConsultarLivrosInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btExcluir.setOnAction((ActionEvent event) -> {
            TablePosition pos = listaLivros.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            Livros livro = listaLivros.getItems().get(row);
            try {
                livroCont.excluir(livro);
                listaLivros.getItems().remove(row);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ConsultarLivrosInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao excluir");
            }
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
                    Logger.getLogger(ConsultarLivrosInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public void montaLista(Livros livro) throws SQLException, ClassNotFoundException {
        List<Object> listaObj = livroCont.listar(livro);
        lista = new ArrayList<>();

        for (Object objLista : listaObj) {
            lista.add((Livros) objLista);
        }

        oList = FXCollections.observableArrayList(lista);
        tTitulo.setCellValueFactory(new PropertyValueFactory<Livros,String>("titulo"));
        tISBN.setCellValueFactory(new PropertyValueFactory<Livros,String>("isbn"));
        tGenero.setCellValueFactory(new PropertyValueFactory<Livros,String>("genero"));
        tDataLancamento.setCellValueFactory(new PropertyValueFactory<Livros,String>("data_lancamento"));
        listaLivros.setItems(oList);
    }

    public void setLivro(Livros livroL) {
        this.livroSaidaTela = livroL;
    }

    public Livros getLivro() {
        return this.livroSaidaTela;
    }
}

