/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Aluno
 */
public class TelaGraficoDoa  extends Application { 
    private static Stage stage;
    
  

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaGraficoDoa.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Cadastro Ong");
        stage.setScene(scene);
        stage.show();
        TelaGraficoDoa.stage = stage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
        public static Stage getStage() {
        return TelaGraficoDoa.stage;
    }
    public void setStage(Stage s) {
        TelaGraficoDoa.stage = s;
    }
}
