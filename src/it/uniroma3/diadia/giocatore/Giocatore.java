package it.uniroma3.diadia.giocatore;

public class Giocatore {
	private int cfu;
	private static int MAX_CFU = 10;
	private Borsa borsa;

	public Giocatore(){
		cfu = MAX_CFU;
		borsa = new Borsa();
	}

	public void setCfu(int cfu){
		this.cfu = cfu;
	}

	public int getCfu(){
		return this.cfu;
	}

	public void addCfu(int a){
		this.cfu+=a;
	}

	public Borsa getBorsa(){
		return this.borsa;
	}
}