/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author  <Leticia e Mylena>
 */
public class Funções {
    public static String byteToFile(byte[] bit,String id) throws IOException{
        existe();
        OutputStream ou = new FileOutputStream("C:/Users/Aluno/Pictures/Projeto/"+id);
        ou.write(bit);
        ou.close();
       
        return "file:///"+getCaminho(id);
    }
      public static void existe(){
        File a = new File("C:/Users/Aluno/Pictures/Projeto/");
        if(a.exists()){
            
        }else{
            a.mkdir();
        }
    }
        public static String getCaminho(String id){
        return "C:/Users/Aluno/Pictures/Projeto/"+id;
    }
    
}
