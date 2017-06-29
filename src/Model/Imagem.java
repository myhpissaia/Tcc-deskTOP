package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Aluno
 */
public class Imagem {

    public String atualizaCaminho(String caminho, String email) {

        try {
            BufferedImage imagem = ImageIO.read(new File(caminho));
            ImageIO.write(imagem, "JPG", new File("F:\\TCC-Mylena-1deb1c95de5ae4db03d069583fd901b6ac4a3ceb\\web\\imagens\\" + email + ".jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Imagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "imagens\\" + email + ".jpg";

    }

}
