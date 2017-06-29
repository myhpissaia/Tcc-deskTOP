/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.ConnectionFactory;
import Model.Usuario;
import Model.Doacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author <Leticia e Mylena>
 */
public class DoaDAO {

    private Connection conexao;

    public DoaDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    public void insereDoacao(Doacao u) {
        try {
            
            String sql = "INSERT INTO doacao (nome_ong,nome,email,alimento,"
                    + "roupa,brinquedo,higiene) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, u.getNome_ong());
            stmt.setString(2, u.getNome());
            stmt.setString(3, u.getEmail());
            stmt.setBoolean(4, u.isNecAlimento());
            stmt.setBoolean(5, u.isNecBrinquedo());
            stmt.setBoolean(6, u.isNecRoupa());
            stmt.setBoolean(7, u.isNecHigiene());

            stmt.execute();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
