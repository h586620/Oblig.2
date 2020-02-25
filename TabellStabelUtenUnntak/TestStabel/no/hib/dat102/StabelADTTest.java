package no.hib.dat102;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.TabellStabel;
import no.hvl.dat102.adt.StabelADT;

//package 

/**
 * Test av StabelADT med heltall.
 * 
 * @author Ole Olsen
 */
public class StabelADTTest {

    private static final int SIZE = 105;

    private StabelADT<Integer> stabel;

    // Test data
    private Integer e0 = 1;
    private Integer e1 = 2;
    private Integer e2 = 3;
    private Integer e3 = 4;
    private Integer e4 = 5;
    private Integer e5 = 6;

    /**
     * Opprett en stabel for hver test.
     * 
     * @throws Exception exception
     */
    @Before
    public final void setup() throws Exception {
        stabel = new TabellStabel<Integer>(SIZE);
    }

    /**
     * Tester om en ny stabel er tom.
     */
    @Test
    public final void newStackIsEmpty() {
        assertTrue(stabel.erTom());
    }

    /**
     * Tester push-pop.
     */
    @Test
    public final void pushAndPop() {

        stabel.push(e0);
        stabel.push(e1);
        stabel.push(e2);
        stabel.push(e3);

        assertEquals(e3, stabel.pop());
        assertEquals(e2, stabel.pop());
        assertEquals(e1, stabel.pop());
        assertEquals(e0, stabel.pop());
    }

    /**
     * Tester push-pop med like verdier.
     */
    @Test
    public final void pushAndPopWithDuplicates() {

        stabel.push(e0);
        stabel.push(e1);
        stabel.push(e1);
        stabel.push(e2);

        assertEquals(e2, stabel.pop());
        assertEquals(e1, stabel.pop());
        assertEquals(e1, stabel.pop());
        assertEquals(e0, stabel.pop());
    }

    /**
     * Testing top.
     */
    @Test
    public final void pushPopPushPushPopPeek() {
        stabel.push(e2);
        stabel.pop();
        stabel.push(e3);
        stabel.push(e4);
        stabel.pop();
        assertEquals(e3, stabel.peek());
    }

    /**
     * Tester om stabel med verdier ikke er tom.
     */
    @Test
    public final void isNotEmpty() {
        stabel.push(e0);
        assertFalse(stabel.erTom());
    }

    /**
     * Tester om push-pop på en tom stabel gir en tom stabel.
     */
    @Test
    public final void pushPopIsEmpty() {
        stabel.push(e0);
        stabel.pop();
        assertTrue(stabel.erTom());
    }

    /**
     * Prøver å ta av et element fra en tom stabel.
     */
    @Test
    public final void popFromEmptyIsUnderflowed() {
        assertNull("Stable av fra tom stabel feiler", stabel.pop());
    }
    
    /**
     * Tester om stabelen utvider seg riktig. Stabler på to flere elementer 
     * enn stabeltabellen har plass til, sjekker om antallet er riktig,
     * tar ut og sjekker første element, tar ut de i "midten",
     * tar ut og sjekker det siste elementet og sjekker til slutt
     * at køen er tom slik det forventes.
     */
	
    @Test
    public final void utviderKoeSeg() {
        stabel.push(e1);
        for (int i = 0; i < SIZE; i++) {
            stabel.push(e0);
        }
        stabel.push(e2);
        assertEquals(SIZE + 2, stabel.antall());
        assertEquals(e2, stabel.pop());
        for (int i = 0; i < SIZE; i++) {
            stabel.pop();
        }
        assertEquals(e1, stabel.pop());
        assertTrue(stabel.erTom());
    }
        

}
