/**
 * 
 */
package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * @author Andrea Menichelli & Alessio Piccione
 *
 */
public class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaNord, stanzaSud;
	private Attrezzo chiave, inutile;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		chiave = new Attrezzo("chiave", 1);
		stanzaBloccata = new StanzaBloccata("stanza bloccata", "nord", "chiave");
		stanzaBloccata.impostaStanzaAdiacente("nord", stanzaNord);
		stanzaBloccata.impostaStanzaAdiacente("sud", stanzaSud);
	}

	/**
	 * Test method for {@link it.uniroma3.diadia.ambienti.StanzaBloccata#getStanzaAdiacente(java.lang.String)}.
	 */
	@Test
	public void testGetStanzaAdiacente_senzaChiave() {
		assertEquals(this.stanzaBloccata, stanzaBloccata.getStanzaAdiacente("nord"));
	}
	@Test
	public void testGetStanzaAdiacente_conChiave() {
		stanzaBloccata.addAttrezzo(chiave);
		assertEquals(stanzaNord, stanzaBloccata.getStanzaAdiacente("nord"));
	}

	@Test
	public void testGetStanzaAdiacente_NonBloccata() {
		assertEquals(stanzaSud, stanzaBloccata.getStanzaAdiacente("sud"));
	}

	@Test
	public void testGetStanzaAdiacente_conInutile() {
		stanzaBloccata.addAttrezzo(inutile);
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("nord"));
	}

}
