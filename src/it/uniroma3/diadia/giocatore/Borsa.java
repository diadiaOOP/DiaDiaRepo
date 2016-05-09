package it.uniroma3.diadia.giocatore;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerPeso;

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
		if (attrezzo != null && this.getPesoAttualeBorsa() + attrezzo.getPeso() < this.getPesoMax()){
			this.attrezzi.put(attrezzo.getNome(), attrezzo);
			this.pesoAttualeBorsa+=attrezzo.getPeso();
			return true; 
		}
		return false;
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
		return this.attrezzi.get(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		this.pesoAttualeBorsa-=attrezzi.get(nomeAttrezzo).getPeso();
		return attrezzi.remove(nomeAttrezzo);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPesoAttualeBorsa()+"kg/"+this.getPesoMax()+"kg): ");
			for ( String key : attrezzi.keySet() )
				s.append(key.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		ArrayList<Attrezzo> attrezziOrdinati = new ArrayList<Attrezzo>(attrezzi.values());
		Comparator<Attrezzo> comp = new ComparatorePerPeso();
		Collections.sort(attrezziOrdinati, comp);
		return attrezziOrdinati;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		SortedSet<Attrezzo> attrezziOrdinati = new TreeSet<Attrezzo>(this.attrezzi.values());
		return attrezziOrdinati;
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer, Set<Attrezzo>> mappa = new TreeMap<>();
		Comparator<Attrezzo> comp = new ComparatorePerPeso();
		for (Attrezzo attrezzo : this.attrezzi.values()) {
			if (mappa.containsKey(attrezzo.getPeso()))
				mappa.get(attrezzo.getPeso()).add(attrezzo);
			else {
				Set<Attrezzo> nuovoSet = new TreeSet<>(comp);
				nuovoSet.add(attrezzo);
				mappa.put(attrezzo.getPeso(), nuovoSet);
			}
		}
		return mappa;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		List tmp = new ArrayList<Attrezzo>();
		
		tmp = getContenutoOrdinatoPerPeso();
		SortedSet<Attrezzo> ris = new TreeSet<Attrezzo>(tmp);
		return ris;
	}

	public void setPesoAttualeBorsa (int p){
		this.pesoAttualeBorsa=p;
	}
	public int getPesoAttualeBorsa (){
		return this.pesoAttualeBorsa;
	}
}
