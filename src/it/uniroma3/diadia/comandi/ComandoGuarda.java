package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		if (this.getParametro() != null) {
			if (this.getParametro().equals("borsa"))
				System.out.println(partita.getGiocatore().getBorsa().toString());
			else if (this.getParametro().equals("stanza"))
				System.out.println(partita.getStanzaCorrente().toString());
			else if (this.getParametro().equals("cfu"))
				System.out.println("Ti rimangono " + partita.getGiocatore().getCfu() + " cfu");
			else System.out.println("\"" + super.getParametro() + "\" non è un parametro valido");
		} else System.out.println("Cosa vuoi guardare? Specificare un parametro!"); 
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "guarda";
	}


}
