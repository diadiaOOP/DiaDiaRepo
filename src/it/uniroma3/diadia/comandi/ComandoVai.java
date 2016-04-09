package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {

	public String direzione;

	public ComandoVai(String direzione){
		this.direzione=direzione;
	}

	public void esegui(Partita partita) {
		Stanza corrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null){
			System.out.println("Direzione inesistente");
			return;
		}

		partita.setStanzaCorrente(prossimaStanza);
		int cfu = partita.getGiocatore().getCfu();
		partita.getGiocatore().setCfu(cfu--);

		System.out.println(partita.getStanzaCorrente().getDescrizione());
	}



	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.direzione=parametro;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.direzione;
	}
}
