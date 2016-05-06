/**
 * 
 */
package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * @author Andrea Menichelli & Alessio Piccione
 *
 */
public class BorsaTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	Borsa daTestare, borsaVariAttrezzi, borsaNull, borsaVuota;
	Attrezzo attrezzoNull, tazzina, piuma, libro, ps, piombo, balena;
	
	@Before
	public void setUp() throws Exception {
		
		this.borsaVuota = new Borsa(0);
		this.daTestare = new Borsa ();
		this.borsaNull = null;
		this.borsaVariAttrezzi = new Borsa();
		
		this.attrezzoNull=null;
		this.tazzina = new Attrezzo("tazzina", 3);
		this.piuma = new Attrezzo("piuma", 1);
		this.libro = new Attrezzo("libro", 5);
		this.ps = new Attrezzo("ps", 5);
		this.piombo = new Attrezzo("piombo", 10);
		this.balena = new Attrezzo("balena", 10000);
		
		this.daTestare.addAttrezzo(tazzina);
		this.borsaVariAttrezzi.addAttrezzo(piuma);
		this.borsaVariAttrezzi.addAttrezzo(libro);
		this.borsaVariAttrezzi.addAttrezzo(ps);
		this.borsaVariAttrezzi.addAttrezzo(piombo);
	}
/***************************************addAttrezzo***********************************************/
	@Test (expected=NullPointerException.class)
	public void testAddAttrezzo_BorsaNull() {
		assertFalse(borsaNull.addAttrezzo(tazzina));
	}
	
	@Test //(expected=NullPointerException.class)
	public void testAddAttrezzo_AttrezzoNull(){
		assertFalse (daTestare.addAttrezzo(attrezzoNull));
	}
	
	@Test 
	public void testAddAttrezzo_PesoEccessivo (){
		assertFalse(daTestare.addAttrezzo(balena));
	}
/***************************************getAttrezzo***********************************************/
	@Test (expected=NullPointerException.class)
	public void testGetAttrezzo_BorsaNull() {
		assertNull(borsaNull.getAttrezzo("tazzina"));
	}
	
	@Test 
	public void testGetAttrezzo_AttrezzoNull(){
		assertNull(daTestare.getAttrezzo(""));
	}
	
	@Test 
	public void testGetAttrezzo_AttrezzoNotNull(){
		assertEquals(this.tazzina, daTestare.getAttrezzo("tazzina"));
	}

/****************************************************************************************************/
	
	@Test
	public void testGetContenuto_InMappa_PerPeso() {
		String msg = "(1, { piuma } ) ; (5, { libro, ps } ) ; (10, { piombo } )";
		//assertEquals(msg, this.borsaVariAttrezzi.getContenutoRaggruppatoPerPeso().toString());
	}
	
	
	
	
/***************************isEmpty*********************************************************************/	
	@Test (expected=NullPointerException.class)
	public void testIsEmpty_BorsaNull() {
		assertFalse(borsaNull.isEmpty());
	}
	
	@Test
	public void testIsntEmpty (){
		assertFalse(daTestare.isEmpty());
	}
	@Test
	public void testIsEmpty (){
		assertTrue(borsaVuota.isEmpty());
	}

/****************************hasAttrezzo**************************************************************************/
	@Test (expected=NullPointerException.class)
	public void testHasAttrezzo_BorsaNull() {
		assertFalse(borsaNull.hasAttrezzo(""));
	}
	
	@Test //(expected=NullPointerException.class)
	public void testHasAttrezzo_AttrezzoNull() {
		assertFalse(daTestare.hasAttrezzo(""));
	}
/****************************removeAttrezzo***************************************************/
	
	@Test (expected=NullPointerException.class)
	public void testRemoveAttrezzo_BorsaNull(){
		assertNull(borsaNull.removeAttrezzo("tazzina"));
	}
	
	@Test 
	public void testRemoveAttrezzo_AttrezzoNull(){
		assertNull(daTestare.getAttrezzo(""));
	}

}
