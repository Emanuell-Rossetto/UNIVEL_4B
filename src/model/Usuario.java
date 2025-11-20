package model;

public class Usuario { //classe
    //propriedades 
    private int id;
    private String login;
    private String senha;
    private String dataCriacao;
    private String ativo;
    private String tipo;
    private String email;
    
    public int getId() { return id; }
    public void setId(int id) {this.id = id; }

    public String getLogin() { return login;}
    public void setLogin(String login) {this.login = login;}

    public String getSenha() { return senha;}
    public void setSenha(String senha) {this.senha = senha;}

    public String getDataCriacao() { return dataCriacao;}
    public void setDataCriacao(String dataCriacao) {this.dataCriacao = dataCriacao;}

    public String getAtivo() { return ativo;}
    public void setAtivo(String ativo) {this.ativo = ativo;}

    public String getTipo() { return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}

    public String getEmail() { return email;}
    public void setEmail(String email) {this.email = email;}

}
