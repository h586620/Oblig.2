package no.hvl.dat102;

public class KlientLabyrint {

	public static void main(String[] args) {
		Labyrint labyrint = new Labyrint();

		System.out.println(labyrint);

		LabyrintSpill spill = new LabyrintSpill(labyrint);

		if (spill.gjennomgaa(0, 0)) {
			System.out.println("Det er en sti gjennom labyrinten");
		} else {
			System.out.println("Det er ingen mulig sti.");
		}
		System.out.println(labyrint);

	}// main
}
