package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {

	final static private int SOGLIA_MAGICA_DEFAULT = 2;
	private int contatoreAttrezziPosati ;
	private int sogliaMagica;

	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
		// TODO Auto-generated constructor stub
	}

	public StanzaMagica(String nome, int soglia) {
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
				this.numeroAttrezzi++;
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
		if (this.contatoreAttrezziPosati==SOGLIA_MAGICA_DEFAULT){
			modificaAttrezzo(attrezzo);
			System.out.println("prova a prendere l'oggetto ahahahaha muori :)))");
		}
	}
}
