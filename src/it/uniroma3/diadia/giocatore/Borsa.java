package it.uniroma3.diadia.giocatore;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	
	private Map <String,Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap();
		}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo !=null){
			if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
				return false;
		
			this.attrezzi.put(attrezzo.getNome(),attrezzo );
			
			return true;
		}
		else return false;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.attrezzi.size(); i++)
			peso += this.attrezzi.get(i).getPeso();
		return peso;
	}
	
	
	
	public int getNumeroAttrezzi (){
		return this.attrezzi.size();
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.remove(nomeAttrezzo);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.attrezzi.size(); i++)
				s.append(attrezzi.get(i).toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}
