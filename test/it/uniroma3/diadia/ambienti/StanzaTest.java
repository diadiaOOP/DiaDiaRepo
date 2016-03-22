package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {

	private Stanza Bar, Mensa, Biblioteca;
	private Attrezzo tazzina, vassoio, piatto, dizionario;
	
	@Before
	public void setUp() {
		Bar = new Stanza("bar");
		Mensa = new Stanza("mensa");
		Biblioteca = new Stanza("biblioteca");
		tazzina = new Attrezzo("tazzina", 1);
		vassoio = new Attrezzo("vassoio", 3);
		piatto = new Attrezzo("piatto", 1);
		dizionario = new Attrezzo("dizionario", 5);
		Bar.impostaStanzaAdiacente("nord",Mensa);
		Mensa.impostaStanzaAdiacente("sud", Bar);
		Bar.addAttrezzo(tazzina);
		Mensa.addAttrezzo(vassoio);
		Mensa.addAttrezzo(piatto);
		Biblioteca.addAttrezzo(dizionario);
	}

	@Test	
	public void testGetStanzaAdiacenteBarNord() {
		assertEquals(Mensa, Bar.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteMensaSud() {
		assertEquals(Bar, Mensa.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetStanzaAdiacenteMensaOvest() {
		assertEquals(null, Mensa.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testAttrezziToStringBar(){
		assertEquals("tazzina (1 kg) ", Bar.attrezziToString());
	}
	
	@Test
	public void testAttrezziToStringMensa(){
		assertEquals("vassoio (3 kg) piatto (1 kg) ", Mensa.attrezziToString());
	}
	
	@Test
	public void testAttrezziToStringBiblioteca(){
		assertEquals("dizionario (5 kg) ", Biblioteca.attrezziToString());
	}
	
	
	/*public void removeSetUp() {
		Mensa = new Stanza("mensa");
		vassoio = new Attrezzo("vassoio", 3);
		piatto = new Attrezzo("piatto", 1);
		Mensa.addAttrezzo(vassoio);
		Mensa.addAttrezzo(piatto);
		//Mensa.removeAttrezzo("piatto");
	}*/
	
	/*@Test
	public void testRemoveAttrezzo() {
		assertEquals("vassoio (3 kg) ", Mensa.attrezziToString());
	}*/
	
	@Test
	public void testRemoveAttrezzo_1() {
		assertFalse(Mensa.removeAttrezzo("piatto"));
	}

}