package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.Partita;

/**
 * Questa classe definisce lo stato del giocatore tramite gestione dei CFU
 *  e dei suoi attrezzi
 *  
 *  @author Andrea Menichelli & Alessio Piccione
 *  @see Borsa
 *  @see Partita
 *  @version 0.1
 *  */
public class Giocatore {
	private Borsa borsa;
	private int cfu;
	private static int CFU_INIZIALI = 20;
	
	
	/**
	 * inizializza una borsa e i CFU*/
	public Giocatore() {
		// TODO Auto-generated constructor stub
		this.cfu=CFU_INIZIALI;
		this.borsa=new Borsa();
		
	}

	/**
	 * Setter e Getter dei parametri
	 * */
	public int getCfu() {
		return this.cfu;
	}
	public Borsa getBorsa(){
		return this.borsa;
	}

	/**
	 * setBorsa() permette di cambiare la Borsa
	 * @param Borsa
	 * @see Borsa*/
	public void setBorsa(Borsa nuova) {
		this.borsa=nuova;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	

}
