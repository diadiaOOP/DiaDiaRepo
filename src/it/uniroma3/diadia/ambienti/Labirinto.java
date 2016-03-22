package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * Labirinto: ha la funzione di inizializzare un insieme di stanze collegate di cui una è l'ingresso 
 * del labrinto e un'altra la stanza di uscita del labirinto
 * 
 * @author: Andrea Menichelli & Alessio Piccione
 * @see: Stanza
 * @see: Partita
 * @version: 0.1
 * */
public class Labirinto {
	private Stanza ingresso;
	private Stanza uscita;
	
	/**
	 * Crea un Labirinto
	 * costruttore default richiama init()
	 * 
	 * */
	public Labirinto(){
		init();
	}
	
	/**
	 * init(): inizializza un labirinto base con stanze e oggetti nelle stanze
	 * ingresso: atrio
	 * vittoria: biblioteca
	 * @return: void
	 * */
	private void init() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
        setIngresso(atrio);  
		setUscita(biblioteca);
    }
	
	private void setIngresso(Stanza ingresso){
		this.ingresso=ingresso;
	}
	
	private void setUscita(Stanza uscita){
		this.uscita=uscita;
	}

	public Stanza getIngresso(){
		return ingresso;
	}
	
	public Stanza getUscita(){
		return uscita;
	}
}
