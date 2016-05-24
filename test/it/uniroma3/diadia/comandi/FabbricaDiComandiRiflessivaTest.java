package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiRiflessivaTest {

	private AbstractComando comando;
	private FabbricaDiComandi fabbricaComandi;
	
	@Before
	public void setUp() {
		fabbricaComandi = new FabbricaDiComandiRiflessiva();
	}

	@Test
	public void testComandoVai() {
		comando = fabbricaComandi.costruisciComando("vai nord");
		assertEquals("vai",comando.getNome());
		assertEquals("nord",comando.getParametro());
	}
	
	@Test
	public void testComandoNonValido(){
		comando = fabbricaComandi.costruisciComando("bla bla");
		assertEquals("non valido", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoPrendi(){
		comando = fabbricaComandi.costruisciComando("prendi libro");
		assertEquals("prendi", comando.getNome());
		assertEquals("libro",comando.getParametro());
	}
	
	@Test
	public void testComandoPosa(){
		comando = fabbricaComandi.costruisciComando("posa libro");
		assertEquals("posa", comando.getNome());
		assertEquals("libro",comando.getParametro());
	}
	
	@Test
	public void testComandoGuarda(){
		comando = fabbricaComandi.costruisciComando("guarda");
		assertEquals("guarda", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoFine(){
		comando = fabbricaComandi.costruisciComando("fine");
		assertEquals("fine", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoAiuto(){
		comando = fabbricaComandi.costruisciComando("aiuto");
		assertEquals("aiuto", comando.getNome());
		assertNull(comando.getParametro());
	}
}
