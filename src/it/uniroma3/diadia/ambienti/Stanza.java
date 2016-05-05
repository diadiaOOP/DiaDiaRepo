package it.uniroma3.diadia.ambienti;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * @author Paolo Merialdo (a partire da un'idea di Michael Kolling e David J. Barnes)
 * @see Attrezzo
 * @version 0.1
 */

public class Stanza {
	private static final int NUMERO_MASSIMO_DIREZIONI = 4;
	private String descrizione;
	private HashMap<String,Attrezzo> attrezzi;
	private HashMap<String,Stanza> stanzeAdiacenti;


	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new HashMap<String,Attrezzo>();
		this.descrizione = nome;
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		this.stanzeAdiacenti.put(direzione, stanza);
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

	public Map<String, Stanza> getStanzeAdiacenti() {
		return this.stanzeAdiacenti;
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.descrizione;
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
		ArrayList<Attrezzo> list = new ArrayList<Attrezzo>(attrezzi.values());
		for (Attrezzo attrezzo : list) {
			if(attrezzo!=null)
				s += attrezzo.toString()+" ";
		}
		return s;
	}

	public int getNumeroAttrezzi() {
		return this.attrezzi.size();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Attrezzo[] getAttrezzi() {
		Attrezzo[] risultato= new Attrezzo[this.attrezzi.size()];
		risultato=this.attrezzi.values().toArray(risultato);
		return risultato;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(!this.attrezzi.containsKey(attrezzo.getNome()))
			return this.attrezzi.put(attrezzo.getNome(), attrezzo) == null;
		return false;
	}



	List getContenutoOrdinatoPerPeso(){
		return new List();	
	}
	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(this.getNome());
		s.append("\nUscite: ");
		for (String direzione : this.stanzeAdiacenti.keySet())
			s.append(" " + direzione);
		s.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.attrezzi.values())
			s.append(attrezzo +" ");
		s.append("\nPersonaggi nella stanza: ");

		return s.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	public boolean isEmpty() {
		return (this.attrezzi.isEmpty());
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.remove(attrezzo.getNome())!=null;
	}

	/**
	 * Restituisce le possibili direzioni della stanza.
	 * @return direzioni della stanza
	 */
	public Set<String> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
	}

	/*public void setNumeroAttrezzi(int nuovoNum){
		 this.numeroAttrezzi=nuovoNum;
	}*/



}