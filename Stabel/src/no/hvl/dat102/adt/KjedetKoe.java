package no.hvl.dat102.adt;

import java.util.function.BooleanSupplier;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.kjedet.LinearNode;

//********************************************************************
	//
	//Representer en samling koe, implementert vha kjedet struktur
	//********************************************************************

	public class KjedetKoe<T> implements KoeADT<T> {
		private int antall;
		private LinearNode<T> front, bak;
		
		public KjedetKoe(){
			antall = 0;
		}
		
	  //....
		@Override
		public void innkø(T el) {
			LinearNode<T> nynode = new LinearNode<T>(el);
			if(erTom()) {
				front = nynode;
			} else {
				bak.setNeste(nynode);
			}
			bak = nynode;
			antall++;
		}

		@Override
		public T utkø() {
			if (erTom())
				throw new EmptyCollectionException("kø");

			T resultat = front.getElement();
			front = front.getNeste();
			antall--;
			if(antall == 0) {
				bak = null;
			}
			return resultat;
		}

		@Override
		public T første()  {
			if (erTom())
				throw new EmptyCollectionException("kø");
			
			return front.getElement();
		}

		@Override
		public boolean erTom() {
			return (antall == 0);
		}

		@Override
		public int antall() {
			return antall;
		}

	}

	
