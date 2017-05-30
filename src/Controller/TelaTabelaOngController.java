/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.OngDAO;
import Main.TelaAdmin;
import Main.TelaCadastroOng;
import Main.TelaTabelaOng;
import Model.Ong;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author <Leticia e Mylena>
 */
public class TelaTabelaOngController implements Initializable {

    @FXML
    private TableView<Ong> tabela;

    @FXML
    private ImageView img,imagem;

    @FXML
    private TableColumn<Ong, String> clnId, clnEstado, clnCidade, clnEndereco, clnCnpj, clnNome,
            clnLogin, clnEmail;
    @FXML
    private TextField txPesquisa;

    @FXML
    private Button btAlterar, btDeleta, btPesquisa, btAtualiza, btPdf;

    @FXML
    private Label roupa;

    @FXML
    private Label alimento;

    @FXML
    private Label brinquedo;

    @FXML
    private Label higiene;

    private Ong selecionada;

    private ObservableList<Ong> ong = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostraTabela();
        btAtualiza.setOnMouseClicked((MouseEvent e) -> {
            tabela.setItems(atualizaTabela());

        });
        btAtualiza.setOnKeyPressed((KeyEvent evt) -> {
            if (evt.getCode() == KeyCode.ENTER) {
                tabela.setItems(atualizaTabela());
            }
        });
         btAlterar.setOnMouseClicked((MouseEvent e) -> {
          alterar();
         });
         btAlterar.setOnKeyPressed((KeyEvent evt) -> {
         if (evt.getCode() == KeyCode.ENTER) {
          alterar();
         }
         });
        btDeleta.setOnMouseClicked((MouseEvent e) -> {
            deletar();
        });
        btDeleta.setOnKeyPressed((KeyEvent evt) -> {
            if (evt.getCode() == KeyCode.ENTER) {
                deletar();
            }
        });
        btPdf.setOnMouseClicked((MouseEvent e) -> {
            gerarpdf();
        });
        btPdf.setOnKeyPressed((KeyEvent evt) -> {
            if (evt.getCode() == KeyCode.ENTER) {
                gerarpdf();
            }
        });
        img.setOnMouseClicked((MouseEvent e) -> {
            volte();
        });
        img.setOnKeyPressed((KeyEvent evt) -> {
            if (evt.getCode() == KeyCode.ENTER) {
                volte();
            }

        });

        txPesquisa.setOnKeyReleased((KeyEvent evt) -> {
            tabela.setItems(busca());

        });
        tabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Ong>() {
            @Override
            public void changed(ObservableValue<? extends Ong> observable, Ong oldValue, Ong newValue) {

                selecionada = (Ong) newValue;

                alimento.setText("");
                brinquedo.setText("");
                roupa.setText("");
                higiene.setText("");

                if (selecionada != null) {//mostrar as opcoes 

                    if (selecionada.isNecAlimento()) {
                        alimento.setText("Alimento: SIM");
                    } else {
                        alimento.setText("Alimento: NÃO");
                    }

                    if (selecionada.isNecBrinquedo()) {
                        brinquedo.setText("Brinquedo: SIM");
                    } else {
                        brinquedo.setText("Brinquedo: NÃO");
                    }
                    
                    if (selecionada.isNecRoupa()) {
                        roupa.setText("Roupa: SIM");
                    } else {
                        roupa.setText("Roupa: NÃO");
                    }
                    
                    if (selecionada.isNecHigiene()) {
                        higiene.setText("Higiene: SIM");
                    } else {
                        higiene.setText("Higiene: NÃO");
                    }

                }
                 Detalhes();
            }
        });
    }

    public void mostraTabela() {
        clnId.setCellValueFactory(new PropertyValueFactory("id"));
        clnNome.setCellValueFactory(new PropertyValueFactory("nome"));
        clnEndereco.setCellValueFactory(new PropertyValueFactory("endereco"));
        clnCidade.setCellValueFactory(new PropertyValueFactory("cidade"));
        clnEstado.setCellValueFactory(new PropertyValueFactory("estado"));
        clnCnpj.setCellValueFactory(new PropertyValueFactory("cnpj"));
        clnEmail.setCellValueFactory(new PropertyValueFactory("email"));
        clnLogin.setCellValueFactory(new PropertyValueFactory("login"));
        
        
        tabela.setItems(atualizaTabela());
    }

    public ObservableList<Ong> atualizaTabela() {
        OngDAO dao = new OngDAO(); //cria DAO
        ong = FXCollections.observableArrayList(dao.getOng());// vai armazenar ong
        return ong;

    }

    public void deletar() {
        if (selecionada != null) {
            OngDAO dao = new OngDAO();

            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setHeaderText("Deseja deletar ?");
            Optional<ButtonType> btn = a.showAndWait();

            if (btn.get() == ButtonType.OK) {

                if (dao.deleteOng(selecionada)) {
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION);
                    a1.setHeaderText("Deletado com sucesso");
                    a1.showAndWait();
                    tabela.setItems(atualizaTabela());

                } else {
                    Alert a2 = new Alert(Alert.AlertType.WARNING);
                    a2.setHeaderText("Nao foi possivel deletar");
                    a2.showAndWait();
                }
            }            
        } else {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Selecione Algo");
            a.show();
        }
    }

    public void volte() {
        TelaAdmin e = new TelaAdmin();

        try {
            e.start(new Stage());
            TelaTabelaOng.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(TelaTabelaOngController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public void Detalhes() {//mostrar imagem na tabela 
        if (selecionada != null) {
            imagem.setImage(new Image("File:///"+selecionada.getFoto()));
        } else {
            imagem.setImage(new Image("/Imagens/semImagem.png"));
        }
    }

    private ObservableList<Ong> busca() {//realizar pesquisa
        ObservableList<Ong> ongPesquisa = FXCollections.observableArrayList();
        for (int x = 0; x < ong.size(); x++) {
            if (ong.get(x).getNome().toLowerCase().contains(txPesquisa.getText().toLowerCase())) {//retorna a ong contains= string contem na text
                ongPesquisa.add(ong.get(x));
            }
        }
        return ongPesquisa;

    }

    public void alterar() {
        if (selecionada != null) {
            TelaCadastroOngController.setOng(selecionada);
            TelaCadastroOng al = new TelaCadastroOng();
            try {
                al.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(TelaTabelaOngController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Selecione Algo");
            a.show();
        }
    }

    public void gerarpdf() {
        Document doc = new Document();
        FileChooser f = new FileChooser();
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF", ".pdf"));
        File file = f.showSaveDialog(new Stage());
        if (file != null) {
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(file.getAbsolutePath()));
                doc.open();
                List<Ong> ong = new OngDAO().getOng();
                for (int x = 0; x < ong.size(); x++) {

                    doc.add(new Paragraph(" ONG cadastrada                     "));
                    doc.add(new Paragraph("Id : " + ong.get(x).getId()));
                    doc.add(new Paragraph("Nome : " + ong.get(x).getNome()));
                    doc.add(new Paragraph("Endereco : " + ong.get(x).getEndereco()));
                    doc.add(new Paragraph("Cidade : " + ong.get(x).getCidade()));
                    doc.add(new Paragraph("Estado : " + ong.get(x).getEstado()));
                    doc.add(new Paragraph("CNPJ : " + ong.get(x).getCnpj()));
                    doc.add(new Paragraph("Email : " + ong.get(x).getEmail()));
                    doc.add(new Paragraph("Login : " + ong.get(x).getLogin()));
                    doc.add(new Paragraph("Descrição : " + ong.get(x).getDescricao()));
                    doc.add(new Paragraph("                                     "));
                }
                doc.close();
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("PDF Gerado com Sucesso");
                a.show();

            } catch (DocumentException ex) {
                Logger.getLogger(TelaTabelaOngController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TelaTabelaOngController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Escolha algum lugar para o salvar o arquivo");
            a.show();
        }
    }

}
