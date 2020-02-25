package no.hvl.dat102;

import java.util.Scanner;

public class KlientSjanger {

	public static void main(String[] args) {

		String sjnavn1 = "action";
		Sjanger sjanger1 = Sjanger.finnSjanger(sjnavn1);
		
		if (sjanger1 != null) {
			System.out.println(sjanger1);
		} else {
			System.out.println("Ikke lovlig sjanger");
		}

		
		String sjnavn2 = "drama";
		Sjanger sjanger2 = Sjanger.finnSjanger(sjnavn2);
		
		         
		if (sjanger1 != null && sjanger2 != null) {
			if (sjanger1.compareTo(sjanger2) < 0) {
				System.out.print(sjanger1 + " ");
				System.out.println(sjanger1.ordinal());
			} else {
				System.out.println(sjanger2 + " ");
				System.out.println(sjanger2.ordinal());
			}
		}

	}
}
