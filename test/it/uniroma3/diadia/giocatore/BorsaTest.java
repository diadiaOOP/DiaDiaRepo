/**
 * 
 */
package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.List;
import java.util. LinkedList;
import java.util.ArrayList;



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
		this.borsaVariAttrezzi = new Borsa(30);
		
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
	public void testGetContenutoRaggruppatoPerPeso() {
		Map<Integer,Set<Attrezzo>> mappaAttrezzi = new HashMap<>();
		Set<Attrezzo> piombo10 = new HashSet<>();
		piombo10.add(piombo);
		Set<Attrezzo> libro_ps5 = new HashSet<>();
		libro_ps5.add(libro);
		libro_ps5.add(ps);
		Set<Attrezzo> piuma1 = new HashSet<>();
		piuma1.add(piuma);
		mappaAttrezzi.put(10,piombo10);
		mappaAttrezzi.put(1, piuma1);
		mappaAttrezzi.put(5,libro_ps5);
		assertEquals(mappaAttrezzi ,this.borsaVariAttrezzi.getContenutoRaggruppatoPerPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		List<Attrezzo> listaAttrezzi = new LinkedList<>();
		listaAttrezzi.add(libro);
		listaAttrezzi.add(piombo);
		listaAttrezzi.add(piuma);
		listaAttrezzi.add(ps);
		assertEquals(listaAttrezzi,this.borsaVariAttrezzi.getContenutoOrdinatoPerNome());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		List<Attrezzo> listaAttrezzi = new ArrayList<>();
		listaAttrezzi.add(piuma);
		listaAttrezzi.add(libro);
		listaAttrezzi.add(ps);
		listaAttrezzi.add(piombo);
		assertEquals(listaAttrezzi,this.borsaVariAttrezzi.getContenutoOrdinatoPerPeso());
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
