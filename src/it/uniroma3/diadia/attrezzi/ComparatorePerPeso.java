/**
 * 
 */
package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

/**
 * @author Andrea Menichelli & Alessio Piccione
 *
 */
public class ComparatorePerPeso implements Comparator<Attrezzo>{

	@Override
	public int compare(Attrezzo o1, Attrezzo o2) {
		return o1.getPeso()-o2.getPeso();
	}

}
