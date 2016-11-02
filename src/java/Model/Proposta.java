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
public class Proposta {
     
    private Date dataHoraCriacao;
    private String status;
    private int id;

    public Proposta() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Date getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(Date dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   

    public Proposta(Date dataHoraCriacao, String status, int id) {
        this.dataHoraCriacao = dataHoraCriacao;
        this.status = status;
        this.id = id;
    }
}
