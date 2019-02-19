/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import LibraryScreens.ConsultarPessoas;
import LibraryScreens.GerPessoas;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import Pessoa.Pessoa;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.omg.CORBA.INITIALIZE;

/**
 * FXML Controller class
 *
 * @author death
 */
public class ConsultarPessoasController implements Initializable {

    @FXML
    private TableView<Pessoa> table;
    
    @FXML
    private TableColumn<Pessoa, Integer> codinscTb;
    
    @FXML
    private TableColumn<Pessoa, String> nomeTb;
    
    @FXML
    private TableColumn<Pessoa, String> emailTb;
    
    @FXML
    private TableColumn<Pessoa, String> enderecoTb;
    
    @FXML
    private TableColumn<Pessoa, String> bairroTb;
    
    @FXML
    private TableColumn<Pessoa, String> cidadeTb;
    
    @FXML
    private TableColumn<Pessoa, String> cepTb;
    
    @FXML
    private TableColumn<Pessoa, String> turnoTb;
    
    @FXML
    private TableColumn<Pessoa, String> turmaTb;
    
    @FXML
    private TableColumn<Pessoa, String> serieTb;

    @FXML
    private Button backBtn;
    
    @FXML
    private Button pesquisarBtn;
    
    @FXML
    private TextField nomeTxt;
            
    @FXML
    private TextField codInscTxt;
            
    @FXML
    private TextField emailTxt;

    /**
     * Método responssável por cancelar a ação atual e retornar para a tela
     * antetior
     *
     * @param event
     */
    @FXML
    void backBtnAction(ActionEvent event) {
        GerPessoas g = new GerPessoas();
        try {
            g.start(new Stage());
            fecha();
        } catch (Exception ex) {
            Logger.getLogger(ConsultarPessoasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void pesquisarBtnAction(ActionEvent event){
        Pessoa p = new Pessoa();
        if(!(codInscTxt.getText().trim().equals(""))) p.setCodinsc(Integer.parseInt(codInscTxt.getText()));
        if(!(nomeTxt.getText().trim().equals("")))  p.setNome(nomeTxt.getText());
        if(!(emailTxt.getText().trim().equals(""))) p.setEmail(emailTxt.getText());
        table.setItems(listaDePessoas(p.filtrarPessoa()));
        
        
    }
    
    @FXML
    void limparBtnAction(ActionEvent event){
        table.setItems(null);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        codinscTb.setCellValueFactory(
            new PropertyValueFactory<>("codinsc"));
        bairroTb.setCellValueFactory(
            new PropertyValueFactory<>("bairro"));
        cepTb.setCellValueFactory(
            new PropertyValueFactory<>("cep"));
        cidadeTb.setCellValueFactory(
            new PropertyValueFactory<>("cidade"));
        emailTb.setCellValueFactory(
            new PropertyValueFactory<>("email"));
        enderecoTb.setCellValueFactory(
            new PropertyValueFactory<>("endereco"));
        nomeTb.setCellValueFactory(
            new PropertyValueFactory<>("nome"));
        serieTb.setCellValueFactory(
            new PropertyValueFactory<>("codinsc"));
        turmaTb.setCellValueFactory(
            new PropertyValueFactory<>("turma"));
        turnoTb.setCellValueFactory(
            new PropertyValueFactory<>("turno"));
        table.setItems(listaDePessoas(Pessoa.ListaDePessoa()));
    }
    
    private ObservableList<Pessoa> listaDePessoas(List<Pessoa> list){
        return FXCollections.observableArrayList(list);
    }

    /**
     * Método responsável por fechar a tela atual
     */
    public void fecha() {
        ConsultarPessoas.getStage().close();
    }

}
