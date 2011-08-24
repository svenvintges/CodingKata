package nl.svenvintges.codekata.pragprog;

import static org.junit.Assert.*;

import org.junit.Test;

public class KarateChopTest {
	
	

	@Test
	public void testChop1() {
		assertEquals(-1, KarateChop.chop1(3, new int[0]));
	    assertEquals(-1, KarateChop.chop1(3, new int[] {1}));
	    assertEquals(0,  KarateChop.chop1(1, new int[] {1}));
	    
	    assertEquals(0,  KarateChop.chop1(1, new int[] {1, 3, 5}));
	    assertEquals(1,  KarateChop.chop1(3, new int[] {1, 3, 5}));
	    assertEquals(2,  KarateChop.chop1(5, new int[] {1, 3, 5}));
	    assertEquals(-1, KarateChop.chop1(0, new int[] {1, 3, 5}));
	    assertEquals(-1, KarateChop.chop1(2, new int[] {1, 3, 5}));
	    assertEquals(-1, KarateChop.chop1(4, new int[] {1, 3, 5}));
	    assertEquals(-1, KarateChop.chop1(6, new int[] {1, 3, 5}));
	    
	    assertEquals(0,  KarateChop.chop1(1, new int[] {1, 3, 5, 7}));
	    assertEquals(1,  KarateChop.chop1(3, new int[] {1, 3, 5, 7}));
	    assertEquals(2,  KarateChop.chop1(5, new int[] {1, 3, 5, 7}));
	    assertEquals(3,  KarateChop.chop1(7, new int[] {1, 3, 5, 7}));
	    assertEquals(-1, KarateChop.chop1(0, new int[] {1, 3, 5, 7}));
	    assertEquals(-1, KarateChop.chop1(2, new int[] {1, 3, 5, 7}));
	    assertEquals(-1, KarateChop.chop1(4, new int[] {1, 3, 5, 7}));
	    assertEquals(-1, KarateChop.chop1(6, new int[] {1, 3, 5, 7}));
	    assertEquals(-1, KarateChop.chop1(8, new int[] {1, 3, 5, 7}));
	}
    
    @Test
	public void testChop2() {
		assertEquals(-1, KarateChop.chop2(3, new int[0]));
	    assertEquals(-1, KarateChop.chop2(3, new int[] {1}));
	    assertEquals(0,  KarateChop.chop2(1, new int[] {1}));
	    
	    assertEquals(0,  KarateChop.chop2(1, new int[] {1, 3, 5}));
	    assertEquals(1,  KarateChop.chop2(3, new int[] {1, 3, 5}));
	    assertEquals(2,  KarateChop.chop2(5, new int[] {1, 3, 5}));
	    assertEquals(-1, KarateChop.chop2(0, new int[] {1, 3, 5}));
	    assertEquals(-1, KarateChop.chop2(2, new int[] {1, 3, 5}));
	    assertEquals(-1, KarateChop.chop2(4, new int[] {1, 3, 5}));
	    assertEquals(-1, KarateChop.chop2(6, new int[] {1, 3, 5}));
	    
	    assertEquals(0,  KarateChop.chop2(1, new int[] {1, 3, 5, 7}));
	    assertEquals(1,  KarateChop.chop2(3, new int[] {1, 3, 5, 7}));
	    assertEquals(2,  KarateChop.chop2(5, new int[] {1, 3, 5, 7}));
	    assertEquals(3,  KarateChop.chop2(7, new int[] {1, 3, 5, 7}));
	    assertEquals(-1, KarateChop.chop2(0, new int[] {1, 3, 5, 7}));
	    assertEquals(-1, KarateChop.chop2(2, new int[] {1, 3, 5, 7}));
	    assertEquals(-1, KarateChop.chop2(4, new int[] {1, 3, 5, 7}));
	    assertEquals(-1, KarateChop.chop2(6, new int[] {1, 3, 5, 7}));
	    assertEquals(-1, KarateChop.chop2(8, new int[] {1, 3, 5, 7}));
	}

}
