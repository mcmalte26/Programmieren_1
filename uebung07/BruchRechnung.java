package de.wi25213.uebung07;

//Aufgabe 1
public class BruchRechnung {

	public static Bruch init(int zaehler, int nenner) {
		if (nenner == 0) {
			throw new IllegalArgumentException("Nenner darf nicht null sein.");
		}
		if (nenner < 0) {
			zaehler = -zaehler;
			nenner = -nenner;
		}
		int g = berechneGGT(Math.abs(zaehler), Math.abs(nenner));
		zaehler /= g;
		nenner /= g;
		return new Bruch(zaehler, nenner);
	}

	public static String toString(Bruch b) {
		StringBuilder sb = new StringBuilder();
		sb.append(b.getZaehler());
		sb.append('/');
		sb.append(b.getNenner());
		return sb.toString();
	}

	public static Bruch multTo(Bruch a, Bruch b) {
		int z = a.getZaehler() * b.getZaehler();
		int n = a.getNenner() * b.getNenner();
		return init(z, n);
	}

	public static Bruch addTo(Bruch a, Bruch b) {
		int z = a.getZaehler() * b.getNenner() + b.getZaehler() * a.getNenner();
		int n = a.getNenner() * b.getNenner();
		return init(z, n);
	}

	private static int berechneGGT(int a, int b) {
		if (a == 0) {
			return b == 0 ? 1 : b;
		}
		if (b == 0) {
			return a;
		}
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return Math.abs(a);
	}

}