/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author <Leticia e Mylena>
 */
public class Doacao {

    private int id;
    private String nome_ong;
    private String nome;
    private String email;
    private boolean necAlimento;
    private boolean necBrinquedo;
    private boolean necRoupa;
    private boolean necHigiene;

    public Doacao(int id, String nome_ong) {
        this.id = id;
        this.nome_ong = nome_ong;
        
    }

    public Doacao() {

    }

    public String getNome_ong() {
        return nome_ong;
    }

    public void setNome_ong(String nome_ong) {
        this.nome_ong = nome_ong;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isNecAlimento() {
        return necAlimento;
    }

    public void setNecAlimento(boolean necAlimento) {
        this.necAlimento = necAlimento;
    }

    public boolean isNecBrinquedo() {
        return necBrinquedo;
    }

    public void setNecBrinquedo(boolean necBrinquedo) {
        this.necBrinquedo = necBrinquedo;
    }

    public boolean isNecRoupa() {
        return necRoupa;
    }

    public void setNecRoupa(boolean necRoupa) {
        this.necRoupa = necRoupa;
    }

    public boolean isNecHigiene() {
        return necHigiene;
    }

    public void setNecHigiene(boolean necHigiene) {
        this.necHigiene = necHigiene;
    }
}
