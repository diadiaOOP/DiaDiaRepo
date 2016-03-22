package it.uniroma3.diadia.giocatore;

public class Giocatore {
	private int cfu;
	private static int MAX_CFU = 20;
	private Borsa borsa;

	public Giocatore(){
		this.cfu = MAX_CFU;
		this.borsa = new Borsa();
	}

	public void setCfu(int cfu){
		this.cfu = cfu;
	}

	public int getCfu(){
		return this.cfu;
	}

	public Borsa getBorsa(){
		return this.borsa;
	}
}