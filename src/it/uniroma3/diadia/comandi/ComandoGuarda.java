package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	private String msg;
	
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
			else System.out.println("\"" + this.getParametro() + "\" non è un parametro valido");
		} else System.out.println("Cosa vuoi guardare? Specificare un parametro!"); 
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.msg = parametro;

	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.msg;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "guarda";
	}


}
