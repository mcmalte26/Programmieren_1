package de.wi25213.tests;

import org.junit.Assert;
import org.junit.Test;

import de.wi25213.Uebung13;

public class Uebung13_Tests {
	@Test
	public void testMaxBlocksWithValidInput() {
		Assert.assertEquals(2, Uebung13.maxBlock("hoopla"));;
		Assert.assertEquals(3, Uebung13.maxBlock("abbCCCddBBBxx"));
	}
	
	@Test
	public void testMaxBlocksWithEmptyString() {
		Assert.assertEquals(0, Uebung13.maxBlock(""));
	}

	
	@Test
	public void testExploderWithEmptyString() {
		Assert.assertEquals("", Uebung13.explosion(""));
	}	
	
	@Test
	public void testExploderWithValidInput() {
		Assert.assertEquals("CCoCodCodeCoder", Uebung13.explosion("Coder"));
		Assert.assertEquals("JJaJavJava", Uebung13.explosion("Java"));
		Assert.assertEquals("aababc", Uebung13.explosion("abc"));
		Assert.assertEquals("aab", Uebung13.explosion("ab"));
	}
	
	@Test
	public void testArrayPattern() {
		Assert.assertTrue(Uebung13.arrayPattern(new int[] {1, 1, 2, 3, 1}, new int[] {1, 2, 3}));
	    Assert.assertFalse(Uebung13.arrayPattern(new int[] {1, 1, 2, 4, 1}, new int[] {1, 2, 3}));
	    Assert.assertFalse(Uebung13.arrayPattern(new int[] {1, 2}, new int[] {1, 2, 3}));
	    Assert.assertFalse(Uebung13.arrayPattern(new int[] {1, 2, 2, 3}, new int[] {1, 2, 3}));
	}
	
	@Test
	public void testArrayRepeats() {
	    Assert.assertTrue(Uebung13.arrayRepeats(new int[] {1, 1, 2, 3, 1}, 2));
	    Assert.assertTrue(Uebung13.arrayRepeats(new int[] {1, 1, 2, 4, 1}, 2));
	    Assert.assertFalse(Uebung13.arrayRepeats(new int[] {1, 2, 3}, 2));
	    Assert.assertTrue(Uebung13.arrayRepeats(new int[] {4, 2, 4, 2, 4, 1, 2, 4}, 3));
	}

}