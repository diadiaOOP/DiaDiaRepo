package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {

	private Stanza bar, mensa, vuota;
	private Attrezzo tazzina, vassoio, piatto;
	
	@Before
	public void setUp() {
		bar = new Stanza("bar");
		mensa = new Stanza("mensa");
		vuota = new Stanza("vuota");
		tazzina = new Attrezzo("tazzina", 1);
		vassoio = new Attrezzo("vassoio", 3);
		piatto = new Attrezzo("piatto", 1);
		bar.impostaStanzaAdiacente("nord", mensa);
		mensa.impostaStanzaAdiacente("sud", bar);
		bar.addAttrezzo(tazzina);
		mensa.addAttrezzo(vassoio);
		mensa.addAttrezzo(piatto);
	}

	@Test	
	public void testGetStanzaAdiacenteBarNord() {
		assertEquals(mensa, bar.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteMensaSud() {
		assertEquals(bar, mensa.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetStanzaAdiacenteMensaOvest() {
		assertNull(mensa.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testAttrezziToStringBar(){
		assertEquals("tazzina (1 kg) ", bar.attrezziToString());
	}
	
	@Test
	public void testAttrezziToStringMensa(){
		assertEquals("vassoio (3 kg) piatto (1 kg) ", mensa.attrezziToString());
	}
	
	@Test
	public void testAttrezziToStringVuota(){
		assertEquals("", vuota.attrezziToString());
	}

}