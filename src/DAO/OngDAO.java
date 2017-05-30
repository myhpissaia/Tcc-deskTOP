package DAO;

import JDBC.ConnectionFactory;
import Model.Ong;
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
public class OngDAO {

    private Connection conexao;

    public OngDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    public void insereOng(Ong u) {
        try {
            String sql = "INSERT INTO ong (nome, endereco, cidade, estado, cnpj, email, login, senha, consenha, descricao,"
                    + " necAlimento, necBrinquedo, necRoupa, necHigiene, imagem) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEndereco());
            stmt.setString(3, u.getCidade());
            stmt.setString(4, u.getEstado());
            stmt.setString(5, u.getCnpj());
            stmt.setString(6, u.getEmail());
            stmt.setString(7, u.getLogin());
            stmt.setString(8, u.getSenha());
            stmt.setString(9, u.getConSenha());
            stmt.setString(10, u.getDescricao());
            stmt.setBoolean(11, u.isNecAlimento());
            stmt.setBoolean(12, u.isNecBrinquedo());
            stmt.setBoolean(13, u.isNecRoupa());
            stmt.setBoolean(14, u.isNecHigiene());
            stmt.setString(15, u.getFoto());

            stmt.execute();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(OngDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Ong u) throws SQLException {
        String sql = "UPDATE ong SET nome=?, endereco=?, cidade=?, estado=?, cnpj=?, email=?, login=?, senha=?, consenha=?, descricao=?,"
                + " necAlimento=?, necBrinquedo=?, necRoupa=?, necHigiene=?, imagem=? WHERE id_ong=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1,   u.getNome());
        stmt.setString(2,   u.getEndereco());
        stmt.setString(3,   u.getCidade());
        stmt.setString(4,   u.getEstado());
        stmt.setString(5,   u.getCnpj());
        stmt.setString(6,   u.getEmail());
        stmt.setString(7,   u.getLogin());
        stmt.setString(8,   u.getSenha());
        stmt.setString(9,   u.getConSenha());
        stmt.setString(10,  u.getDescricao());
        stmt.setBoolean(11, u.isNecAlimento());
        stmt.setBoolean(12, u.isNecBrinquedo());
        stmt.setBoolean(13, u.isNecRoupa());
        stmt.setBoolean(14, u.isNecHigiene());
        stmt.setString(15,  u.getFoto());
        stmt.setLong(16,    u.getId());

        stmt.execute();
        conexao.close();
    }

    public boolean deleteOng(Ong d) {
        String sql = "DELETE FROM ong WHERE id_ong=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setLong(1, d.getId());
            stmt.execute();
            stmt.close();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OngDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Ong> getOng() {
        List<Ong> ong = new ArrayList<Ong>();
        try {
            String sql = "SELECT * FROM ong";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();//serve para tirar os dados do banco de dados
            while (rs.next()) {
                Ong u = new Ong();
                u.setId(rs.getLong("id_ong"));
                u.setNome(rs.getString("Nome"));
                u.setEndereco(rs.getString("Endereco"));
                u.setCidade(rs.getString("Cidade"));
                u.setEstado(rs.getString("Estado"));
                u.setCnpj(rs.getString("Cnpj"));
                u.setEmail(rs.getString("Email"));
                u.setLogin(rs.getString("Login"));
                u.setSenha(rs.getString("Senha"));
                u.setConSenha(rs.getString("ConSenha"));
                u.setDescricao(rs.getString("Descricao"));
                u.setNecAlimento(rs.getBoolean("necAlimento"));
                u.setNecBrinquedo(rs.getBoolean("necBrinquedo"));
                u.setNecRoupa(rs.getBoolean("necRoupa"));
                u.setNecHigiene(rs.getBoolean("necHigiene"));
                u.setFoto(rs.getString("Imagem"));

                ong.add(u);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(OngDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ong;

    }

}
