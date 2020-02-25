package no.hvl.dat102.adt;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.kjedet.LinearNode;

public class SirkulaerKoe<T> implements KoeADT<T> {

		private final static int STDK = 100;
		private int foran, bak, antall;
		private T[] koe;

		public SirkulaerKoe() {
			this(STDK);
		}

		public SirkulaerKoe(int startKapasitet) {
			foran = bak = antall = 0;
			koe = ((T[]) (new Object[startKapasitet]));
		}
	     //...

		@Override
		public boolean erTom() {
				return (antall == 0);
		}

		@Override
		public void innkø(T e0) {
			if (antall != 0)
				bak++;
			koe[bak%koe.length] = e0;
			antall++;
		}

		@Override
		public T utkø() {
			if (erTom())
				throw new EmptyCollectionException("koe");

			T resultat = koe[foran];
			koe[foran] = null;
			if (antall != 1)
				foran = (foran + 1) % koe.length;
			
			antall--;
			return resultat;
		}

		@Override
		public int antall() {
			return antall;
		}
		

		@Override
		public T første() {
			if (erTom())
				throw new EmptyCollectionException("koe");
			
			
			return koe[foran];
		}
		
	}// class
