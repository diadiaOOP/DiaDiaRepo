package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.*;
import org.junit.Before;
import org.junit.Test;

public class StanzaBuiaTest {
	
	private StanzaBuia stanzaBuia;
	private Attrezzo luce;
	private Attrezzo attrezzoRandom;


	@Before
	public void setUp() {
		stanzaBuia = new StanzaBuia("stanzaTest","lanterna");
		luce = new Attrezzo("lanterna",2);
		attrezzoRandom = new Attrezzo("attrezzo",1);

	}

	@Test
	public void testGetDescrizioneSenzaLuce() {
		assertEquals("Qui c'è buio pesto.",stanzaBuia.getDescrizione());
	}

	@Test
	public void testGetDescrizioneConAltroAttrezzo() {
		stanzaBuia.addAttrezzo(attrezzoRandom);
		assertEquals("Qui c'è buio pesto.",stanzaBuia.getDescrizione());
	}

	@Test
	public void testGetDescrizioneConLuce() {
		stanzaBuia.addAttrezzo(luce);
		assertNotEquals("Qui c'è buio pesto.",stanzaBuia.getDescrizione());
	}

}
