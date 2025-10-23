package de.wi25213;

public class GGT {
	static int ggtRekursiv(int a, int b) {
		int rest = a % b;
		if (rest == 0)
			return b;
		else
			return ggtRekursiv(b, rest);
	}

	static int ggtIterativ(int a, int b) {
		int rest = a % b;
		while (rest != 0) {
			a = b;
			b = rest;
			rest = a % b;
		}
		return b;
	}
}