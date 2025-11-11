package de.wi25213;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Uebung13 {
	// Aufgabe 1
	public static String copyString(String s, int amount) {
		return s.repeat(amount);
	}

	// Aufgabe 2
	public static boolean doubleX(String s) {
		if (!s.contains("x")) {
			return false;
		}
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length - 1; i++) {
			if (chars[i] == 'x' && chars[i + 1] == 'x') {
				return true;
			}
		}
		return false;
	}

	// Aufgabe 3
	public static int maxBlock(String s) {
		if (s.isEmpty()) {
			return 0;
		}

		char[] chars = s.toCharArray();
		char current = chars[0];
		int maxCounter = 0;
		int counter = 1;

		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == current) {
				counter++;
			} else {
				if (maxCounter < counter) {
					maxCounter = counter;
				}
				counter = 1;
				current = chars[i];
			}
		}
		return maxCounter;
	}

	// Aufgabe 4
	public static String explosion(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.substring(0, i));
		}
		sb.append(s);
		return sb.toString();
	}

	// Aufgabe 5
	public static boolean arrayPattern(int[] zahlen, int[] muster) {
	    if (zahlen.length < muster.length) {
	        return false;
	    }

	    for (int i = 0; i <= zahlen.length - muster.length; i++) {
	        boolean found = true;
	        for (int j = 0; j < muster.length; j++) {
	            if (zahlen[i + j] != muster[j]) {
	            	found = false;
	                break;
	            }
	        }
	        if (found) {
	            return true;
	        }
	    }
	    return false;
	}
	
	//Aufgabe 6
	public static boolean arrayRepeats(int[] array, int repeat) {
	    return Arrays.stream(array)
	            .boxed()
	            .collect(Collectors.groupingBy(z -> z, Collectors.counting()))
	            .values()
	            .stream()
	            .anyMatch(count -> count >= repeat);
	}
}