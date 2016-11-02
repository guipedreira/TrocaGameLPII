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
public class Jogo {
     private float valorNovo;
    private String produtora;
    private String titulo;
    private String subtitulo;
    private String capa;

    public Jogo() {
        
    }

    public float getValorNovo() {
        return valorNovo;
    }

    public void setValorNovo(float valorNovo) {
        this.valorNovo = valorNovo;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public Jogo(float valorNovo, String produtora, String titulo, String subtitulo, String capa) {
        this.valorNovo = valorNovo;
        this.produtora = produtora;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.capa = capa;
    }
    
}
