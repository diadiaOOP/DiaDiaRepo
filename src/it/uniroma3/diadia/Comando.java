package it.uniroma3.diadia;

import java.util.Scanner;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes) *
 * @version 0.1
 */

public class Comando {
	private String nome;
	private String parametro;
	private Scanner scannerDiParole;


	public Comando(String istruzioneSuInteraRiga) {
		scannerDiParole = new Scanner(istruzioneSuInteraRiga);

		// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			this.nome = scannerDiParole.next(); 

		// seconda parola: eventuale parametro
		if (scannerDiParole.hasNext())
			this.parametro = scannerDiParole.next();
	}

	public String getNome() {
		return this.nome;
	}

	public String getParametro() {
		return this.parametro;
	}

	public boolean sconosciuto() {
		return (this.nome == null);
	}
}