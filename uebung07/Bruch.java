package de.wi25213.uebung07;

//Aufgabe 1
public class Bruch {
	
	private int zaehler;
	private int nenner;

	public Bruch(int zaehler, int nenner) {
		if (nenner == 0) {
			throw new IllegalArgumentException("Nenner darf nicht null sein.");
		}
		this.zaehler = zaehler;
		this.nenner = nenner;
	}

	public int getZaehler() {
		return zaehler;
	}

	public int getNenner() {
		return nenner;
	}

}
