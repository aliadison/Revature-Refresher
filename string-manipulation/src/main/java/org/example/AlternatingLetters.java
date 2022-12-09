package org.example;

public class AlternatingLetters {
	public static void main(String[] args) {
		String s1 = "Spongebob";
		String s2 = "spongebob";

		System.out.println(alternate(s1));
		System.out.println(alternate(s2));
	}

	// Exercise, fill out this method
	// ex: input -> Spongebob, output -> SpOnGeBoB
	// ex: input -> spongebob, output -> sPoNgEbOb
	public static String alternate(String s) {
		char c = s.charAt(0);
		String newStr = "" + c;
		for (int i = 1; i < s.length(); i++) {
			if (c == Character.toUpperCase(c)) {
				newStr += Character.toLowerCase(s.charAt(i));
				c = Character.toLowerCase(s.charAt(i));
			} else {
				newStr += Character.toUpperCase(s.charAt(i));
				c = Character.toUpperCase(s.charAt(i));
			}
		}
		return newStr;
	}
}
