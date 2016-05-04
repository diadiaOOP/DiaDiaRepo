package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private HashMap<String,Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoAttualeBorsa;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>(); // speriamo che bastino...
		this.numeroAttrezzi = attrezzi.size();
		this.setPesoAttualeBorsa(0);
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo !=null &&
				this.getPesoAttualeBorsa() + attrezzo.getPeso() > this.getPesoMax())
			return false;

		this.attrezzi.put( attrezzo.getNome(), attrezzo);
		this.pesoAttualeBorsa+=attrezzo.getPeso();
		return true; 

	}

	public int getPesoMax() {
		return this.pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {

		return attrezzi.get(nomeAttrezzo);
	}


	public void setNumeroAttrezzi (int num){
		this.numeroAttrezzi=num;
	}

	public int getNumeroAttrezzi (){
		return this.numeroAttrezzi;
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		if (this.isEmpty()) return null;
		Attrezzo a = null;
		Iterator<Entry<String, Attrezzo>> iteratore =this.attrezzi.entrySet().iterator();

		while (iteratore.hasNext()) {
			a = (Attrezzo) iteratore.next();
			if (a.getNome().equals(nomeAttrezzo)) {
				iteratore.remove();
				return a;
			}
		}
		return a;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPesoMax()+"kg/"+this.getPesoMax()+"kg): ");
			for ( String key : attrezzi.keySet() )
				s.append(key.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

	public void setPesoAttualeBorsa (int p){
		this.pesoAttualeBorsa=p;
	}
	public int getPesoAttualeBorsa (){
		int pesoTot=0;
		Iterator<Entry<String, Attrezzo>> iteratore = this.attrezzi.entrySet().iterator();
		while (iteratore.hasNext()){
			Attrezzo a = (Attrezzo) iteratore.next();
			pesoTot+=a.getPeso();
		}
		return pesoTot;

	}
}
