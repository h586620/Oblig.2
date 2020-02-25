package no.hvl.dat102;

//********************************************************************
//  EmptyCollectionException.java   //
//  Representerer the situasjonen når samlingen er tom.
//********************************************************************

public class EmptyCollectionException extends RuntimeException{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/******************************************************************
     Setter opp dette unntaket med passende melding.
   ******************************************************************/
   public EmptyCollectionException (String collection){
      super (" Denne " + collection + " er tom.");
   }
}
