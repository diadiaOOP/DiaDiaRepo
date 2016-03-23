/*Sono stati scritti i test che controllano Partita nel suo stato iniziale 
 * in quanto i test non controllano il comportamento dei metodi 
 * della classe Partita mentre DiaDia è in esecuzione, bensì servono per correggere
 * eventuali errori commessi durante la correzione e scrittura di codice */



package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PartitaTest {

	private Partita partita;
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
	}

	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", this.partita.getStanzaCorrente().getNome());
	}

	@Test
	public void testGetGiocatore_NotNull() {
		assertNotNull(this.partita.getGiocatore());
	}
	
	/*@Test
	public void testGetLabirinto() {
		
	}*/
	
	@Test
	public void testVinta() {
		assertFalse(this.partita.vinta());
	}

	@Test
	public void testIsFinita() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
}
