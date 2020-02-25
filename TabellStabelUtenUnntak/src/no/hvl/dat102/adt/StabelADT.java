package no.hvl.dat102.adt;

 /* Definerer interface til en datastruktur stabel.
 */
public interface StabelADT<T> {
	
/**
 * Legge på et lement
 * @param element er elementet som stables på
 */
	public void push(T element);

	/**
	 * Fjerner og returnerer toppelementet fra stabelen.
	 * 
	 * @return elementet som stables av
	 */
	public T pop();

	/**
	 * Returnerer toppelemnetet uten å fjerne det fra stabelen.
	 * 
	 * @return toppelementet
	 */
	public T peek();

	/**
	 * Returnerer sann hvis stabelen ikke inneholder noen elemnter
	 * 
	 * @return sann hvis tom stabel
	 */
	public boolean erTom();

	/**
	 * Returnerer antall elementer på stabelen.
	 * 
	 * @return antall element på stabelen
	 */
	public int antall();

}
