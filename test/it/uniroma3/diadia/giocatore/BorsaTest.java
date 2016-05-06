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
	
	Borsa daTestare, isNull, vuota, ordinataPerPesoSgamata;
	Attrezzo attrezzoNull, tazzina, balena;
	@Before
	public void setUp() throws Exception {
		this.vuota=new Borsa(0);
		this.daTestare = new Borsa ();
		this.isNull = null;
		this.attrezzoNull=null;
		this.tazzina = new Attrezzo("tazzina", 1);
		this.balena = new Attrezzo("balena", 10000);
		this.daTestare.addAttrezzo(tazzina);
	}
/***************************************addAttrezzo***********************************************/
	@Test (expected=NullPointerException.class)
	public void testAddAttrezzo_BorsaNull() {
		assertFalse(isNull.addAttrezzo(tazzina));
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
		assertNull(isNull.getAttrezzo("tazzina"));
	}
	
	@Test 
	public void testGetAttrezzo_AttrezzoNull(){
		assertNull(daTestare.getAttrezzo(""));
	}
	
	@Test 
	public void testGetAttrezzo_AttrezzoNotNull(){
		assertNotNull(daTestare.getAttrezzo("tazzina"));
	}
/***************************isEmpty*********************************************************************/	
	@Test (expected=NullPointerException.class)
	public void testIsEmpty_BorsaNull() {
		assertFalse(isNull.isEmpty());
	}
	
	@Test
	public void testIsntEmpty (){
		assertFalse(daTestare.isEmpty());
	}
	@Test
	public void testIsEmpty (){
		assertTrue(vuota.isEmpty());
	}

/****************************hasAttrezzo**************************************************************************/
	@Test (expected=NullPointerException.class)
	public void testHasAttrezzo_BorsaNull() {
		assertFalse(isNull.hasAttrezzo(""));
	}
	
	@Test //(expected=NullPointerException.class)
	public void testHasAttrezzo_AttrezzoNull() {
		assertFalse(daTestare.hasAttrezzo(""));
	}
/****************************removeAttrezzo***************************************************/
	
	@Test (expected=NullPointerException.class)
	public void testRemoveAttrezzo_BorsaNull(){
		assertNull(isNull.removeAttrezzo("tazzina"));
	}
	
	@Test 
	public void testRemoveAttrezzo_AttrezzoNull(){
		assertNull(daTestare.getAttrezzo(""));
	}
/********************getBorsaOrderedByWeight***********************************************************/
	@Test
	public void testGetSortedSetOrdinatoPerPeso(){
		assertEquals(this.daTestare.getSortedSetOrdinatoPerPeso());
	}


}
