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
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author  <Leticia e Mylena>
 */
public class TelaFotos extends Application { 
    private static Stage stage;
    
  

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaFotos.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Fotos");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/Imagens/foto1_1.png")));
        stage.setScene(scene);
        stage.show();
        TelaFotos.stage = stage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
        public static Stage getStage() {
        return TelaFotos.stage;
    }
    public void setStage(Stage s) {
        TelaFotos.stage = s;
    }
}