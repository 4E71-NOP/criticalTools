package com.criticalTools.section.convert;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * (FR) Cette classe permet de manipuler les représentations des nombres dans
 * différente base.<br>
 * <br>
 * (ENG) This classe allows representation manipulation of number in several
 * bases.<br>
 *
 * @author Faust MARIA DE AREVALO<br>
 */
public class NumberRepesentation {
	private static NumberRepesentation instance = null;

	private String[] baseSymbols = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
			"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	private Map<String, Integer> valSymbols = new HashMap<String, Integer>();

	private NumberRepesentation() {
		int c = 0;
		for (String elm : baseSymbols) {
			valSymbols.put(elm, c);
			c++;
		}
		// System.out.println(valSymbols.toString());
	}

	public static NumberRepesentation getInstance() {
		if (instance == null) {
			instance = new NumberRepesentation();
		}
		return instance;
	}

	// -------------------------------------------------------------------------
	// Base Converter
	/**
	 * (FR) Retourne une chaine représentant le nombre donné. Si le nombre est un
	 * type int la base source est 'décimale'. Si c'est une chaine qui est fournie,
	 * la base source peut aller de 2 à 36.<br>
	 * <br>
	 * (ENG) Returns a String representation of the given number. If the given
	 * number is an Integer the source base is Decimal. If it is a String the source
	 * base can be anything up to 36.
	 * 
	 * @param n
	 *            Number to process
	 * @param bSrc
	 *            Base Source
	 * @param bDst
	 *            Base Destination
	 * @return A string containing the converted number.
	 */
	public String BaseConvertion(String n, int bSrc, int bDst) {
		String str = "Error. Base > 0 && Base <= 35.";
		if (bSrc > 0 && bSrc <= 35 && bDst > 0 && bDst <= 35) {
			try {
				return intToSpecificBase(fromBasetoDecimalInt(n, bSrc), bDst);
			} catch (RuntimeException r) {
				str = "Err: Given number doesn't fit source Base.";
				System.out.println(r.getMessage());
			}
		}
		return str;
	}

	public String BaseConvertion(int n, int bDst) {
		String str = "Error. Base > 0 && Base <= 35.";
		if (bDst > 0 && bDst <= 35) {
			return intToSpecificBase(n, bDst);
		}
		return str;
	}

	/**
	 * (FR) Retourne une chaine représentant le nombre dans la base désirée.<br>
	 * <br>
	 * (ENG) Returns a String representation in the desired base.<br>
	 * see: https://www.mathsisfun.com/numbers/convert-base.php
	 * 
	 * @param n
	 *            Number to process
	 * @param b
	 *            Base target
	 * @return string representing the number in the desired base.
	 */
	private String intToSpecificBase(int n, int b) {
		String str = "";
		int factor = 1;
		while (n > 0) {
			str = baseSymbols[(n % b)] + str;
			n /= b;
			factor *= 10;
		}
		return str;
	}

	/**
	 * (FR) Cette méthode prend une expression représentant un nombre entier et le
	 * converti en in type Integer<br>
	 * <br>
	 * (ENG) This method takes an expression representing an Integer and converts it
	 * to a decimal Integer.
	 * 
	 * @param n
	 *            Number to process
	 * @param bSrc
	 *            Base Source
	 * @return
	 */
	private int fromBasetoDecimalInt(String n, int bSrc) {
		int p = 1;
		int cpt = n.length() - 1;
		int r = 0;
		for (int i = cpt; i >= 0; i--) {
			// System.out.println("n="+n+"; i="+i+"; p="+p+"; cpt="+cpt+";
			if (valSymbols.get(n.substring(i, i + 1).toUpperCase()) > bSrc - 1) {
				throw new RuntimeException("Err: Given number doesn't fit source Base.");
			} else {
				r += valSymbols.get(n.substring(i, i + 1).toUpperCase()) * p;
				p *= bSrc;
			}
		}
		return r;
	}

}
