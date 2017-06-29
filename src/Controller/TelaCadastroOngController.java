/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.BD;
import DAO.OngDAO;
import Main.TelaLogin;
import Main.TelaCadastroOng;
import Main.TelaPrincipal;
import Model.Criptografia;
import Model.Imagem;
import Model.Ong;
import Model.Usuario;
import Model.validacaoCNPJ;
import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.effect.BlendMode;
import static javafx.scene.effect.BlendMode.RED;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author <Leticia e Mylena>
 */
public class TelaCadastroOngController implements Initializable {

    @FXML
    private TextField txNome, txEndereco, txCidade, txEstado, txCNPJ, txEmail, txLogin;

    @FXML
    private PasswordField senha, conSenha;

    @FXML
    private TextArea txDescricaoOng;

    @FXML
    private CheckBox alimento, brinquedo, roupas, higiene;

    @FXML
    private Button btVoltar, btCadastro, btDeletar;
    @FXML
    private Label lEmail;
    @FXML
    private ImageView img;
    String caminho;

    public void entrar() {
        TelaPrincipal prin = new TelaPrincipal();
        try {

            Ong ong = new Ong();
            ong.setNome(txNome.getText());
            ong.setEndereco(txEndereco.getText());
            ong.setCidade(txCidade.getText());
            ong.setEstado(txEstado.getText());
            ong.setCnpj(txCNPJ.getText());
            ong.setEmail(txEmail.getText());
            ong.setLogin(txLogin.getText());
            ong.setSenha(Criptografia.criptografar(senha.getText()));
            ong.setConSenha(Criptografia.criptografar(conSenha.getText()));
            ong.setDescricao(txDescricaoOng.getText());
            ong.setNecAlimento(alimento.isSelected());
            ong.setNecBrinquedo(brinquedo.isSelected());
            ong.setNecRoupa(roupas.isSelected());
            ong.setNecHigiene(higiene.isSelected());
            
            Imagem imagem = new Imagem();
            String novoCaminho = imagem.atualizaCaminho(caminho, txEmail.getText());
            
            ong.setFoto(novoCaminho);

            OngDAO cadastro = new OngDAO();
            cadastro.insereOng(ong);

            if (senha.getText().equals(conSenha.getText())) {

                Alert boa = new Alert(Alert.AlertType.CONFIRMATION);
                boa.setHeaderText("Deseja Cadastar ?");
                Optional<ButtonType> btn = boa.showAndWait();

                if (btn.get() == ButtonType.OK) {

                    Alert foi = new Alert(Alert.AlertType.INFORMATION);
                    foi.setHeaderText("Cadastrado com Sucesso");
                    foi.showAndWait();

                    TelaCadastroOng.getStage().close();

//                    String s = Criptografia.criptografar(senha.getText());
//                    ong.setSenha(s);

                    BD.getOng().add(ong);
                    TelaCadastroOng.getStage().close();
                    prin.start(new Stage());
                } else if (btn.get() == ButtonType.CANCEL) {
                    txNome.clear();
                    txEndereco.clear();
                    txCidade.clear();
                    txEstado.clear();
                    txCNPJ.clear();
                    txEmail.clear();
                    txLogin.clear();
                    senha.clear();
                    conSenha.clear();
                    txDescricaoOng.clear();
                    alimento.setSelected(false);
                    brinquedo.setSelected(false);
                    roupas.setSelected(false);
                    higiene.setSelected(false);
                    img.setImage(new Image("/Imagens/semImagem.png"));
                }

            } else {
                Alert erro = new Alert(Alert.AlertType.ERROR);
                erro.setHeaderText("Senha e Confirmar senha nao estao iguais ");
                erro.setContentText("Tente novamente, preenchendo corretamente as senhas ");
                conSenha.setBlendMode(BlendMode.RED);
                erro.showAndWait();
            }

        } catch (Exception ex) {
            Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void validar() {
        String Nome = txNome.getText(),
                Endereco = txEndereco.getText(),
                Cidade = txCidade.getText(),
                Estado = txEstado.getText(),
                Cnpj = txCNPJ.getText(),
                Email = txEmail.getText(),
                Login = txLogin.getText(),
                Senha = senha.getText(),
                ConSenha = conSenha.getText();

        if (Nome == null || Nome.trim().isEmpty()
                || Endereco == null || Endereco.trim().isEmpty()
                || Cidade == null || Cidade.trim().isEmpty()
                || Estado == null || Estado.trim().isEmpty()
                || Cnpj == null || Cnpj.trim().isEmpty()
                || Email == null || Email.trim().isEmpty()) {
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setTitle("ERRO");
            erro.setHeaderText("Campos obrigatorios nao preenchidos  ");
            erro.setContentText("Preencha todos os campos obrigatorios ");
            txNome.setBlendMode(BlendMode.RED);
            txEndereco.setBlendMode(BlendMode.RED);
            txCidade.setBlendMode(BlendMode.RED);
            txEstado.setBlendMode(BlendMode.RED);
            txCNPJ.setBlendMode(BlendMode.RED);
            txEmail.setBlendMode(BlendMode.RED);
            txLogin.setBlendMode(RED);
            senha.setBlendMode(RED);
            conSenha.setBlendMode(RED);

            erro.showAndWait();

        } else {

            ValidaEmail();

        }
    }

    public void validarCnpj() {
        String Cnpj = txCNPJ.getText();
        validacaoCNPJ validacaoCNPJ = new validacaoCNPJ();
        if (validacaoCNPJ.isCNPJ(Cnpj) == true) {

            if (ong != null) {
                editar();
            } else {
                entrar();
            }

        } else {
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setTitle("ERRO");
            erro.setHeaderText("O CNPJ inserido é invalidade/ não existe ");
            erro.setContentText("Preencha com um CNPJ existente ");
            erro.show();

        }
    }

    public void ValidaEmail() {
        String email = txEmail.getText();
        int y = 0;
        OngDAO dao = new OngDAO();
        List<Ong> usuario = new ArrayList(dao.getOng());

        for (int x = 0; x < usuario.size(); x++) {
            if (email.equals(usuario.get(x).getEmail())) {
                Alert errocad = new Alert(Alert.AlertType.ERROR);//criando o erro
                errocad.setHeaderText("Erro! O email inserido é invalido!");//adcionando corpo ao erro
                errocad.show();
                lEmail.setBlendMode(RED);
                txEmail.clear();
                y++;
            }
        }
        
        if (y == 0) {
            try {
                validarCnpj();
            } catch (Throwable ex) {
                Logger.getLogger(TelaCadastroOngController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//lembrete placar 995 acançar

    public void validaCheckBox() {
        if (alimento.isSelected()) {
            System.out.println("deu alimento");
        }
        if (brinquedo.isSelected()) {
            System.out.println("deu brinquedo");
        }
        if (roupas.isSelected()) {
            System.out.println("deu roupa");
        }
        if (higiene.isSelected()) {
            System.out.println("deu higiene");
        }
    }

    public void voltar() {
        TelaPrincipal principal = new TelaPrincipal();
        TelaCadastroOng.getStage().close();
        try {
            principal.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Ong ong;

    public static void setOng(Ong ongEditar) {
        ong = ongEditar;
    }

    private void telaEditar() {
        txNome.setText(ong.getNome());
        txEndereco.setText(ong.getEndereco());
        txCidade.setText(ong.getCidade());
        txEstado.setText(ong.getEstado());
        txCNPJ.setText(ong.getCnpj());
        txEmail.setText(ong.getEmail());
        txLogin.setText(ong.getLogin());
        senha.setText(ong.getSenha());
        conSenha.setText(ong.getConSenha());
        txDescricaoOng.setText(ong.getDescricao());
        img.setImage(new Image("file:///" + ong.getFoto()));
    }

    private void editar() {

        Ong cadOng = new Ong();
        cadOng.setId(ong.getId());
        cadOng.setNome(txNome.getText());
        cadOng.setEndereco(txEndereco.getText());
        cadOng.setCidade(txCidade.getText());
        cadOng.setEstado(txEstado.getText());
        cadOng.setCnpj(txCNPJ.getText());
        cadOng.setEmail(txEmail.getText());
        cadOng.setLogin(txLogin.getText());
        cadOng.setSenha(senha.getText());
        cadOng.setConSenha(conSenha.getText());
        cadOng.setDescricao(txDescricaoOng.getText());
        cadOng.setNecAlimento(alimento.isSelected());
        cadOng.setNecBrinquedo(brinquedo.isSelected());
        cadOng.setNecRoupa(roupas.isSelected());
        cadOng.setNecHigiene(higiene.isSelected());
        cadOng.setFoto(caminho);

        OngDAO dao = new OngDAO();

        try {
            dao.update(cadOng);
            Alert errocad = new Alert(Alert.AlertType.INFORMATION);//criando o erro
            errocad.setHeaderText("Alterado com Sucesso");//adicionando corpo ao erro
            errocad.showAndWait();
            TelaCadastroOng.getStage().close();
        } catch (SQLException ex) {
            System.out.println("DEU ERRO!");
        }
        ong = null;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String senha = " senhadeteste ";//chamando a classe criptografia
        String crip = Criptografia.criptografar(senha);
        System.out.println("Criptografada: " + crip);
        if (ong != null) {
            telaEditar();
        }

        btCadastro.setOnMouseClicked((MouseEvent e) -> {
            if (ong != null) {
                editar();
            } else {
                validar();
            }
        });
        btCadastro.setOnKeyPressed((KeyEvent evt) -> {
            if (evt.getCode() == KeyCode.ENTER) {
                validar();

            }
        });
        btVoltar.setOnMouseClicked((MouseEvent e) -> {
            voltar();

        });
        btVoltar.setOnKeyPressed((KeyEvent evt) -> {
            if (evt.getCode() == KeyCode.ENTER) {
                voltar();
            }
        });
        img.setOnMouseClicked((MouseEvent e) -> {
            FileChooser chooser = new FileChooser();
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagens", "*.jpg", "*.jpeg", "*.png"));
            File a = chooser.showOpenDialog(new Stage());

            if (a != null) {
                caminho = a.getAbsolutePath();
                img.setImage(new Image("file:///" + a.getAbsolutePath()));

            } else {
                System.out.println("nulo");
            }
        });
        btDeletar.setOnMouseClicked((MouseEvent e) -> {
            img.setImage(new Image("/Imagens/semImagem.png"));
            caminho = "";
        });
    }

}
