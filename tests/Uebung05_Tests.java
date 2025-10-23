package de.wi25213.tests;

import org.junit.Assert;
import org.junit.Test;

import de.wi25213.Uebung05;

public class Uebung05_Tests {

	@Test
	public void testToBinaryZero() {
		Assert.assertEquals("0", Uebung05.toBinary(0));
	}
	
	@Test
	public void testToBinaryOne() {
		Assert.assertEquals("1", Uebung05.toBinary(1));
	}
	
	@Test
	public void testToBinarySmallNumbers() {
		Assert.assertEquals("10", Uebung05.toBinary(2));
		Assert.assertEquals("11", Uebung05.toBinary(3));
		Assert.assertEquals("100", Uebung05.toBinary(4));
		Assert.assertEquals("101", Uebung05.toBinary(5));
	}
	
	@Test
	public void testToBinaryLargerNumbers() {
		Assert.assertEquals("1010", Uebung05.toBinary(10));
		Assert.assertEquals("10111", Uebung05.toBinary(23));
		Assert.assertEquals("101010", Uebung05.toBinary(42));
		Assert.assertEquals("11111111", Uebung05.toBinary(255));
	}
	
	@Test
	public void testToBinaryPowersOfTwo() {
		Assert.assertEquals("1000", Uebung05.toBinary(8));
		Assert.assertEquals("10000", Uebung05.toBinary(16));
		Assert.assertEquals("100000", Uebung05.toBinary(32));
		Assert.assertEquals("1000000", Uebung05.toBinary(64));
	}

	
	@Test
	public void testPotenzBaseCase() {
		Assert.assertEquals(1.0, Uebung05.potenz(5, 0), 0.001);
		Assert.assertEquals(1.0, Uebung05.potenz(100, 0), 0.001);
	}
	
	@Test
	public void testPotenzPowerOfOne() {
		Assert.assertEquals(2.0, Uebung05.potenz(2, 1), 0.001);
		Assert.assertEquals(7.5, Uebung05.potenz(7.5, 1), 0.001);
	}
	
	@Test
	public void testPotenzIntegers() {
		Assert.assertEquals(32.0, Uebung05.potenz(2, 5), 0.001);
		Assert.assertEquals(8.0, Uebung05.potenz(2, 3), 0.001);
		Assert.assertEquals(81.0, Uebung05.potenz(3, 4), 0.001);
		Assert.assertEquals(1000.0, Uebung05.potenz(10, 3), 0.001);
	}
	
	@Test
	public void testPotenzDoubles() {
		Assert.assertEquals(6.25, Uebung05.potenz(2.5, 2), 0.001);
		Assert.assertEquals(15.625, Uebung05.potenz(2.5, 3), 0.001);
	}
	
	@Test
	public void testPotenzLargePowers() {
		Assert.assertEquals(1024.0, Uebung05.potenz(2, 10), 0.001);
		Assert.assertEquals(59049.0, Uebung05.potenz(3, 10), 0.001);
	}

	
	@Test
	public void testQuersummeZero() {
		Assert.assertEquals(0, Uebung05.quersumme(0));
	}
	
	@Test
	public void testQuersummeSingleDigit() {
		Assert.assertEquals(5, Uebung05.quersumme(5));
		Assert.assertEquals(9, Uebung05.quersumme(9));
	}
	
	@Test
	public void testQuersummeTwoDigits() {
		Assert.assertEquals(3, Uebung05.quersumme(12));
		Assert.assertEquals(10, Uebung05.quersumme(55));
		Assert.assertEquals(9, Uebung05.quersumme(45));
	}
	
	@Test
	public void testQuersummeThreeDigits() {
		Assert.assertEquals(6, Uebung05.quersumme(123));
		Assert.assertEquals(15, Uebung05.quersumme(456));
		Assert.assertEquals(24, Uebung05.quersumme(789));
	}
	
	@Test
	public void testQuersummeLargeNumbers() {
		Assert.assertEquals(10, Uebung05.quersumme(1234));
		Assert.assertEquals(45, Uebung05.quersumme(123456789));
	}
	
	@Test
	public void testQuersummeWithZeros() {
		Assert.assertEquals(1, Uebung05.quersumme(100));
		Assert.assertEquals(2, Uebung05.quersumme(1001));
		Assert.assertEquals(3, Uebung05.quersumme(10020));
	}
	

	@Test
	public void testIsPrimeSmallPrimes() {
		Assert.assertTrue(Uebung05.isPrime(2));
		Assert.assertTrue(Uebung05.isPrime(3));
		Assert.assertTrue(Uebung05.isPrime(5));
		Assert.assertTrue(Uebung05.isPrime(7));
		Assert.assertTrue(Uebung05.isPrime(11));
		Assert.assertTrue(Uebung05.isPrime(13));
	}
	
	@Test
	public void testIsPrimeLargerPrimes() {
		Assert.assertTrue(Uebung05.isPrime(17));
		Assert.assertTrue(Uebung05.isPrime(23));
		Assert.assertTrue(Uebung05.isPrime(29));
		Assert.assertTrue(Uebung05.isPrime(31));
		Assert.assertTrue(Uebung05.isPrime(97));
	}
	
	@Test
	public void testIsPrimeCompositeNumbers() {
		Assert.assertFalse(Uebung05.isPrime(4)); 
		Assert.assertFalse(Uebung05.isPrime(6));
		Assert.assertFalse(Uebung05.isPrime(8));
		Assert.assertFalse(Uebung05.isPrime(9));
		Assert.assertFalse(Uebung05.isPrime(10));
		Assert.assertFalse(Uebung05.isPrime(12));
		Assert.assertFalse(Uebung05.isPrime(15));
	}
	
	@Test
	public void testIsPrimeLargeComposites() {
		Assert.assertFalse(Uebung05.isPrime(100));
		Assert.assertFalse(Uebung05.isPrime(50));
		Assert.assertFalse(Uebung05.isPrime(99));
		Assert.assertFalse(Uebung05.isPrime(121));
	}
	
	@Test
	public void testIsPrimeEdgeCases() {
		Assert.assertFalse(Uebung05.isPrime(0));
		Assert.assertFalse(Uebung05.isPrime(1));
	}

}