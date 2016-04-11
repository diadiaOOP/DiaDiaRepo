package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	private StanzaMagica magicaTest;
	private Attrezzo caviaTest, caviaInvertita;
	
	@Before
	public void setUp() throws Exception {
		magicaTest = new StanzaMagica("magic",2);
		caviaTest = new Attrezzo("mouse", 1);
		caviaInvertita = new Attrezzo("esuom", 2);
	}
	
	@Test
	public void testAddAttrezzo_Normal(){
		magicaTest.addAttrezzo(caviaTest);
		assertEquals(caviaTest, magicaTest.getAttrezzo("mouse"));
	}
	
	@Test
	public void testAddAttrezzo_Reverse(){
		magicaTest.addAttrezzo(caviaTest);
		magicaTest.addAttrezzo(caviaTest);
		magicaTest.addAttrezzo(caviaTest);
		assertEquals(caviaInvertita.getNome(), magicaTest.getAttrezzo("esuom").getNome());
		assertEquals(caviaInvertita.getPeso(), caviaTest.getPeso()*2);
		
	}

}
