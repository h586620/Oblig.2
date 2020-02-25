package no.hvl.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.StabelADT;
import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.kjedet.KjedetStabel;
import no.hvl.dat102.tabell.TabellStabel;

public abstract class KoeTest {

	private KoeADT<Integer> koe;

	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	

	public abstract KoeADT<Integer> reset();
	
	
	@BeforeEach
	public void setup() {
		koe = reset();
	}

	@Test
	public void nyKoeErTom() {
		assertTrue(koe.erTom());
	}

	
	@Test
	public void innkøogutkø() {

		koe.innkø(e0);
		koe.innkø(e1);
		koe.innkø(e2);
		koe.innkø(e3);

		try {
			assertEquals(e0, koe.utkø());
			assertEquals(e1, koe.utkø());
			assertEquals(e2, koe.utkø());
			assertEquals(e3, koe.utkø());
		} catch (EmptyCollectionException e) {
			fail("pop feilet uventet " + e.getMessage());
		}
	}

	@Test
	public void innkøOgutkøMedDuplikater() {

		koe.innkø(e0);
		koe.innkø(e1);
		koe.innkø(e1);
		koe.innkø(e2);

		try {
			assertEquals(e0, koe.utkø(), "Gitt element er ikke lik " + e0);
			assertEquals(e1, koe.utkø(), "Gitt element er ikke lik " + e1);
			assertEquals(e1, koe.utkø(), "Gitt element er ikke lik " + e1);
			assertEquals(e2, koe.utkø(), "Gitt element er ikke lik " + e2);
		} catch (EmptyCollectionException e) {
			fail("pop feilet uventet " + e.getMessage());
		}
	}

	@Test
	public void innkøutkøinnkøinnkøutkøførste() {
		try {
			koe.innkø(e2);
			koe.utkø();
			koe.innkø(e3);
			koe.innkø(e4);
			koe.utkø();
			
			Integer temp = (Integer)koe.første();
			assertEquals(e4, temp);

		} catch (EmptyCollectionException e) {
			fail("pop eller peek feilet uventet " + e.getMessage());
		}
	}

	@Test
	public final void erIkkeTom() {
		koe.innkø(e0);
		koe.innkø(e1);
		assertFalse(koe.erTom());
	}

	@Test
	public void innkøutkøErTom() {
		try {
			koe.innkø(e0);
			koe.utkø();
			assertTrue(koe.erTom());

		} catch (EmptyCollectionException e) {
			fail("push eller pop feilet uventet " + e.getMessage());
		}
	}

	@Test
	public void stor() {
		koe.innkø(e0);
		koe.innkø(e1);
		koe.innkø(e2);
		assertEquals(3, koe.antall());
	}


	@Test
	public void utkøFromEmptyIsUnderflowed() {
		
		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.utkø();
		});
	}
}

