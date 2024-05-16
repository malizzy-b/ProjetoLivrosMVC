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
import projetofx.ProjetoFX;
import padraomvc.controller.ControllerUsuarioLivros;
import padraomvc.model.bean.UsuarioLivros;
/**
 *
 * @author Marina
 */
public class ConsultarRelacaoInterface implements Initializable {

    @FXML
    private Label lbRelacao;

    @FXML
    private TextField txtRelacao;

    @FXML
    private TableView<UsuarioLivros> listaRelacao;

    @FXML
    private TableColumn<UsuarioLivros,String> tid;

    @FXML
    private TableColumn<UsuarioLivros,String> tidU;
    
    @FXML
    private TableColumn<UsuarioLivros,String> tidL;
    
    @FXML
    private TableColumn<UsuarioLivros,String> tObs;

    @FXML
    private Button btAlterar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btVoltar;
    
    @FXML
    private Button btConsultar;

    ControllerUsuarioLivros usuarioLivrosCont = null;
    
    ObservableList<UsuarioLivros> oList = null;

    List<UsuarioLivros> lista = null;
    
    public static UsuarioLivros relacaoSaidaTela;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }       
    
    private void initComponentes (){

        usuarioLivrosCont = new ControllerUsuarioLivros();

        btConsultar.setOnAction((ActionEvent event) -> {
            UsuarioLivros usuarioLivros = new UsuarioLivros(txtRelacao.getText());
            try {
                montaLista(usuarioLivros);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ConsultarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = Na Lista");
            }
        });

        btAlterar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TablePosition pos = listaRelacao.getSelectionModel().getSelectedCells().get(0);
                int row = pos.getRow();
                setRelacao(listaRelacao.getItems().get(row));
                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/AlterarRelacaoInterface.fxml"));
                Parent novatela = null;
                try {
                    novatela = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(novatela));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(ConsultarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btExcluir.setOnAction((ActionEvent event) -> {
            TablePosition pos = listaRelacao.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            UsuarioLivros usuarioLivros = listaRelacao.getItems().get(row);
            try {
                usuarioLivrosCont.excluir(usuarioLivros);
                listaRelacao.getItems().remove(row);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ConsultarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = No Excluir");

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
                    Logger.getLogger(ConsultarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
    
    public void montaLista(UsuarioLivros relacao) throws SQLException, ClassNotFoundException {
        List<Object> listaObj = usuarioLivrosCont.listar(relacao);
        lista = new ArrayList<>();

        for (Object objLista : listaObj) {
            lista.add((UsuarioLivros) objLista);
        }

        oList = FXCollections.observableArrayList(lista);
        tid.setCellValueFactory(new PropertyValueFactory<UsuarioLivros,String>("id"));
        tidU.setCellValueFactory(new PropertyValueFactory<UsuarioLivros,String>("idU"));
        tidL.setCellValueFactory(new PropertyValueFactory<UsuarioLivros,String>("idL"));
        tObs.setCellValueFactory(new PropertyValueFactory<UsuarioLivros,String>("obs"));
        listaRelacao.setItems(oList);
    }
    
    

    public void setRelacao(UsuarioLivros relacao) {
        System.out.println("Relacao: " + relacao);
        this.relacaoSaidaTela = relacao;
    }
    
    public UsuarioLivros getRelacao() {
        return this.relacaoSaidaTela;
    }


}

