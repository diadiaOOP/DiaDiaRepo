package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.*;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {

	private static final String NOME_TAZZINA = "tazzina";
	private Stanza bar, mensa, vuota, stanzaNull;
	private Attrezzo tazzina, vassoio, piatto, attrezzoNull;
	private HashMap<String,Attrezzo> mapVuota, mapBar;
	
	@Before
	public void setUp() {
		this.bar = new Stanza("bar");
		this.mensa = new Stanza("mensa");
		this.vuota = new Stanza("vuota");
		this.stanzaNull = null;
		
		this.attrezzoNull = null;
		this.tazzina = new Attrezzo(NOME_TAZZINA, 1);
		this.vassoio = new Attrezzo("vassoio", 3);
		this.piatto = new Attrezzo("piatto", 1);
		
		this.mapVuota = new HashMap<String,Attrezzo>();
		this.mapBar = new HashMap<String,Attrezzo>();
		
		this.bar.impostaStanzaAdiacente("nord", mensa);
		this.mensa.impostaStanzaAdiacente("sud", bar);
		
		this.bar.addAttrezzo(tazzina);
		this.mensa.addAttrezzo(vassoio);
		this.mensa.addAttrezzo(piatto);
		
		this.mapBar.put("tazzina", this.tazzina);

	}
	/*********************************************getStanzaAdiacente**************************************************************/

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
	
	/*********************************************getAttrezzi**************************************************************/
	
	@Test(expected=NullPointerException.class)
	public void testGetAttrezzi_Null() {
		assertNull(this.stanzaNull.getAttrezzi());
	}
	
	@Test
	public void testGetAttrezzi_Vuota() {
		assertEquals(this.mapVuota, this.vuota.getAttrezzi());
	}
	
	@Test
	public void testGetAttrezzi_Bar() {
		assertEquals(this.mapBar, this.bar.getAttrezzi());
	}

	/*********************************************addAttrezzo**************************************************************/
	@Test (expected= NullPointerException.class)

	public void testAddAttrezzo_StanzaNull (){
		assertNull(this.stanzaNull.addAttrezzo(this.piatto));
	}
	
	@Test 
	public void testAddAttrezzo_AttrezzoNull (){
		assertFalse(this.bar.addAttrezzo(attrezzoNull));
	}

/*********************************************hasAttrezzo**************************************************************/

	@Test(expected = NullPointerException.class)
	public void testHasAttrezzo_Null() {
		assertTrue(this.stanzaNull.hasAttrezzo("piatto"));
	}
	
	@Test
	public void testHasAttrezzo_Vuota() {
		assertFalse(this.vuota.hasAttrezzo("piatto"));
	}
	
	@Test
	public void testHasAttrezzo_Bar_Tazzina() {
		assertTrue(this.bar.hasAttrezzo(NOME_TAZZINA));
	}
	
	@Test
	public void testHasAttrezzo_Bar_Piatto() {
		assertFalse(this.bar.hasAttrezzo("piatto"));
	}
	
/*********************************************getAttrezzo**************************************************************/
	
	@Test(expected = NullPointerException.class)
	public void testGetAttrezzo_StanzaNull() {
		assertEquals(this.piatto, this.stanzaNull.getAttrezzo("piatto"));
	}
	
	@Test
	public void testGetAttrezzo_StanzaVuota() {
		assertNull(this.vuota.getAttrezzo("piatto"));
	}
	
	@Test
	public void testGetAttrezzo_AttrezzoNull() {
		assertEquals(null, this.bar.getAttrezzo("attrezzoNull"));
	}
	
	@Test
	public void testGetAttrezzo_Tazzina_Bar() {
		assertEquals(this.tazzina, this.bar.getAttrezzo(NOME_TAZZINA));
	}
	
	@Test
	public void testGetAttrezzzo_Piatto_Bar() {
		assertNull(this.bar.getAttrezzo("piatto"));
	}
	
/*********************************************removeAttrezzo**************************************************************/
	
	@Test (expected = NullPointerException.class)
	public void testRemoveAttrezzo_StanzaNull (){
		assertEquals(this.tazzina, this.stanzaNull.removeAttrezzo(this.tazzina));
	}
	
	@Test (expected=NullPointerException.class)
	public void testRemoveAttrezzo_AttrezzoNull(){
		assertFalse(this.bar.removeAttrezzo(this.attrezzoNull));
	}
	
	@Test
	public void testRemoveAttrezzo_StanzaVuota(){
		assertFalse(this.vuota.removeAttrezzo(this.vassoio));
	}
	
	@Test
	public void testRemoveAttrezzo_AttrezzoEsistente (){
		assertTrue(this.bar.removeAttrezzo(this.tazzina));
	}
	
	@Test
	public void testRemoveAttrezzo_AttrezzoEsistente_Clone (){
		Attrezzo tazzinaDuplicata = new Attrezzo (NOME_TAZZINA,1);
		assertFalse(tazzinaDuplicata == this.tazzina);
		assertEquals(this.tazzina.getNome(), tazzinaDuplicata.getNome());
		assertTrue(this.bar.removeAttrezzo(tazzinaDuplicata));
		
	}
}