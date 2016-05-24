package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {

	public void esegui(Partita partita) {
		Stanza prossimaStanza = null;
		if(super.getParametro()==null) {
			System.out.println("Dove vuoi andare?");
			return;
		}
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(super.getParametro());
		if (prossimaStanza == null){
			System.out.println("Direzione inesistente");
			return;
		}

		partita.setStanzaCorrente(prossimaStanza);
		partita.getGiocatore().consumeCfu();

		System.out.println("Sei in: "+partita.getStanzaCorrente().getNome());
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "vai";
	}
	
}
