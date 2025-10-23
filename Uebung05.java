package de.wi25213;

public class Uebung05 {


	public static void main(String[] args) {
	}

	// Aufgabe 2
	public static String toBinary(int n) {
		if (n == 0 || n == 1) {
			return String.valueOf(n);
		}
		return toBinary(n / 2) + (n % 2);
	}

	// Aufgabe 3
	public static double potenz(double zahl, int pot) {
		if (pot == 0) {
			return 1;
		} else if (pot == 1) {
			return zahl;
		} else {
			return zahl * potenz(zahl, pot - 1);
		}
	}

	// Augabe 4
	public static int quersumme(int zahl) {
		if (zahl != 0) {
			return quersumme(zahl / 10) + zahl % 10;
		}
		return zahl;
	}

	//Aufgabe 5
	public static boolean isPrime(int zahl) {
		if(zahl == 0 | zahl == 1) {
			return false;
		}
		
		for(int i = zahl-1; i>1;i--) {
			if(zahl % i == 0) {
				return false;
			}
		}
		return true;
	}
}