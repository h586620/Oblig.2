package no.hvl.dat102;

import java.util.Scanner;

public class Klient3Enum {

	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);
		Arbeidsdag[] dag = Arbeidsdag.values();
		double timer = 0;
		double sum = 0;

		timer = 0;
		sum = 0;
		for (Arbeidsdag d : dag) {
			System.out.println("Oppgi arbeidstimer for " + d + " :");
			timer = tastatur.nextDouble();
			sum = sum + timer;
		}

		System.out.println("Totalt antall arbeidstimer = " + sum);
	}

}
