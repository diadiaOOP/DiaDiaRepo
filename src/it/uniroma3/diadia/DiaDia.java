package it.uniroma3.diadia;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;
import java.util.Scanner;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 *  Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 *  Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 *  Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes) *
 * @version 0.1
 */

public class DiaDia {
	private Partita partita;
    private static final String MESSAGGIO_BENVENUTO = 
		"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
		"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
		"I locali sono popolati da strani personaggi, " +
		"alcuni amici, altri... chissa!\n"+
		"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
		"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
		"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
		"Per conoscere le istruzioni usa il comando 'aiuto'.";
   
    private static String[] elencoComandi = {"vai", "aiuto", "prendi", "posa", "fine"};

    public DiaDia() {
    	this.partita = new Partita();
    }

	public void gioca() {
		String istruzione; 
	    Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
	    scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
	}   
    
        
	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			System.out.println("Comando sconosciuto");
		if (this.partita.vinta()) {
			System.out.println("Hai vinto!");
			return true;
		} else
			return false;
	}   
    
    // implementazioni dei comandi dell'utente:

	/**
	 * prende un attrezzo dalla stanza e lo aggiunge nella borsa
	 * @param nome dell'Attrezzo da prendere
	 */
	private void prendi(String nomeAttrezzo){
		Stanza currentStanza = this.partita.getStanzaCorrente();
		Borsa borsa = this.partita.getGiocatore().getBorsa();
		Attrezzo daPrendere = currentStanza.getAttrezzo(nomeAttrezzo);
		if(daPrendere != null){
			if(borsa.addAttrezzo(daPrendere)){
				currentStanza.removeAttrezzo(nomeAttrezzo);
				System.out.println("L'attrezzo " + nomeAttrezzo +" si trova nella borsa");
			}
			else
				System.out.println("Non c'è abbastanza spazio per questo attrezzo!");
		}
		else
			System.out.println("Non esiste nessun attrezzo " + nomeAttrezzo + " in questa stanza!");	
	}
	
	/*private void posa(String parametro) {
		
	}*/
	
	private void posa(String attrezzo){
    	Stanza currentStanza = this.partita.getStanzaCorrente();
    	Borsa marsupio = this.partita.getGiocatore().getBorsa();
    	Attrezzo daPosare = marsupio.getAttrezzo(attrezzo);
    	if(daPosare != null){
    		currentStanza.addAttrezzo(daPosare);
    		marsupio.removeAttrezzo(attrezzo);
    		System.out.println("L'attrezzo " + attrezzo + " è nella stanza");
    	}else{
    		System.out.println("Non c'è l'attrezzo " + attrezzo + " nella tua borsa!");
    	}
    }
	
    /**
     * Stampa informazioni di aiuto.
     */
    private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	    }

    /**
     * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
     * e ne stampa il nome, altrimenti stampa un messaggio di errore
     */
	 private void vai(String direzione) {
		 Stanza prossimaStanza = null;
		 prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		 if(direzione==null)
			 System.out.println("Dove vuoi andare ?");
		 else if (prossimaStanza == null)
			 System.out.println("Direzione inesistente");
		 else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getCfu();
			this.partita.setCfu(cfu--);
		 }
		System.out.println(partita.getStanzaCorrente().getDescrizione());
	 }

    /**
     * Comando "Fine".
     */
    private void fine() {
    	System.out.println("Grazie di aver giocato!");  // si desidera smettere
    }

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}