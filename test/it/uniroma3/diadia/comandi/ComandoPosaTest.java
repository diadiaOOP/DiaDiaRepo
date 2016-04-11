/**
 * 
 */
package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Andrea Menichelli & Alessio Piccione
 *
 */
public class ComandoPosaTest {

	private Partita partitaTest;
	private Comando comandoPosaTest;
	private Stanza stanzaTest;
	private Borsa borsaTest;
	
	@Before
	public void setUp() throws Exception {
		
		partitaTest = new Partita();
		comandoPosaTest = new ComandoPosa();
		stanzaTest = new Stanza("Stanza");
		borsaTest = partitaTest.getGiocatore().getBorsa();
		partitaTest.setStanzaCorrente(stanzaTest);
	}
	
	@Test
	public void testPosaAttrezzoNull() {
		comandoPosaTest.setParametro(null);
		comandoPosaTest.esegui(partitaTest);
		assertTrue(stanzaTest.isEmpty());
	}

	@Test
	public void testPosaAttrezzoNonValido() {
		comandoPosaTest.setParametro("Palla");
		comandoPosaTest.esegui(partitaTest);
		assertFalse(stanzaTest.hasAttrezzo("Palla"));
	}
	
	@Test
	public void testPosaAttrezzoValido() {
		borsaTest.addAttrezzo(new Attrezzo("Penna", 1));
		comandoPosaTest.setParametro("Penna");
		comandoPosaTest.esegui(partitaTest);
		assertTrue(stanzaTest.hasAttrezzo("Penna"));
	}
	

	/**
	 * Test method for {@link it.uniroma3.diadia.comandi.ComandoPosa#getNome()}.
	 */
	@Test
	public void testGetNome() {
	}

}
