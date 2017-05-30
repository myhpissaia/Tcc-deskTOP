/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author <Leticia e Mylena>
 */
public class ConnectionFactory {
    public Connection getConnection() {
        String usuario = "postgres";
        String senha = "aluno";
        String nomeBanco = "Tcc";
        String enderecoServer = "localhost";
        try {
                return DriverManager.getConnection("jdbc:postgresql://localhost/Tcc",
                    "postgres", "aluno");

        } catch (SQLException e) {
            System.err.println("ERRO!Conexão não aconteceu");
            throw new RuntimeException(e);
        }

    }
}