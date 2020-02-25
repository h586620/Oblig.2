package no.hvl.dat102;

   public enum Arbeidsdag {
	   MANDAG,TIRSDAG,ONSDAG,TORSDAG,FREDAG;
	   
	 //Metoden sjekker om strengen svarer til en arbeidsdag.
		//Returnerer arbeidsdag ved funn ellers returneres null
	   
		public  static Arbeidsdag finnArbeidsdag(String navn) {
			Arbeidsdag adag = null;
			for (Arbeidsdag dag : Arbeidsdag.values()) {
				if (dag.toString().equals(navn.toUpperCase())) {
					adag = dag;
					break;
				}
			}
			return adag;
		}// metode
   
   };
   

	