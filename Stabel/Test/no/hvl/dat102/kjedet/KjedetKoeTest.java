package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KjedetKoe;
import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeTest;

public class KjedetKoeTest extends KoeTest {

	@Override
	public KoeADT<Integer> reset() {
		return new KjedetKoe<>();
	}

}
