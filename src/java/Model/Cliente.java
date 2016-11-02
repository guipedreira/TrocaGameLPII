package Model;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 31524362
 */
public class Cliente {

    private Date usuarioDesde;
    private String email;
    private String username;
    private String senha;
    private String nome;
    private String telefone;
    private String celular;

    public Cliente() {
      
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getUsuarioDesde() {
        return usuarioDesde;
    }

    public void setUsuarioDesde(Date usuarioDesde) {
        this.usuarioDesde = usuarioDesde;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente(String username, String senha, String nome, String telefone, Date usuarioDesde, String celular, String email) {
        this.username = username;
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
        this.usuarioDesde = usuarioDesde;
        this.celular = celular;
        this.email = email;
    }

}
