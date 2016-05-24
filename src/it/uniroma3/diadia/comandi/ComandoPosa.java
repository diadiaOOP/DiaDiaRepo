package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa extends AbstractComando {
	
	@Override
	public void esegui(Partita partita) {
		Borsa borsaDelGiocatore = partita.getGiocatore().getBorsa();
		if (!(borsaDelGiocatore.hasAttrezzo(super.getParametro()))) {
			System.out.println("Non possiedi questo attrezzo!");
			//System.out.println("Ti trovi in "+partita.getStanzaCorrente().getNome());
		}
		else {
			Attrezzo daPosare =  borsaDelGiocatore.getAttrezzo(super.getParametro());
			partita.getStanzaCorrente().addAttrezzo(daPosare);
			System.out.println("Attrezzo posato.");
			borsaDelGiocatore.removeAttrezzo(super.getParametro());
			//System.out.println(partita.getStanzaCorrente().getDescrizione());
		}
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "posa";
	}

}
