/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.OngDAO;
import Main.TelaAdmin;
import Main.TelaGraficoDoa;
import Model.Ong;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
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
public class TelaGraficoDoacaoController implements Initializable {

    @FXML
    private PieChart grafico;

    @FXML
    private Button btVoltar;

    List<String> tipos = new ArrayList<>();

    int alimento = 0;
    int roupa = 0;
    int brinquedo = 0;
    int higiene = 0;

    private void getInf() {
        tipos.add("Alimento");
        tipos.add("Roupa");
        tipos.add("Brinquedo");
        tipos.add("Higiene");

        OngDAO ongDAO = new OngDAO();
        List<Ong> list = ongDAO.getOng();

        for (Ong ong : list) {
            if (ong.isNecAlimento()) {
                alimento++;
            } else if (ong.isNecRoupa()) {
                roupa++;
            } else if (ong.isNecBrinquedo()) {
                brinquedo++;
            } else if (ong.isNecHigiene()) {
                higiene++;
            }
        }
    }

    public void sair() {
        TelaAdmin admin = new TelaAdmin();
        TelaGraficoDoa.getStage().close();
        try {
            admin.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preencheGrafico() {
        grafico.getData().clear();

        grafico.getData().add(new PieChart.Data(tipos.get(0), alimento));
        grafico.getData().add(new PieChart.Data(tipos.get(1), roupa));
        grafico.getData().add(new PieChart.Data(tipos.get(2), brinquedo));
        grafico.getData().add(new PieChart.Data(tipos.get(3), higiene));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getInf();
        preencheGrafico();

        btVoltar.setOnKeyPressed((KeyEvent evt) -> { //mouse 
            if (evt.getCode() == KeyCode.ENTER) {
                sair();
            }
        });
        btVoltar.setOnMouseClicked((MouseEvent e) -> {
            sair();
        });

    }

}
