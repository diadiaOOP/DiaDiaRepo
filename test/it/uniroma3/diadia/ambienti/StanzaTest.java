package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {

	private Stanza bar, mensa, vuota, isNull;
	private Attrezzo tazzina, vassoio, piatto;
	private Attrezzo[] array, array_1;
	
	@Before
	public void setUp() {
		this.bar = new Stanza("bar");
		this.mensa = new Stanza("mensa");
		this.vuota = new Stanza("vuota");
		this.isNull = null;
		this.tazzina = new Attrezzo("tazzina", 1);
		this.vassoio = new Attrezzo("vassoio", 3);
		this.piatto = new Attrezzo("piatto", 1);
		this.bar.impostaStanzaAdiacente("nord", mensa);
		this.mensa.impostaStanzaAdiacente("sud", bar);
		this.bar.addAttrezzo(tazzina);
		this.mensa.addAttrezzo(vassoio);
		this.mensa.addAttrezzo(piatto);
		this.array = new Attrezzo[10];
		this.array_1 = new Attrezzo[10];
		this.array_1[0] = tazzina;
	}
	/*********************************************GetStanzaAdiacente**************************************************************/

	@Test	
	public void testGetStanzaAdiacente_Bar_Nord() {
		assertEquals(mensa, this.bar.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacente_Mensa_Sud() {
		assertEquals(bar, this.mensa.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetStanzaAdiacente_Mensa_Ovest() {
		assertNull(this.mensa.getStanzaAdiacente("ovest"));
	}
	/*********************************************attrezziToString**************************************************************/
	
	@Test
	public void testAttrezziToString_Bar(){
		assertEquals("tazzina (1 kg) ", this.bar.attrezziToString());
	}
	
	@Test
	public void testAttrezziToString_Mensa(){
		assertEquals("vassoio (3 kg) piatto (1 kg) ", this.mensa.attrezziToString());
	}
	
	@Test
	public void testAttrezziToString_Vuota(){
		assertEquals("", this.vuota.attrezziToString());
	}
	/*********************************************GetNumeroAttrezzi**************************************************************/
	
	@Test
	public void testGetNumeroAttrezzi_Vuota() {
		assertEquals(0, this.vuota.getNumeroAttrezzi());
	}
	/*********************************************getAttrezzi**************************************************************/
	
	@Test(expected=NullPointerException.class)
	public void testGetAttrezzi_Null() {
		assertNull(this.isNull.getAttrezzi());
	}
	
	@Test
	public void testGetAttrezzi_Vuota() {
		assertArrayEquals(this.array, this.vuota.getAttrezzi());
	}
	
	@Test
	public void testGetAttrezzi_Bar() {
		assertArrayEquals(this.array_1, this.bar.getAttrezzi());
	}
/*********************************************addAttrezzo**************************************************************/
	@Test (expected= NullPointerException.class)

	public void testAddAttrezzo_StanzaIsNull (){
		assertNull(this.isNull.addAttrezzo(piatto));

	}

}