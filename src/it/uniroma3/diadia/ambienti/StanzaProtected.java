package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaProtected {
	protected static final int NUMERO_MASSIMO_DIREZIONI = 4;
	protected static final int NUMERO_MASSIMO_ATTREZZI = 10;
	protected String nome;
	protected Attrezzo[] attrezzi;
	protected int numeroAttrezzi;
	protected StanzaProtected[] stanzeAdiacenti;
	protected int numeroStanzeAdiacenti;
	protected String[] direzioni;
	
	public StanzaProtected(String nome) {
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
		this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
		this.stanzeAdiacenti = new StanzaProtected[NUMERO_MASSIMO_DIREZIONI];
		this.attrezzi = new Attrezzo[getNumeroMassimoAttrezzi()];
	}
	


	public void impostaStanzaAdiacente(String direzione, StanzaProtected stanza) {
		boolean aggiornato = false;
		for(int i=0; i<this.direzioni.length; i++)
			if (direzione.equals(this.direzioni[i])) {
				this.stanzeAdiacenti[i] = stanza;
				aggiornato = true;
			}
		if (!aggiornato)
			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.direzioni[numeroStanzeAdiacenti] = direzione;
				this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
				this.numeroStanzeAdiacenti++;
			}
	}
	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public StanzaProtected getStanzaAdiacente(String direzione) {
		StanzaProtected stanza = null;
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
			if (this.direzioni[i].equals(direzione))
				stanza = this.stanzeAdiacenti[i];
		return stanza;
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return "Ti trovi in " + this.toString();
	}

	public String attrezziToString(){
    	String s="";
    	for (Attrezzo attrezzo : this.attrezzi) {
    		if(attrezzo!=null)
    			s += attrezzo.toString()+" ";
    	}
    	return s;
    }
	
	public int getNumeroAttrezzi() {
		return this.numeroAttrezzi;
	}
	
	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Attrezzo[] getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo!=null){
			if (this.numeroAttrezzi < getNumeroMassimoAttrezzi()) {
				this.attrezzi[numeroAttrezzi] = attrezzo;
				this.numeroAttrezzi++;
				return true;
			}
			else{
				return false;

			}
		}
		else return false;
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		String s = new String();
		s += this.nome;
		s += "\nUscite: ";
		for (String direzione : this.direzioni)
			if (direzione!=null)
				s += " " + direzione;
		s += "\nAttrezzi nella stanza: ";
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo!=null)
				s += attrezzo.toString()+" ";
		}
		return s;
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo!=null) {
				if (attrezzo.getNome().equals(nomeAttrezzo))
					trovato = true;
			}
		}
		return trovato;
	}
	
	public boolean isEmpty() {
		return (numeroAttrezzi == 0);
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo!=null) {
				if (attrezzo.getNome().equals(nomeAttrezzo))
					attrezzoCercato = attrezzo;
			}
		}
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if (this.numeroAttrezzi==0||(!this.hasAttrezzo(attrezzo.getNome())))
			return false;
		else {
			for (int i=0; i<numeroAttrezzi; i++) {
				if (this.attrezzi[i].equals(attrezzo)); {
					this.attrezzi[i] = null;
					this.numeroAttrezzi--;
				}
			}
		}
		return true;
	}

	/**
	 * Restituisce le possibili direzioni della stanza.
	 * @return direzioni della stanza
	 */
	public String[] getDirezioni() {
		String[] direzioni = new String[this.numeroStanzeAdiacenti];
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
			direzioni[i] = this.direzioni[i];
		return direzioni;
	}
	
	public void setNumeroAttrezzi(int nuovoNum){
		 this.numeroAttrezzi=nuovoNum;
	}

	public int getNumeroMassimoAttrezzi() {
		return NUMERO_MASSIMO_ATTREZZI;
	}
	
}
