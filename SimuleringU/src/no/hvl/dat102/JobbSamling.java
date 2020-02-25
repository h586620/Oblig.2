package no.hvl.dat102;
import java.io.*;
//Kjøreplan 1
public class JobbSamling {

	//Konstanter
	private static final String FELT_SLUTT_TEGN ="#";
    //Egenskaper
    private int antall;
    private Jobb[] tabell;

    //Konstruktør
    public JobbSamling(){
        tabell = new Jobb[0];
        antall = 0;
    }

    public JobbSamling(int stor){
        tabell = new Jobb[stor];
        antall = 0;
    }
    //Andre metoder

    public boolean erTom(){
        return antall == 0;
    }//

    public int getAntall(){
        return antall;
    }//

    public void leggTil(Jobb jobb){
        tabell[antall] = jobb;
        antall++;
    }//

// Tekstfil
public void lesFraFil(String filnavn){
    int jobbnr, kjtid, ankomst;
    FileReader tekstFilLeser = null;
    try{
        tekstFilLeser = new FileReader(filnavn);
    }
    catch(FileNotFoundException unntak){
        System.out.println("Finner ikke filen " + filnavn);
        System.exit(-1);
    }
    BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
    try{
        String linje = tekstLeser.readLine();
        int antallJobber = Integer.parseInt(linje); // antall jobber

    //Oppretter objekter av jobber til tabell
    tabell = new Jobb[antallJobber];

    for(int i = 0; i < antallJobber; i++){

      //Leser en post, og finner indeksene til skilletegn
      //NB! Rekkefølge på datafil annen rekkefølge enn i oppgaven
      String post = tekstLeser.readLine();

      //Jobbnr
      int startIndeks = 0;
      int sluttIndeks = post.indexOf(FELT_SLUTT_TEGN);
      jobbnr = Integer.parseInt(post.substring(startIndeks, sluttIndeks));

            //Ankomsttid
      startIndeks = sluttIndeks + 1;
      sluttIndeks = post.indexOf(FELT_SLUTT_TEGN,startIndeks);
      ankomst = Integer.parseInt(post.substring(startIndeks, sluttIndeks));

      //Kjøretid
      startIndeks = sluttIndeks + 1;
      kjtid = Integer.parseInt(post.substring(startIndeks));


      // Legger jobbobjekter inn i tabellen
      tabell[i] = new Jobb(jobbnr,kjtid,ankomst);
      antall++;
    }//for
    tekstLeser.close();
  }//try
    catch(IOException unntak){
         System.out.print("Feil ved innlesing!");
         System.exit(-1);
    }
  }//metode



 public Jobb hentAnkommenJobb(int tid){

        int minsteTid = tid;
        int indeksTilMinste = -1;

        for(int i = 0; i < antall; i++){
            if(tabell[i].getAnkomstTid() <= minsteTid){
                minsteTid = tabell[i].getAnkomstTid();
                indeksTilMinste = i;
            }
        }//for

        if(indeksTilMinste >-1){
            Jobb tmp = tabell[indeksTilMinste];
            tabell[indeksTilMinste] = tabell[antall-1];
            tabell[antall-1] = null;
            antall--;
            return tmp;
        }else{
            return null;
        }
    }


    public void visJobber(){
    	System.out.println("Nr       Anktid       CPUtid      Ferdig      Ventetid");
    	int sum = 0;
    	for(int i = 0; i < antall; i++){
    		sum = sum + tabell[i].finnVenteTid();
            System.out.println(tabell[i]);
    	}
    	System.out.println("Gjennomsnittlig ventetid blir: " + (double)sum/(double)antall
                          +"\n");
    }//metode


}//class
