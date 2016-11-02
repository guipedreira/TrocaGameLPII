package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 31524362
 */
public class Plataforma{
    private String descricao;
    private String tipo;

    public Plataforma(String descricao, String tipo) {
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public Plataforma() {
        
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
