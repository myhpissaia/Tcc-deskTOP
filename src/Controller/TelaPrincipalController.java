/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.TelaCadastroOng;
import Main.TelaLogin;
import Main.TelaPrincipal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author <Leticia e Mylena>
 */
public class TelaPrincipalController implements Initializable {

    @FXML
    private Button btCadastro, btLogin, btVoltar;
    @FXML
    private TextArea txOng;

    public void cadastro() {
        TelaCadastroOng cadastro = new TelaCadastroOng();
        TelaPrincipal.getStage().close();
        try {
            cadastro.start(new Stage());

        } catch (Exception ex) {
            Logger.getLogger(TelaCadastroOngController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void sair() {
        TelaPrincipal.getStage().close();
    }

    public void entrar() {
        TelaLogin telaLogin = new TelaLogin();
        TelaPrincipal.getStage().close();
        try {
            telaLogin.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btLogin.setOnKeyPressed((KeyEvent evt) -> { //mouse 
            if (evt.getCode() == KeyCode.ENTER) {
                entrar();
            }
        });
        btLogin.setOnMouseClicked((MouseEvent e) -> {
            entrar();
        });
        btCadastro.setOnKeyPressed((KeyEvent evt) -> { //mouse 
            if (evt.getCode() == KeyCode.ENTER) {
                cadastro();
            }
        });
        btCadastro.setOnMouseClicked((MouseEvent e) -> {
            cadastro();
        });
        btVoltar.setOnMouseClicked((MouseEvent e) -> {
            sair();
        });
        btVoltar.setOnKeyPressed((KeyEvent evt) -> {
            if (evt.getCode() == KeyCode.ENTER) {
                sair();
            }
        });
    }
}
