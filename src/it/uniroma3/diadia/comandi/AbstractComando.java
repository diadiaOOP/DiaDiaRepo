package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public abstract class AbstractComando {
    private Partita p;
    private String parametro;

    public void setPartita(Partita p) {
        this.p = p;
    }

    public void setParametro(String params) {
        this.parametro = params;
    }

    public abstract void esegui(Partita partita);

    
    public Partita getPartita() {
        return p;
    }

    public String getParametro() {
        return parametro;
    }
    
    public String getNome() {
    	return null;
    }

}