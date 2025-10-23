package de.wi25213.uebung07;

import java.util.Arrays;

//Aufgabe 2
public class Statistic {
	private double[] _data;

	public Statistic(double[] data) {
		_data = data;
	}

	public double minValue() {
		return Arrays.stream(_data).min().getAsDouble();
	}

	public double maxValue() {
		return Arrays.stream(_data).max().getAsDouble();
	}

	public double meanValue() {
		return Arrays.stream(_data).average().getAsDouble();
	}

	public double standardDeviation() {
		double mean = meanValue();
		double variance = Arrays.stream(_data).map(x -> Math.pow(x - mean, 2)).average().getAsDouble();
		return Math.sqrt(variance);
	}
}

/*Aufgabe 3: 
Um die Werte nicht bei jedem Aufruf neu berrechnen zu müssen, 
können die Ergebnisse der Berechnungen in Instanzvariablen zwischengespeichert werden, 
welche entweder im Konstruktor oder beim erstmaligen Aufruf der jeweiligen Methode initialisiert werden.
Bei nachfolgenden Aufrufen wird dann der gespeicherte Wert zurückgegeben.
*/

