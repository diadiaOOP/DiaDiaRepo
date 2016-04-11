package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {

	public String direzione;


	public void esegui(Partita partita) {
		Stanza prossimaStanza = null;
		if(direzione==null)
			System.out.println("Dove vuoi andare?");
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null){
			System.out.println("Direzione inesistente");
			return;
		}

		partita.setStanzaCorrente(prossimaStanza);
		partita.getGiocatore().consumeCfu();

		System.out.println("Sei in: "+partita.getStanzaCorrente().getNome());
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



	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "vai";
	}

	
}
