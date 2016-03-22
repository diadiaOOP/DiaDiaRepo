package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  Paolo Merialdo, Valter Crescenzi (da un'idea di Michael Kolling and David J. Barnes)
 * @see Stanza
 * @see Labirinto
 * @version 0.1
 */

public class Partita {
	private Stanza stanzaCorrente;
	//private Stanza stanzaVincente;
	private Labirinto facolta;
	private boolean finita;
	public Giocatore studente;

	
	public Partita(){
		this.facolta = new Labirinto();
		this.finita = false;
		this.stanzaCorrente=this.facolta.getIngresso();
		this.studente = new Giocatore();
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()==this.facolta.getUscita();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.studente.getCfu() == 0);
	}

	/**
	 * setFinita() imposta lo stato della partita come partita finita
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public Labirinto getLabirinto(){
		return this.facolta;
	}	
	
	public Giocatore getGiocatore(){
		return this.studente;
	}
	public int getCfu() {
		return this.studente.getCfu();
	}
	
	public void setCfu(int cfu) {
		this.studente.setCfu(cfu);
	}
}