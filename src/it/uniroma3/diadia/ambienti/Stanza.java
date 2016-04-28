package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
	//private static final int NUMERO_MASSIMO_ATTREZZI = 10;
	private String nome;
	private ArrayList<Attrezzo> attrezziContenuti;
	//private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private Map<String,Stanza> stanzeAdiacenti;
	//private Stanza[] stanzeAdiacenti;
	private int numeroStanzeAdiacenti;
	private String[] direzioni;
	private HashMap uscite;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.uscite = new HashMap<>();
		this.attrezziContenuti = new ArrayList<>();

		this.nome = nome;

	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione,
			Stanza stanzaAdiacente) {
		this.stanzeAdiacenti.put(direzione,stanzaAdiacente);
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
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
		for (Attrezzo attrezzo : this.attrezziContenuti) {
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
	public ArrayList<Attrezzo> getAttrezzi() {
		return this.attrezziContenuti;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo!=null){

			this.attrezziContenuti.add(attrezzo);
			this.numeroAttrezzi++;
			return true;
		}
		else{
			return false;

		}
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
		for (Attrezzo attrezzo : this.attrezziContenuti) {
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
		for (Attrezzo attrezzo : this.attrezziContenuti) {
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
		for (Attrezzo attrezzo : this.attrezziContenuti) {
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
				if (this.attrezziContenuti.equals(attrezzo)); {
					this.attrezziContenuti.remove(i);
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



}