/**
 * 
 */
package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * @author Andrea Menichelli & Alessio Piccione
 *
 */
public class StanzaMagicaProtected extends StanzaProtected {


	
	final static private int SOGLIA_MAGICA_DEFAULT = 2;
	private int contatoreAttrezziPosati ;
	private int sogliaMagica;


	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
		// TODO Auto-generated constructor stub
	}

	public StanzaMagicaProtected(String nome, int soglia) {
		// TODO Auto-generated constructor stub
		super(nome);
		this. contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo!=null){
			if (super.getNumeroAttrezzi() < getNumeroMassimoAttrezzi()) {
				this.getAttrezzi()[getNumeroAttrezzi()] = attrezzo;
				int numeroAttrezzi = super.getNumeroAttrezzi();
				numeroAttrezzi++;
				super.setNumeroAttrezzi(numeroAttrezzi);
				contaAttrezzi(attrezzo);
				return true;
			}
			else{
				return false;

			}
		}
		else return false;

	}

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso()*2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);
		return attrezzo;
	}
	
	public int contaAttrezzi (Attrezzo attrezzo){
		verificaMagia(attrezzo);
		return ++contatoreAttrezziPosati;
		
	}
	
	public void verificaMagia (Attrezzo attrezzo){
		if (this.contatoreAttrezziPosati>=SOGLIA_MAGICA_DEFAULT){
			modificaAttrezzo(attrezzo);
			System.out.println("prova a prendere l'oggetto ahahahaha muori :)))");
		}
	}
	

}
