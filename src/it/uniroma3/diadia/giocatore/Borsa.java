package it.uniroma3.diadia.giocatore;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerPeso;

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private HashMap<String,Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int peso;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>();
		this.numeroAttrezzi = this.attrezzi.size();
		//this.setPeso(0);
	}
	
	//modificare if se non funziona
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo != null && this.getPeso() + attrezzo.getPeso() < this.getPesoMax() /*&& !this.attrezzi.containsKey(attrezzo)*/){
			this.attrezzi.put(attrezzo.getNome(), attrezzo);
			this.peso += attrezzo.getPeso();
			return true; 
		}
		return false;
	}

	public int getPesoMax() {
		return this.pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}
	
	public  List<Attrezzo> getAttrezzi() {
		return  new LinkedList<>( this.attrezzi.values());
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
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		this.peso -= this.attrezzi.get(nomeAttrezzo).getPeso();
		return this.attrezzi.remove(nomeAttrezzo);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			Map<Integer,Set<Attrezzo>> mappaAttrezzi = this.getContenutoRaggruppatoPerPeso();
			Set<Integer> a = mappaAttrezzi.keySet();
			for ( Integer  p : a){
				s.append("(");
				s.append(p);
				s.append(", ");
				s.append(mappaAttrezzi.get(p));
				s.append(") ");
			}
		}
		else
			s.append("Borsa vuota");

		return s.toString();
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> attrezziOrdinati = this.getAttrezzi();
		Comparator<Attrezzo> comp = new ComparatorePerPeso();
		Collections.sort(attrezziOrdinati, comp);
		return attrezziOrdinati;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		SortedSet<Attrezzo> attrezziOrdinati = new TreeSet<Attrezzo>(this.attrezzi.values());
		return attrezziOrdinati;
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Set<Attrezzo> tmp;
		Map<Integer,Set<Attrezzo>> mappa = new TreeMap<Integer,Set<Attrezzo>>();
		Set<Attrezzo> a = new TreeSet <> (this.getAttrezzi());
		for(Attrezzo attrezzo : a){
			if(mappa.containsKey(attrezzo.getPeso())){
				tmp = mappa.get(attrezzo.getPeso());
				tmp.add(attrezzo);
			}
			else {
				tmp = new TreeSet<Attrezzo>();
				tmp.add(attrezzo);
				mappa.put(attrezzo.getPeso(), tmp); 
			}
		}
		return mappa;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		List<Attrezzo> tmp = new ArrayList<>();
		tmp = getContenutoOrdinatoPerPeso();
		SortedSet<Attrezzo> ris = new TreeSet<>(tmp);
		return ris;
	}

	public void setPeso(int p){
		this.peso=p;
	}
	public int getPeso(){
		return this.peso;
	}
}
