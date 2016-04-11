package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		System.out.println(partita.getStanzaCorrente().getDescrizione());
		System.out.println("Cfu disponibili: "+partita.getGiocatore().getCfu());
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "guarda";
	}


}
