package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub

		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Attrezzo daPrendere = stanzaCorrente.getAttrezzo(super.getParametro());
		if (!stanzaCorrente.hasAttrezzo(super.getParametro())) {
			System.out.println("L'attrezzo cercato non e' presente in questa stanza!");
			//System.out.println("Ti trovi in "+partita.getStanzaCorrente().getNome());
		}
		else if (partita.getGiocatore().getBorsa().getPeso() + daPrendere.getPeso() > partita.getGiocatore().getBorsa().getPesoMax()) {
			System.out.println("Non c'e' abbastanza spazio nella borsa per questo attrezzo!");
			//System.out.println("Ti trovi in "+partita.getStanzaCorrente().getNome());
		}
		else {
			stanzaCorrente.removeAttrezzo(daPrendere);
			partita.getGiocatore().getBorsa().addAttrezzo(daPrendere);
			System.out.println("Attrezzo preso.");
			//System.out.println(partita.getStanzaCorrente().getDescrizione());
		}
	}
	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "prendi";
	}

}
