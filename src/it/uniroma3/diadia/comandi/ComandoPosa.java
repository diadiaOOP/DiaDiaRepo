package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {
	
	private String nomeAttrezzo;
	

	@Override
	public void esegui(Partita partita) {
		Borsa borsaDelGiocatore = partita.getGiocatore().getBorsa();
		if (!borsaDelGiocatore.hasAttrezzo(nomeAttrezzo)) {
			System.out.println("Non possiedi questo attrezzo!");
			//System.out.println("Ti trovi in "+partita.getStanzaCorrente().getNome());
		}
		else {
			Attrezzo daPosare =  borsaDelGiocatore.getAttrezzo(nomeAttrezzo);
			partita.getStanzaCorrente().addAttrezzo(daPosare);
			System.out.println("Attrezzo posato.");
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
		return null;
	}

}
