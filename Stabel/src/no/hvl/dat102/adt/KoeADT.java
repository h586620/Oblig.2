package no.hvl.dat102.adt;

import java.util.function.BooleanSupplier;

public interface KoeADT<T> {

	public boolean erTom();

	void innkø(T e0);

	T utkø();

	int antall();

	T første();

}
