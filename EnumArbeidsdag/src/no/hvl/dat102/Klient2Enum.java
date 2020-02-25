package no.hvl.dat102;

import java.util.Scanner;

public class Klient2Enum {

	public static void main(String[] args) {
		
		Scanner tastatur = new Scanner(System.in);
		Arbeidsdag dag = null;

		do {
			System.out.print("Oppgi en arbeidsdag: ");
			String svar = tastatur.nextLine();
			dag = Arbeidsdag.finnArbeidsdag(svar);
			if(dag == null){
				System.out.println("Ikke en arbeidsdag\n");
			}
		} while (dag == null);

		switch (dag) {
		case MANDAG:
			System.out.println("Dårlig dag\n");
			break;
		case TIRSDAG:
		case ONSDAG:
		case TORSDAG:
			System.out.println("Ikke så gale\n");
			break;
		case FREDAG:
			System.out.println("Topp\n");
			break;
		} // Ikke behov for default her

	}// main

	

}// class
