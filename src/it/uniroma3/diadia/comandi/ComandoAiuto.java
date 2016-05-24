package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		String[] elencoComandi = {"vai", "prendi", "posa", "guarda", "aiuto", "fine"};
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "aiuto";
	}

}
