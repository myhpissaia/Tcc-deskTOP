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
 * @author <Leticia e Mylena>
 */
public class TelaTabelaDoacao extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaTabelaDoacao.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle(" Tabela Doacao");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/Imagens/foto1.png")));
        stage.setScene(scene);
        stage.show();
        TelaTabelaDoacao.stage = stage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage() {
        return TelaTabelaDoacao.stage;
    }

    public void setStage(Stage s) {
        TelaTabelaDoacao.stage = s;
    }
}