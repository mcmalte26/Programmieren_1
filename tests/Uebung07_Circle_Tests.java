package de.wi25213.tests;

import org.junit.Assert;
import org.junit.Test;

import de.wi25213.uebung07.Circle;

public class Uebung07_Circle_Tests {

	@Test
	public void testCircleCreation() {
		Circle circle = new Circle(10, 5, 5, true);
		Assert.assertNotNull(circle);
	}

	@Test
	public void testCircleCopyConstructor() {
		Circle original = new Circle(10, 5, 5, true);
		Circle copy = new Circle(original);
		Assert.assertNotNull(copy);
	}

	@Test
	public void testCompareToIdenticalCircles() {
		Circle circle1 = new Circle(10, 5, 5, true);
		Circle circle2 = new Circle(10, 5, 5, true);
		Assert.assertTrue(circle1.compareTo(circle2));
	}

	@Test
	public void testCompareToSameCircle() {
		Circle circle = new Circle(10, 5, 5, true);
		Assert.assertTrue(circle.compareTo(circle));
	}

	@Test
	public void testCompareToCopiedCircle() {
		Circle original = new Circle(10, 5, 5, true);
		Circle copy = new Circle(original);
		Assert.assertTrue(original.compareTo(copy));
		Assert.assertTrue(copy.compareTo(original));
	}

	@Test
	public void testCompareToDifferentRadius() {
		Circle circle1 = new Circle(10, 5, 5, true);
		Circle circle2 = new Circle(15, 5, 5, true);
		Assert.assertFalse(circle1.compareTo(circle2));
	}

	@Test
	public void testCompareToDifferentPosX() {
		Circle circle1 = new Circle(10, 5, 5, true);
		Circle circle2 = new Circle(10, 10, 5, true);
		Assert.assertFalse(circle1.compareTo(circle2));
	}

	@Test
	public void testCompareToDifferentPosY() {
		Circle circle1 = new Circle(10, 5, 5, true);
		Circle circle2 = new Circle(10, 5, 10, true);
		Assert.assertFalse(circle1.compareTo(circle2));
	}

	@Test
	public void testCompareToDifferentFilled() {
		Circle circle1 = new Circle(10, 5, 5, true);
		Circle circle2 = new Circle(10, 5, 5, false);
		Assert.assertFalse(circle1.compareTo(circle2));
	}

	@Test
	public void testCompareToCompletelyDifferent() {
		Circle circle1 = new Circle(10, 5, 5, true);
		Circle circle2 = new Circle(20, 15, 25, false);
		Assert.assertFalse(circle1.compareTo(circle2));
	}

	@Test
	public void testCircleWithZeroRadius() {
		Circle circle = new Circle(0, 0, 0, false);
		Assert.assertNotNull(circle);
	}

	@Test
	public void testCircleWithNegativePosition() {
		Circle circle1 = new Circle(10, -5, -10, true);
		Circle circle2 = new Circle(10, -5, -10, true);
		Assert.assertTrue(circle1.compareTo(circle2));
	}

	@Test
	public void testMultipleCopies() {
		Circle original = new Circle(15, 20, 25, false);
		Circle copy1 = new Circle(original);
		Circle copy2 = new Circle(copy1);
		Circle copy3 = new Circle(copy2);
		
		Assert.assertTrue(original.compareTo(copy1));
		Assert.assertTrue(original.compareTo(copy2));
		Assert.assertTrue(original.compareTo(copy3));
		Assert.assertTrue(copy1.compareTo(copy2));
		Assert.assertTrue(copy2.compareTo(copy3));
	}

	@Test
	public void testFilledAndUnfilledCircles() {
		Circle filled = new Circle(10, 0, 0, true);
		Circle unfilled = new Circle(10, 0, 0, false);
		
		Assert.assertFalse(filled.compareTo(unfilled));
		Assert.assertFalse(unfilled.compareTo(filled));
	}

}