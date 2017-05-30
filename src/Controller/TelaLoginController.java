/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.OngDAO;
import Main.TelaAdmin;
import Main.TelaLogin;
import Main.TelaOng;
import Main.TelaPrincipal;
import Model.Ong;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author <Leticia e Mylena>
 */
public class TelaLoginController implements Initializable {

    //BUTTON
    @FXML
    private javafx.scene.control.Button btLogin;
    @FXML
    private javafx.scene.control.Button btSair;

    //PasswordField
    @FXML
    private PasswordField psSenha;
    //TEXT
    @FXML
    private javafx.scene.control.TextField txLogin;

    public void Login() {
        if (txLogin.equals("") || psSenha.equals("")) {

            Alert erro = new Alert(Alert.AlertType.WARNING);
            erro.setTitle("Erro!");
            erro.setHeaderText("Campos vazios!");
            erro.setContentText("Preencha todos os campos");
            erro.showAndWait();

        } else if (txLogin.getText().equals("admin") && psSenha.getText().equals("admin123")) {
            TelaAdmin admin = new TelaAdmin();
            try {
                admin.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

            TelaLogin.getStage().close();
        } else {
            OngDAO dao = new OngDAO();
            ObservableList<Ong> cadastro = FXCollections.observableArrayList(dao.getOng());

            for (int x = 0; x < cadastro.size(); x++) {
                if (cadastro.get(x).getLogin().equals(txLogin.getText()) && cadastro.get(x).getSenha().equals(psSenha.getText())) {
                    TelaOng entrada = new TelaOng();
                    try {
                        entrada.start(new Stage());
                    } catch (Exception ex) {
                        Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    TelaLogin.getStage().close();
                    
                } else if (x + 1 == cadastro.size()) {
                    Alert erro = new Alert(Alert.AlertType.ERROR);
                    erro.setHeaderText("Usuario ou senha incorretos. Tente novamente");
                    erro.show();
                }
            }
        }
    }
    public void sair() {
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        TelaLogin.getStage().close();
        try {
            telaPrincipal.start(new Stage());

        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override

    public void initialize(URL url, ResourceBundle rb) {

        btSair.setOnMouseClicked((s) -> {
            sair();
        });
        btSair.setOnKeyPressed((KeyEvent evt) -> {
            if (evt.getCode() == KeyCode.ENTER) {
                sair();
            }
        });
        btLogin.setOnMouseClicked((MouseEvent e) -> {
            Login();
        });
        btLogin.setOnKeyPressed((KeyEvent evt) -> {
            if (evt.getCode() == KeyCode.ENTER) {
                Login();
            }
        });
        psSenha.setOnKeyPressed((KeyEvent evt) -> {
            if (evt.getCode() == KeyCode.ENTER) {
                Login();
            }
        });

    }
}
