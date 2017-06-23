package Controller;

import DAO.OngDAO;
import Main.TelaAdmin;
import Main.TelaFotos;
import Model.Ong;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class TelaFotosController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private GridPane gridPane;

    @FXML
    private Button btVoltar;

    public void fotoOng(List<Ong> ong) {

        if (ong != null) {

            int coluna = 0;
            int linha = 0;
            for (int x = 0; x < ong.size(); x++) {

                Ong o = ong.get(x);
                try {
                    //Cria imagem
                    ImageView image = new ImageView(new Image("file:///" + o.getFoto()));

                    //Cria titulo
                    Label nome = new Label(o.getNome());

                    //Arruma a largura e altura da imagem
                    image.setFitHeight(80);
                    image.setFitWidth(120);

                    //Define a opacidade
                    image.setOpacity(0.1);

                    //Define estilo css para a imagem
                    image.setStyle("-fx-effect: innershadow(gaussian,#424242,5,0.5,0.5,0.5);");

                    //Clique do mouse
                    image.setOnMouseClicked((MouseEvent e) -> {
                        if (e.getButton() == MouseButton.PRIMARY) {
                            //playMusica(o);
                        }
                    });

                    //Quando o mouse entra na imagem
                    image.setOnMouseEntered((MouseEvent e) -> {
                        image.setOpacity(1);
                        nome.setOpacity(1);
                        image.setStyle("-fx-effect: dropshadow(gaussian,#ffcc00,5,0.5,0.5,0.5);");

                        //Passa um icone do mouse especifico
                        image.setCursor(Cursor.HAND);
                    });

                    //Quando o mouse sai da imagem
                    image.setOnMouseExited((MouseEvent e) -> {
                        image.setOpacity(0.1);
                        nome.setOpacity(0.03);
                        image.setStyle("-fx-effect: innershadow(gaussian,#424242,5,0.5,0.5,0.5);");
                        image.setCursor(Cursor.DEFAULT);
                    });

                    nome.setStyle("-fx-effect: innershadow(gaussian,#000,1,0.5,0.5,0.5);"
                            + "-fx-text-fill:#fff;"
                            + "-fx-font-weight: BOLD;");
                    nome.setOpacity(0.03);
                    GridPane.setConstraints(image, coluna, linha, 1, 1, HPos.CENTER, VPos.CENTER);
                    linha++;
                    GridPane.setConstraints(nome, coluna, linha, 1, 1, HPos.CENTER, VPos.CENTER);
                    linha--;

                    //Passa imagem e titulo para a grid
                    gridPane.getChildren().addAll(nome, image);
                    coluna++;
                    if (coluna == 5) {
                        coluna = 0;
                        linha += 2;
                    }

                } catch (Exception ex) {
                    Logger.getLogger(TelaFotosController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    public void voltar() {
        TelaAdmin telaAdmin = new TelaAdmin();
        TelaFotos.getStage().close();
        try {

            telaAdmin.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        OngDAO dao = new OngDAO();
        fotoOng(dao.getOng());
        btVoltar.setOnKeyPressed((KeyEvent evt) -> { //mouse 
            if (evt.getCode() == KeyCode.ENTER) {
                voltar();
            }
        });
        btVoltar.setOnMouseClicked((MouseEvent e) -> {
            voltar();
        });
    }

}
