package no.hvl.dat102;

public class Jobb implements Comparable<Jobb> {

	// Egenskaper
	private int jobbnr;
	private int ankomsttid;
	private int kjoeretid;
	private int ferdigtid;

	// Konstruktører
	public Jobb(int jnr, int kjtid, int anktid) {
		jobbnr = jnr;
		ankomsttid = anktid;
		kjoeretid = kjtid;
		ferdigtid = -1;

	}

	public int getKjoeretid() {
		return kjoeretid;
	}//

	public int getAnkomstTid() {
		return ankomsttid;
	}//

	public void setFerdigTid(int ferdig) {
		ferdigtid = ferdig;
	}//

	public int getFerdigTid() {
		return ferdigtid;
	}//

	public int finnVenteTid() {
		if (ferdigtid != -1)
			return ((ferdigtid - ankomsttid) - kjoeretid);
		else
			return 0;
	}//

@Override
public int compareTo(Jobb denAndre){
	int svar = 0;

	if(kjoeretid < denAndre.getKjoeretid()){
		svar = -1;
	}else if(kjoeretid > denAndre.getKjoeretid()){
		svar = 1;
	}else{// sammenligner ankomsttidene
	    if(ankomsttid < denAndre.getAnkomstTid()){
	    	svar = -1;
		}else if(ankomsttid > denAndre.getAnkomstTid()){
	    	svar = 1;
	    }else{
	    	svar = 0;
	    }
	}
	return svar;
}//

	@Override
	public String toString() {
		return (jobbnr + "\t\t\t" + ankomsttid + "\t\t\t" + kjoeretid + "\t\t\t" + ferdigtid + "\t\t\t" + finnVenteTid()
				+ "\t\t\t");
	}//

}// class
