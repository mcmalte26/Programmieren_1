package de.wi25213.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import de.wi25213.Uebung04;

public class Uebung04_Tests {

	@Test
	public void testValidMatrixMultiplication() {
		int[][] matA = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] matB = { { 6, -1 }, { 3, 2 }, { 0, -3 } };
		int[][] expected = { { 12, -6 }, { 39, -12 } };
		Assert.assertArrayEquals(expected, Uebung04.matrixMultiplication(matA, matB));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMatrixMultiplication() {
		int[][] matA = { { 1, 2 }, { 1, 2 } };
		int[][] matB = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
		Uebung04.matrixMultiplication(matA, matB);
	}
	
	@Test
	public void testIdentityMatrixMultiplication() {
		int[][] matA = { { 1, 2 }, { 3, 4 } };
		int[][] identity = { { 1, 0 }, { 0, 1 } };
		int[][] expected = { { 1, 2 }, { 3, 4 } };
		Assert.assertArrayEquals(expected, Uebung04.matrixMultiplication(matA, identity));
	}
	
	@Test
	public void testZeroMatrixMultiplication() {
		int[][] matA = { { 1, 2 }, { 3, 4 } };
		int[][] zero = { { 0, 0 }, { 0, 0 } };
		int[][] expected = { { 0, 0 }, { 0, 0 } };
		Assert.assertArrayEquals(expected, Uebung04.matrixMultiplication(matA, zero));
	}
	
	@Test
	public void testSquareMatrixMultiplication() {
		int[][] matA = { { 1, 2 }, { 3, 4 } };
		int[][] matB = { { 5, 6 }, { 7, 8 } };
		int[][] expected = { { 19, 22 }, { 43, 50 } };
		Assert.assertArrayEquals(expected, Uebung04.matrixMultiplication(matA, matB));
	}
	
	@Test
	public void testSingleElementMatrix() {
		int[][] matA = { { 5 } };
		int[][] matB = { { 3 } };
		int[][] expected = { { 15 } };
		Assert.assertArrayEquals(expected, Uebung04.matrixMultiplication(matA, matB));
	}
	
	@Test
	public void testRotateMatrixBy90Degrees() {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] expected = { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
		Assert.assertArrayEquals(expected, Uebung04.rotateMatrixBy90Degrees(matrix));
	}
	
	@Test
	public void testRotate2x2Matrix() {
		int[][] matrix = { { 1, 2 }, { 3, 4 } };
		int[][] expected = { { 3, 1 }, { 4, 2 } };
		Assert.assertArrayEquals(expected, Uebung04.rotateMatrixBy90Degrees(matrix));
	}
	
	@Test
	public void testCalculatePercentage() {
		assertEquals(25.0, Uebung04.calculatePercentage(25, 100), 0.01);
		assertEquals(50.0, Uebung04.calculatePercentage(50, 100), 0.01);
		assertEquals(0.0, Uebung04.calculatePercentage(0, 100), 0.01);
		assertEquals(0.0, Uebung04.calculatePercentage(5, 0), 0.01);
	}

}