/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Leticia
 */
public class TelaTabelaPessoa implements Initializable {
    
    @FXML 
    private Button btVoltar;
    
    @FXML
    private TableView<Usuario> tabela;
    
    @FXML 
    private TableColumn<Usuario, String> clnId;
    
    @FXML
    private TableColumn<Usuario, String> clnNome;
    
    @FXML 
    private TableColumn<Usuario, String> clnSobrenome;
    
    @FXML 
    private TableColumn<Usuario, String> clnEmail;

    private static Usuario selecionada;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clnId.setCellValueFactory(new PropertyValueFactory("id"));
        clnNome.setCellValueFactory(new PropertyValueFactory("nome"));
        clnSobrenome.setCellValueFactory(new PropertyValueFactory("sobrenome"));
        clnEmail.setCellValueFactory(new PropertyValueFactory("email"));
        tabela.setItems(atualizaTabela());
    }
    public ObservableList<Usuario> atualizaTabela(){
        UsuarioDAO dao = new UsuarioDAO();
        return FXCollections.observableArrayList(dao.getUsuario());
    }
}