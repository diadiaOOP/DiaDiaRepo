package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		System.out.println("Comando non valido");
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "non valido";
	}


}
