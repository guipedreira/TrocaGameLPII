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
public class Midia
{
    private double statusMidia;
    private String tipo;
    private int cod;

    public Midia() {
        
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public double getStatusMidia() {
        return statusMidia;
    }

    public void setStatusMidia(double statusMidia) {
        this.statusMidia = statusMidia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Midia(double statusMidia, String tipo) {
        this.statusMidia = statusMidia;
        this.tipo = tipo;
    }

}

