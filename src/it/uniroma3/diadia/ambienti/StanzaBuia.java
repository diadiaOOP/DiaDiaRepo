package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	private String fonteDiLuce;

	public StanzaBuia(String nome, String fonteDiLuce) {
		super(nome);
		this.fonteDiLuce = fonteDiLuce;
	}

	@Override
	public String getDescrizione() {
		if (super.hasAttrezzo(fonteDiLuce))
			return super.getDescrizione();
		else
			return "Qui c'è buio pesto.";
	}


}