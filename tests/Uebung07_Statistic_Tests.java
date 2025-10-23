package de.wi25213.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import de.wi25213.uebung07.Statistic;

public class Uebung07_Statistic_Tests {

	@Test
	public void testMinValueSimple() {
		double[] data = {1.0, 2.0, 3.0, 4.0, 5.0};
		Statistic stat = new Statistic(data);
		Assert.assertEquals(1.0, stat.minValue(), 0.0001);
	}

	@Test
	public void testMaxValueSimple() {
		double[] data = {1.0, 2.0, 3.0, 4.0, 5.0};
		Statistic stat = new Statistic(data);
		Assert.assertEquals(5.0, stat.maxValue(), 0.0001);
	}

	@Test
	public void testMeanValueSimple() {
		double[] data = {1.0, 2.0, 3.0, 4.0, 5.0};
		Statistic stat = new Statistic(data);
		Assert.assertEquals(3.0, stat.meanValue(), 0.0001);
	}

	@Test
	public void testMeanValueWithNegativeNumbers() {
		double[] data = {-5.0, -3.0, 0.0, 3.0, 5.0};
		Statistic stat = new Statistic(data);
		Assert.assertEquals(0.0, stat.meanValue(), 0.0001);
	}

	@Test
	public void testMinValueWithNegativeNumbers() {
		double[] data = {-5.0, -3.0, 0.0, 3.0, 5.0};
		Statistic stat = new Statistic(data);
		Assert.assertEquals(-5.0, stat.minValue(), 0.0001);
	}

	@Test
	public void testMaxValueWithNegativeNumbers() {
		double[] data = {-5.0, -3.0, 0.0, 3.0, 5.0};
		Statistic stat = new Statistic(data);
		Assert.assertEquals(5.0, stat.maxValue(), 0.0001);
	}

	@Test
	public void testStandardDeviationSimple() {
		double[] data = {2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0};
		Statistic stat = new Statistic(data);
		Assert.assertEquals(2.0, stat.standardDeviation(), 0.0001);
	}

	@Test
	public void testStandardDeviationSameValues() {
		double[] data = {5.0, 5.0, 5.0, 5.0};
		Statistic stat = new Statistic(data);
		Assert.assertEquals(0.0, stat.standardDeviation(), 0.0001);
	}

	@Test
	public void testSingleValue() {
		double[] data = {42.0};
		Statistic stat = new Statistic(data);
		Assert.assertEquals(42.0, stat.minValue(), 0.0001);
		Assert.assertEquals(42.0, stat.maxValue(), 0.0001);
		Assert.assertEquals(42.0, stat.meanValue(), 0.0001);
		Assert.assertEquals(0.0, stat.standardDeviation(), 0.0001);
	}

	@Test
	public void testTwoValues() {
		double[] data = {10.0, 20.0};
		Statistic stat = new Statistic(data);
		Assert.assertEquals(10.0, stat.minValue(), 0.0001);
		Assert.assertEquals(20.0, stat.maxValue(), 0.0001);
		Assert.assertEquals(15.0, stat.meanValue(), 0.0001);
		Assert.assertEquals(5.0, stat.standardDeviation(), 0.0001);
	}

	@Test
	public void testWithDecimalNumbers() {
		double[] data = {1.5, 2.3, 3.7, 4.2, 5.9};
		Statistic stat = new Statistic(data);
		Assert.assertEquals(1.5, stat.minValue(), 0.0001);
		Assert.assertEquals(5.9, stat.maxValue(), 0.0001);
		Assert.assertEquals(3.52, stat.meanValue(), 0.0001);
	}

	@Test
	public void testOnlyNegativeValues() {
		double[] data = {-10.0, -20.0, -30.0, -40.0};
		Statistic stat = new Statistic(data);
		Assert.assertEquals(-40.0, stat.minValue(), 0.0001);
		Assert.assertEquals(-10.0, stat.maxValue(), 0.0001);
		Assert.assertEquals(-25.0, stat.meanValue(), 0.0001);
	}

	@Test
	public void testLargeNumbers() {
		double[] data = {1000000.0, 2000000.0, 3000000.0};
		Statistic stat = new Statistic(data);
		Assert.assertEquals(1000000.0, stat.minValue(), 0.0001);
		Assert.assertEquals(3000000.0, stat.maxValue(), 0.0001);
		Assert.assertEquals(2000000.0, stat.meanValue(), 0.0001);
	}

	@Test
	public void testSmallNumbers() {
		double[] data = {0.001, 0.002, 0.003, 0.004};
		Statistic stat = new Statistic(data);
		Assert.assertEquals(0.001, stat.minValue(), 0.00001);
		Assert.assertEquals(0.004, stat.maxValue(), 0.00001);
		Assert.assertEquals(0.0025, stat.meanValue(), 0.00001);
	}

	@Test
	public void testWithZeros() {
		double[] data = {0.0, 0.0, 0.0};
		Statistic stat = new Statistic(data);
		Assert.assertEquals(0.0, stat.minValue(), 0.0001);
		Assert.assertEquals(0.0, stat.maxValue(), 0.0001);
		Assert.assertEquals(0.0, stat.meanValue(), 0.0001);
		Assert.assertEquals(0.0, stat.standardDeviation(), 0.0001);
	}

	@Test
	public void testUnsortedValues() {
		double[] data = {9.0, 2.0, 7.0, 1.0, 5.0};
		Statistic stat = new Statistic(data);
		Assert.assertEquals(1.0, stat.minValue(), 0.0001);
		Assert.assertEquals(9.0, stat.maxValue(), 0.0001);
		Assert.assertEquals(4.8, stat.meanValue(), 0.0001);
	}

	@Test
	public void testStandardDeviationExample() {
		double[] data = {10.0, 12.0, 23.0, 23.0, 16.0, 23.0, 21.0, 16.0};
		Statistic stat = new Statistic(data);
		Assert.assertEquals(18.0, stat.meanValue(), 0.0001);
		Assert.assertEquals(4.8989, stat.standardDeviation(), 0.001);
	}
}