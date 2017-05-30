/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author <Leticia e Mylena>
 */
public class Ong {

    private Long id;
    private String nome;
    private String endereco;
    private String cidade;
    private String estado;
    private String cnpj;
    private String email;
    private String foto;
    private String login;
    private String senha;
    private String conSenha;
    private String descricao;
    private boolean necAlimento;
    private boolean necBrinquedo;
    private boolean necRoupa;
    private boolean necHigiene;

    public Ong(String nome,
            String endereco,
            String cidade,
            String estado,
            String cnpj,
            String email,
            String foto,
            String descricao,
            String login,
            String senha,
            String conSenha) {

        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.cnpj = cnpj;
        this.email = email;
        this.foto = foto;
        this.descricao = descricao;
        this.login = login;
        this.senha = senha;
        this.conSenha = conSenha;

    }

    public Ong() {

    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the conSenha
     */
    public String getConSenha() {
        return conSenha;
    }

    /**
     * @param conSenha the conSenha to set
     */
    public void setConSenha(String conSenha) {
        this.conSenha = conSenha;
    }

    /**
     * @return the necAlimento
     */
    public boolean isNecAlimento() {
        return necAlimento;
    }

    /**
     * @param necAlimento the necAlimento to set
     */
    public void setNecAlimento(boolean necAlimento) {
        this.necAlimento = necAlimento;
    }

    /**
     * @return the necBrinquedo
     */
    public boolean isNecBrinquedo() {
        return necBrinquedo;
    }

    /**
     * @param necBrinquedo the necBrinquedo to set
     */
    public void setNecBrinquedo(boolean necBrinquedo) {
        this.necBrinquedo = necBrinquedo;
    }

    /**
     * @return the necRoupa
     */
    public boolean isNecRoupa() {
        return necRoupa;
    }

    /**
     * @param necRoupa the necRoupa to set
     */
    public void setNecRoupa(boolean necRoupa) {
        this.necRoupa = necRoupa;
    }

    /**
     * @return the necHigiene
     */
    public boolean isNecHigiene() {
        return necHigiene;
    }

    /**
     * @param necHigiene the necHigiene to set
     */
    public void setNecHigiene(boolean necHigiene) {
        this.necHigiene = necHigiene;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Endereço: " + endereco ;
    }
    
    
    
}
