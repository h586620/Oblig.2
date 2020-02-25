package no.hib.dat102.mengde.tabell;

import no.hib.dat102.mengde.adt.*;


import java.util.Iterator;
import java.util.Random;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		T svar = null;
		if (antall > 0) {
			int indeks = tilf.nextInt(antall);
			svar = tab[indeks];
			tab[indeks] = tab[antall - 1];
			antall--;
		}
		return svar;
	}

	@Override
	public T fjern(T element) {
		// S�ker etter og fjerner element.Retur med null ved ikke-funn
		
		boolean funnet = false;
		T svar = null;
		
		for(int i = 0; i < antall && !funnet; i++) {
			if(tab[i].equals(element)) {
				svar = element;
				funnet = true;
				element = tab[antall - 1];
				tab[antall - 1] = null;
				antall--;
			}
		}
		
		return svar;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
			MengdeADT<T> begge = new TabellMengde<T>();
			T element = null;
			
			for(int i = 0; i < antall; i++) {
				((TabellMengde<T>) begge).settInn(tab[i]);
			}
			Iterator<T> iterator = m2.oppramser();
			while(iterator.hasNext()) {
				T ele = iterator.next();
				if(!inneholder(ele)) {
					((TabellMengde<T>) begge).settInn(ele);
				}
			}
			return begge;
		
	}
	
	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new TabellMengde<T>();
		T element= null;
		
			Iterator<T> iterator = m2.oppramser();
			while(iterator.hasNext()) {
				element = iterator.next();
				if(this.inneholder(element)) {
					((TabellMengde<T>) snittM).settInn(element);
				}
			}
			return snittM;
		}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new TabellMengde<T>();
		T element;
		
			Iterator<T> iterator = this.oppramser();
			while(iterator.hasNext()) {
				T ele = iterator.next();
				if(!m2.inneholder(ele)) {
					((TabellMengde<T>) differensM).settInn(ele);
				}
			}

			return differensM;
		}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

	@Override
	public boolean inneholder(T element) {
		
		boolean funnet = false;
		
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}

	@Override
	public boolean equals(MengdeADT<T> m2) {
		boolean likeMengder = true;
		T element;
		
		Iterator<T> itearator = m2.oppramser();
		while(likeMengder && itearator.hasNext()) {
			element = itearator.next();
			if(!m2.inneholder(element)) {
				if(element.equals(m2)) {
					likeMengder = false;
				}
			}
			}
		
		return likeMengder;
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext())
			leggTil(teller.next());
	}
	

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		//Fyll ut
		return false;
	}

	@Override
	public Iterator<T> oppramser() {
		return new TabellIterator<T>(tab, antall);
	}


}// class
