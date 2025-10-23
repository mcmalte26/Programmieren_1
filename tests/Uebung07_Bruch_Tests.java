package de.wi25213.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import de.wi25213.uebung07.Bruch;
import de.wi25213.uebung07.BruchRechnung;

public class Uebung07_Bruch_Tests {

	@Test
	public void testBruchKonstruktor() {
		Bruch b = new Bruch(1, 2);
		Assert.assertEquals(1, b.getZaehler());
		Assert.assertEquals(2, b.getNenner());
	}

	@Test
	public void testBruchMitNegativenWerten() {
		Bruch b1 = new Bruch(-3, 4);
		Assert.assertEquals(-3, b1.getZaehler());
		Assert.assertEquals(4, b1.getNenner());

		Bruch b2 = new Bruch(3, -4);
		Assert.assertEquals(3, b2.getZaehler());
		Assert.assertEquals(-4, b2.getNenner());

		Bruch b3 = new Bruch(-3, -4);
		Assert.assertEquals(-3, b3.getZaehler());
		Assert.assertEquals(-4, b3.getNenner());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBruchNennerNull() {
		new Bruch(1, 0);
	}

	@Test
	public void testInitEinfacherBruch() {
		Bruch b = BruchRechnung.init(1, 2);
		Assert.assertEquals(1, b.getZaehler());
		Assert.assertEquals(2, b.getNenner());
	}

	@Test
	public void testInitKuerzen() {
		Bruch b = BruchRechnung.init(4, 8);
		Assert.assertEquals(1, b.getZaehler());
		Assert.assertEquals(2, b.getNenner());

		Bruch b2 = BruchRechnung.init(6, 9);
		Assert.assertEquals(2, b2.getZaehler());
		Assert.assertEquals(3, b2.getNenner());

		Bruch b3 = BruchRechnung.init(12, 18);
		Assert.assertEquals(2, b3.getZaehler());
		Assert.assertEquals(3, b3.getNenner());
	}

	@Test
	public void testInitNegativerNenner() {
		Bruch b = BruchRechnung.init(3, -4);
		Assert.assertEquals(-3, b.getZaehler());
		Assert.assertEquals(4, b.getNenner());

		Bruch b2 = BruchRechnung.init(-3, -4);
		Assert.assertEquals(3, b2.getZaehler());
		Assert.assertEquals(4, b2.getNenner());
	}

	@Test
	public void testInitNullZaehler() {
		Bruch b = BruchRechnung.init(0, 5);
		Assert.assertEquals(0, b.getZaehler());
		Assert.assertEquals(1, b.getNenner());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInitNennerNull() {
		BruchRechnung.init(1, 0);
	}

	@Test
	public void testToString() {
		Bruch b = BruchRechnung.init(3, 4);
		Assert.assertEquals("3/4", BruchRechnung.toString(b));

		Bruch b2 = BruchRechnung.init(1, 2);
		Assert.assertEquals("1/2", BruchRechnung.toString(b2));

		Bruch b3 = BruchRechnung.init(-5, 7);
		Assert.assertEquals("-5/7", BruchRechnung.toString(b3));
	}

	@Test
	public void testMultToEinfach() {
		Bruch a = BruchRechnung.init(1, 2);
		Bruch b = BruchRechnung.init(1, 3);
		Bruch result = BruchRechnung.multTo(a, b);

		Assert.assertEquals(1, result.getZaehler());
		Assert.assertEquals(6, result.getNenner());
	}

	@Test
	public void testMultToMitKuerzen() {
		Bruch a = BruchRechnung.init(2, 3);
		Bruch b = BruchRechnung.init(3, 4);
		Bruch result = BruchRechnung.multTo(a, b);

		// 2/3 * 3/4 = 6/12 = 1/2
		Assert.assertEquals(1, result.getZaehler());
		Assert.assertEquals(2, result.getNenner());
	}

	@Test
	public void testMultToMitNegativen() {
		Bruch a = BruchRechnung.init(-1, 2);
		Bruch b = BruchRechnung.init(1, 3);
		Bruch result = BruchRechnung.multTo(a, b);

		Assert.assertEquals(-1, result.getZaehler());
		Assert.assertEquals(6, result.getNenner());

		Bruch a2 = BruchRechnung.init(-1, 2);
		Bruch b2 = BruchRechnung.init(-1, 3);
		Bruch result2 = BruchRechnung.multTo(a2, b2);

		Assert.assertEquals(1, result2.getZaehler());
		Assert.assertEquals(6, result2.getNenner());
	}

	@Test
	public void testMultToMitNull() {
		Bruch a = BruchRechnung.init(0, 1);
		Bruch b = BruchRechnung.init(5, 7);
		Bruch result = BruchRechnung.multTo(a, b);

		Assert.assertEquals(0, result.getZaehler());
		Assert.assertEquals(1, result.getNenner());
	}

	@Test
	public void testAddToEinfach() {
		Bruch a = BruchRechnung.init(1, 2);
		Bruch b = BruchRechnung.init(1, 3);
		Bruch result = BruchRechnung.addTo(a, b);

		Assert.assertEquals(5, result.getZaehler());
		Assert.assertEquals(6, result.getNenner());
	}

	@Test
	public void testAddToGleicherNenner() {
		Bruch a = BruchRechnung.init(1, 4);
		Bruch b = BruchRechnung.init(2, 4);
		Bruch result = BruchRechnung.addTo(a, b);

		Assert.assertEquals(3, result.getZaehler());
		Assert.assertEquals(4, result.getNenner());
	}

	@Test
	public void testAddToMitKuerzen() {
		Bruch a = BruchRechnung.init(1, 2);
		Bruch b = BruchRechnung.init(1, 2);
		Bruch result = BruchRechnung.addTo(a, b);

		Assert.assertEquals(1, result.getZaehler());
		Assert.assertEquals(1, result.getNenner());
	}

	@Test
	public void testAddToMitNegativen() {
		Bruch a = BruchRechnung.init(3, 4);
		Bruch b = BruchRechnung.init(-1, 4);
		Bruch result = BruchRechnung.addTo(a, b);

		Assert.assertEquals(1, result.getZaehler());
		Assert.assertEquals(2, result.getNenner());
	}

	@Test
	public void testAddToErgibtNull() {
		Bruch a = BruchRechnung.init(1, 2);
		Bruch b = BruchRechnung.init(-1, 2);
		Bruch result = BruchRechnung.addTo(a, b);

		Assert.assertEquals(0, result.getZaehler());
		Assert.assertEquals(1, result.getNenner());
	}

	@Test
	public void testAddToKomplexesBeispiel() {
		Bruch a = BruchRechnung.init(2, 3);
		Bruch b = BruchRechnung.init(3, 4);
		Bruch result = BruchRechnung.addTo(a, b);

		Assert.assertEquals(17, result.getZaehler());
		Assert.assertEquals(12, result.getNenner());
	}

	@Test
	public void testKombinierteOperationen() {
		Bruch a = BruchRechnung.init(1, 2);
		Bruch b = BruchRechnung.init(1, 3);
		Bruch c = BruchRechnung.init(2, 5);

		Bruch sum = BruchRechnung.addTo(a, b);
		Bruch result = BruchRechnung.multTo(sum, c);

		Assert.assertEquals(1, result.getZaehler());
		Assert.assertEquals(3, result.getNenner());
	}

	@Test
	public void testStringBuilderVerwendung() {
		Bruch b = BruchRechnung.init(123456, 789012);
		String s = BruchRechnung.toString(b);
		Assert.assertEquals("10288/65751", s);
	}
	
	
	
}