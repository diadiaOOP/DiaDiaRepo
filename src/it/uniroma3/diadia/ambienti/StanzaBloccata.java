/**
 * 
 */
package it.uniroma3.diadia.ambienti;

/**
 * @author Andrea Menichelli & Alessio Piccione
 *
 */
public class StanzaBloccata extends Stanza {

	/**
	 * @param nome
	 */
	private String direzioneBloccata, chiave;

	public StanzaBloccata(String nome, String direzioneBloccata, String chiave) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.chiave=chiave;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Stanza getStanzaAdiacente (String direzione){
		if (direzione.equals(this.direzioneBloccata) && !this.hasAttrezzo(chiave)){
			System.out.println("questa non è la direzione che stai cercando");
			return this;
		}
		else
			return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione (){
		return super.toString()+"\nNon puoi andare a "+this.direzioneBloccata+" perché la diritta via è smarrita.\nPotrebbe esserti utile: \t"+chiave;
	}
}
