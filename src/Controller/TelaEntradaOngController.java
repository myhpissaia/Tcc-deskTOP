/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.TelaAdmin;
import Main.TelaLogin;
import Main.TelaOng;
import Main.TelaPrincipal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class TelaEntradaOngController implements Initializable {

    @FXML
    private Button btVoltar;

    @FXML
    private Button btGrafico;

    @FXML
    private Button btDoa;

       public void entrar() {
        //TelaLogin telaLogin = new TelaLogin();
        TelaOng.getStage().close();
        try {
           // telaLogin.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void sair() {
        TelaPrincipal principal = new TelaPrincipal();
        TelaOng.getStage().close();
        try {
            principal.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      btVoltar.setOnKeyPressed((KeyEvent evt) -> { //mouse 
            if (evt.getCode() == KeyCode.ENTER) {
                sair() ;
            }
        });
        btVoltar.setOnMouseClicked((MouseEvent e) -> {
            sair() ;
        });
    }

}
