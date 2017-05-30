/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.ConnectionFactory;
import Model.Usuario;
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
public class UsuarioDAO {
    private Connection conexao;

    public UsuarioDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }
    public void insereUsuario(Usuario i) {
        try {
            String sql = "INSERT INTO usuario (endereco,descricao,gravidade,material,imagem) VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, i.getNome());
            stmt.setString(2, i.getSobrenome());
            stmt.setString(3, i.getCpf());
            stmt.setString(4, i.getEndereco());
            stmt.setString(5, i.getTelefone());
            stmt.setString(6, i.getEmail());

            stmt.execute();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean updateUser(Usuario u) {
        String sql = "UPDATE usuario SET nome=?, sobrenome=?, cpf=?, endereco=?,telefone=?, email=? WHERE id_user =?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSobrenome());
            stmt.setString(3, u.getCpf());
            stmt.setString(4, u.getEndereco());
            stmt.setString(5, u.getTelefone());
            stmt.setString(6, u.getEmail());
            
            stmt.execute();
            conexao.close();
            return true;
        } catch (Exception ee) {
            ee.printStackTrace();
            return false;
        }
    }
    public boolean deleteUser(Usuario d) {
        String sql = "DELETE FROM usuario WHERE id_user=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setLong(1, d.getId());
            stmt.execute();
            stmt.close();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public List<Usuario> getUsuario() {
        List<Usuario> usuario = new ArrayList<Usuario>();
        try {
            String sql = "SELECT * FROM usuario";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setNome(rs.getString("nome"));
                u.setSobrenome(rs.getString("sobrenome"));
                u.setCpf(rs.getString("cpf"));
                u.setEndereco(rs.getString("endereco"));
                u.setTelefone(rs.getString("telefone"));
                u.setEmail(rs.getString("email"));
                usuario.add(u);
            }
                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
}