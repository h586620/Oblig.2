package no.hvl.dat102.adt;

import no.hvl.dat102.exception.EmptyCollectionException;

public class TabellKoe<T> implements KoeADT<T>{
	 private final static int STDK = 100;
	 private int bak, foran;
	 private T[] koe; 
	 private int antall;

	public TabellKoe()   {
	   this(STDK);     
	 }

	 public TabellKoe (int startKapasitet){
	    bak = 0;     
	    koe = (T[])(new Object[startKapasitet]);
	  }

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void innkø(T e0) {
		
		if (antall() == koe.length) {
			utvid();
		}
		koe[bak] = e0;
		bak++;
		antall++;
		
	}

	@Override
	public T utkø() {
		
		if(erTom()) 
			throw new EmptyCollectionException("koe");
		
			T resultat = koe[0];
			bak--;
		
		for(int i = 0; i < bak; i++) {
			koe[i] = koe[i+1];
		}
		
		koe[bak] = null;
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
		
		return koe[0];
	}
	
	public boolean inneholder(T element){ 
		boolean funnet = false; 
		for(int i = 0; (i< STDK) &&(!funnet); i++){
			if(koe[i].equals(element))
				funnet = true;}
		return(funnet);
	}
	
	private void utvid() {
		@SuppressWarnings("unchecked")
		T[] hjelpeTabell = (T[]) (new Object[koe.length * 2]);

		for (int indeks = 0; indeks < koe.length; indeks++)
			hjelpeTabell[indeks] = koe[indeks];

		koe = hjelpeTabell;
	}
	
	}//class



