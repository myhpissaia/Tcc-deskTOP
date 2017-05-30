/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author <Leticia e Mylena >
 */
/*public class TelaTabelaDoacaoController implements Initializable {
    
    @FXML 
    private Button btVoltar;
    
    @FXML 
    private TableView<Doacao> tabela;
    
    @FXML 
    private TableColumn<Doacao, String> clnNome;
    
    @FXML 
    private TableColumn<Doacao, String> clnSobrenome;
    
    @FXML 
    private TableColumn<Doacao, String> clnEmail;
    
    @FXML 
    private TableColumn<Doacao, String> clnDoacao;
    
    private static Doacao selecionada;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        clnNome.setCellValueFactory(new PropertyValueFactory("nome"));
        clnSobrenome.setCellValueFactory(new PropertyValueFactory("sobrenome"));
        clnDoacao.setCellValueFactory(new PropertyValueFactory("doacao"));
        tabela.setItems(atualizaTabela());
    }    
    public ObservableList<Doacao> atualizaTabela(){
        DoacaoDAO dao = new DoacaoDAO();
        return FXCollections.observableArrayList(dao.getDica());
}
}*/