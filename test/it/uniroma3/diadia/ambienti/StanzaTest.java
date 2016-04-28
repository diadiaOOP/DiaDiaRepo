package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {

	private static final String NOME_TAZZINA = "tazzina";
	private Stanza bar, mensa, vuota, isNull, piena, stanzaAttrezzoNull;
	private Attrezzo tazzina, vassoio, piatto, attrezzoNull;
	//private Attrezzo[] array, array_1;
	private ArrayList<Attrezzo> array, array_1;
	@Before
	public void setUp() {
		this.bar = new Stanza("bar");
		this.mensa = new Stanza("mensa");
		this.vuota = new Stanza("vuota");
		this.piena = new Stanza("piena");  
		this.stanzaAttrezzoNull = new Stanza("stanzaAttrezzoNull");
		this.isNull = null;
		this.attrezzoNull = null;
		this.tazzina = new Attrezzo(NOME_TAZZINA, 1);
		this.vassoio = new Attrezzo("vassoio", 3);
		this.piatto = new Attrezzo("piatto", 1);
		this.bar.impostaStanzaAdiacente("nord", mensa);
		this.mensa.impostaStanzaAdiacente("sud", bar);
		this.bar.addAttrezzo(tazzina);
		this.mensa.addAttrezzo(vassoio);
		this.mensa.addAttrezzo(piatto);
		this.piena.setNumeroAttrezzi(10);
		this.stanzaAttrezzoNull.addAttrezzo(attrezzoNull);
		//this.array = new Attrezzo[10];
		//this.array_1 = new Attrezzo[10];
		//this.array_1[0] = tazzina;
		array = new ArrayList();
		array_1 = new ArrayList();
		this.array_1.add(tazzina);
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
		assertNull(this.isNull.getAttrezzi());
	}
	
	@Test
	public void testGetAttrezzi_Vuota() {
		assertEquals(this.array, this.vuota.getAttrezzi());
	}
	
	@Test
	public void testGetAttrezzi_Bar() {
		assertEquals(this.array_1, this.bar.getAttrezzi());
	}

	/*********************************************addAttrezzo**************************************************************/
	@Test (expected= NullPointerException.class)

	public void testAddAttrezzo_StanzaIsNull (){
		assertNull(this.isNull.addAttrezzo(this.piatto));

	}
	
	@Test /*(expected= NullPointerException.class)*/
	public void testAddAttrezzo_AttrezzoNull (){
		assertFalse(this.bar.addAttrezzo(this.attrezzoNull));
	}
	
	@Test
	public void testAddAttrezzo_AttrezzoNotNull (){
		assertTrue(this.bar.addAttrezzo(this.tazzina));
	}
	
	


/*********************************************hasAttrezzo**************************************************************/

	@Test(expected = NullPointerException.class)
	public void testHasAttrezzo_Null() {
		assertTrue(this.isNull.hasAttrezzo("piatto"));
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
		assertEquals(this.piatto, this.isNull.getAttrezzo("piatto"));
	}
	
	@Test
	public void testGetAttrezzo_StanzaVuota() {
		assertNull(this.vuota.getAttrezzo("piatto"));
	}
	
	@Test
	public void testGetAttrezzo_AttrezzoNull() {
		assertEquals(null, this.stanzaAttrezzoNull.getAttrezzo("attrezzoNull"));
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
		assertEquals(this.tazzina, this.isNull.removeAttrezzo(this.tazzina));
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
		assertFalse(tazzinaDuplicata==this.tazzina);
		assertEquals(this.tazzina.getNome(), tazzinaDuplicata.getNome());
		assertTrue(this.bar.removeAttrezzo(tazzinaDuplicata));
		
	}
}