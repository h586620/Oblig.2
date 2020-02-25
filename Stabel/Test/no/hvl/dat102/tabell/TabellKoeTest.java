package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeTest;
import no.hvl.dat102.adt.SirkulaerKoe;
import no.hvl.dat102.adt.TabellKoe;

public class TabellKoeTest extends KoeTest {

	@Override
	public KoeADT<Integer> reset() {
		return new TabellKoe<>();

}
}
