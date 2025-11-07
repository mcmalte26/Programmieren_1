package de.wi25213;

import java.util.Arrays;

public class Uebung04 {
	private static final char ASTERIX = '█';

	public static void main(String[] args) {
		int[] values = { 50, 50, 40, 60 };
		printBarChart(values, ASTERIX);
		IO.println();
		printVerticalBarChart(values, ASTERIX);

	}

	// Aufgabe 1
	public static void printBarChart(int[] values, char character) {
		int total = Arrays.stream(values).sum();
		for (int value : values) {
			double percentage = calculatePercentage(value, total);

			StringBuilder sb = new StringBuilder();
			int amount = (int) Math.round(percentage);
			sb.append(String.valueOf(character).repeat(amount));
			sb.append(" ").append(value).append(" (").append(percentage).append("%)");

			IO.println(sb.toString());
		}
	}

	// Aufgabe 2
	public static void printVerticalBarChart(int[] values, char character) {
		int total = Arrays.stream(values).sum();

		int[] chart_values = Arrays.stream(values).mapToDouble(value -> calculatePercentage(value, total))
				.mapToInt(percentage -> (int) Math.round(percentage)).toArray();

		int max = Arrays.stream(chart_values).max().orElse(0);

		for (int row = max; row > 0; row--) {
			StringBuilder line = new StringBuilder();
			for (int column = 0; column < values.length; column++) {
				if (chart_values[column] >= row) {
					line.append(character).append(character).append("   ");
				} else {
					line.append("     ");
				}
			}
			IO.println(line.toString());
		}

		StringBuilder bottomLine = new StringBuilder();
		for (int column = 0; column < values.length; column++) {
			bottomLine.append(values[column]);
			if (column < values.length - 1) {
				bottomLine.append("   ");
			}
		}
		IO.println(bottomLine.toString());
	}

	public static double calculatePercentage(int value, int total) {
		if (total == 0) {
			return 0;
		}
		return Math.round((value * 100.0) / total);
	}

	// Aufgabe 3
	public static int[][] matrixMultiplication(int[][] matrixA, int[][] matrixB) {
		int rowsA = matrixA.length;
		int columnsA = matrixA[0].length;
		int rowsB = matrixB.length;
		int columnsB = matrixB[0].length;

		if (columnsA != rowsB) {
			throw new IllegalArgumentException("Diese beiden Matritzen können nicht multipliziert werden.");
		}

		int[][] result = new int[rowsA][columnsB];
		for (int row = 0; row < rowsA; row++) {
			for (int column = 0; column < columnsB; column++) {
				result[row][column] = 0;
				for (int colA = 0; colA < columnsA; colA++) {
					result[row][column] += matrixA[row][colA] * matrixB[colA][column];
				}

			}
		}
		return result;
	}

	public static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int value : row) {
				IO.print(value + "\t");
			}
			IO.println();
		}
	}

	// Aufgabe 4a
	public static int[][] rotateMatrixBy90Degrees(int[][] matrix) {
		int n = matrix.length;

		int[][] result = new int[n][n];

		for (int column = 0; column < n; column++) {
			for (int row = n - 1; row >= 0; row--) {
				int index = (n - 1) - row;
				result[column][index] = matrix[row][column];
			}
		}
		return result;
	}

	// Aufgabe 4b
	public static int[][] readQuadraticMatrix() {
		int n = Integer.parseInt(IO.readln("Bitte Matrixgröße angeben: "));
		int[][] inputMatrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] input = IO.readln("Bitte Werte für Zeile " + (i + 1) + " eingeben (getrennt durch Leerzeichen): ")
					.split(" ");
			inputMatrix[i] = Arrays.stream(input).mapToInt(value -> Integer.parseInt(value)).toArray();
		}
		return inputMatrix;
	}

	public enum Muenze {
		FUENFER(2, 5), ZEHNER, ZWANZIGER, FUENFZIGER, EIN_FRAENKLER, ZWEI_FRAENKLER;

		private final int _weight;
		private final int _value;

		Muenze(int weight, int value) {
			_weight = weight;
			_value = value;
		}

		Muenze() {
			_weight = 0;
			_value = 0;
		}

		public int getWeight() {
			return _weight;
		}

		public int getValue() {
			return _value;
		}

		public String toString() {
			return this.name() + ": Gewicht=" + _weight + " Farbe:";
		}
	}
}