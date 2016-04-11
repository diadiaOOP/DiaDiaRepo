package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	public String nomeAttrezzo;
	

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub

		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Attrezzo daPrendere = stanzaCorrente.getAttrezzo(nomeAttrezzo);
		if (!stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
			System.out.println("L'attrezzo cercato non è presente in questa stanza!");
			//System.out.println("Ti trovi in "+partita.getStanzaCorrente().getNome());
		}
		else if (!partita.getGiocatore().getBorsa().addAttrezzo(daPrendere)) {
			System.out.println("Non c'è abbastanza spazio nella borsa per questo attrezzo!");
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
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo = parametro;

	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeAttrezzo;
	}


	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "prendi";
	}

}
