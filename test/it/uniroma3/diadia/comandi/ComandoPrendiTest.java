/**
 * 
 */
package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.*;

/**
 * @author andrea
 *
 */
public class ComandoPrendiTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	private Partita partita;
	private Attrezzo daPrendere;
	private Stanza stanzaTest;
	private Comando prendiTest;
	private Borsa borsaTest;
	
	@Before
	public void setUp() throws Exception {
		partita = new Partita();
		stanzaTest = new Stanza("ho le mie cose");
		partita.setStanzaCorrente(stanzaTest);
		prendiTest= new ComandoPrendi();
		borsaTest = partita.getGiocatore().getBorsa();
		
	}

	/**
	 * Test method for {@link it.uniroma3.diadia.comandi.ComandoPrendi#esegui(it.uniroma3.diadia.Partita)}.
	 */
	
				

	 
	@Test 
	public void testEsegui_Null() {
		stanzaTest.addAttrezzo(null);
		prendiTest.setParametro("");
		prendiTest.esegui(partita);
		assertFalse(borsaTest.hasAttrezzo(""));			
	}

	@Test 
	public void testEsegui_DueVolteUnAttrezzo() {
		daPrendere = new Attrezzo ("prendimi",5);
		stanzaTest.addAttrezzo(daPrendere);
		prendiTest.setParametro("prendimi");
		prendiTest.esegui(partita);
		assertTrue(borsaTest.hasAttrezzo("prendimi"));	
		prendiTest.esegui(partita);
		assertNotEquals(1,borsaTest.getNumeroAttrezzi());
}
	
	@Test 
	public void testEsegui_DueVolteDueAttrezzi() {
		daPrendere = new Attrezzo ("prendimi",5);
		stanzaTest.addAttrezzo(daPrendere);
		stanzaTest.addAttrezzo(daPrendere);
		prendiTest.setParametro("prendimi");
		prendiTest.esegui(partita);
		assertTrue(borsaTest.hasAttrezzo("prendimi"));	
		prendiTest.esegui(partita);
		assertEquals(2,borsaTest.getNumeroAttrezzi());
}
	
	@Test
	public void testEsegui_ZeroOggetti(){
		prendiTest.setParametro("notHere");
		prendiTest.esegui(partita);
		assertFalse(borsaTest.hasAttrezzo("notHere"));		
	}
	

	/**
	 * Test method for {@link it.uniroma3.diadia.comandi.ComandoPrendi#getNome()}.
	 */
	@Test
	public void testGetNome() {
		fail("Not yet implemented");
	}

}
