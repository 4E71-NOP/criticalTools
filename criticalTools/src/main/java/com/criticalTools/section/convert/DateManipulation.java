package com.criticalTools.section.convert;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * (FR) Cette classe contient les fonction pour convertir date et
 * timestamps.<br>
 * <br>
 * (ENG) This class contains the functions to convert dates and timestamps.<br>
 *
 * @author Faust MARIA DE AREVALO<br>
 */
public class DateManipulation {
	private static DateManipulation instance = null;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	private DateManipulation() {
	}

	public static DateManipulation getInstance() {
		if (instance == null) {
			instance = new DateManipulation();
		}
		return instance;
	}

	// -----------------------------------------------------------------------------------------------
	// From a Timestamp
	/**
	 * (FR) Retourne un type SimpleDateFormat basé sur le Timestamp et la chaine de
	 * formattage donné.<br>
	 * <br>
	 * (ENG) Returns a SimpleDateFormat based on the given Timestamp and the String
	 * representing the output format.
	 * 
	 * @param t
	 * @param format
	 * @return SimpleDateFormat
	 */
	public String TimestampToSimpleDateFormat(Timestamp t, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(t);
	}

	/**
	 * (FR) Prend un Timestamp et le converti dans un format Timestamp Unix (depuis
	 * Epoch). La précision est la milliseconde.<br>
	 * <br>
	 * (ENG) Takes a Timestamp and converts it to a Unix like timestamp (from
	 * Epoch). This one precision is milliseconds.<br>
	 * 
	 * @param t
	 * @return long
	 */
	public long TimestampToLongMillisecond(Timestamp t) {
		return (long) t.getTime();
	}

	/**
	 * (FR) Prend un Timestamp et le converti dans un format Timestamp Unix (depuis
	 * Epoch). La précision est la seconde.<br>
	 * <br>
	 * (ENG) Takes a Timestamp and converts it to a Unix like timestamp (from
	 * Epoch). This one precision is seconds.<br>
	 * 
	 * @param t
	 * @return long
	 */
	public long TimestampToLongSecond(Timestamp t) {
		return (long) t.getTime() / 1000;
	}

	// -----------------------------------------------------------------------------------------------
	// From a string

	/**
	 * (FR) Retourne un type TimeStamp basé sur la chaine de formattage représentant
	 * le format de sortie. La méthode remplace '/' par '-' pour corriger les typos
	 * mais ne fera pas d'analyse de la chaine. L'utilisateur doit fournir une
	 * chaine de formattage compatible.<br>
	 * <br>
	 * (ENG) Returns a Timestamp based on the given String representing the output
	 * format. It replaces '/' by '-' to fix typos. But it will not analyze the
	 * String. The user must give a compatible String.<br>
	 * 
	 * @param s
	 * @return Timestamp
	 */
	public Timestamp StringToTimestamp(String s) {
		s = s.replace("/", "-");
		return Timestamp.valueOf(s);
	}

	/**
	 * (FR) Retourne un type LocalDateTime basé sur la chaine de formattage
	 * donnée.<br>
	 * <br>
	 * (ENG) Returns a LocalDateTime based on the given String representing the
	 * output format.<br>
	 * 
	 * @param str
	 * @return LocalDateTime
	 */
	public LocalDateTime StringToLocaDateTime(String str) {
		return LocalDateTime.parse(str, formatter);
	}

	/**
	 * (FR) Retourne un type LocalDate basé sur la chaine de formattage donnée.<br>
	 * <br>
	 * (ENG) Returns a LocalDate based on the given String representing the output
	 * format.<br>
	 * 
	 * @param str
	 * @return LocalDate
	 */
	public LocalDate StringToLocaDate(String str) {
		return LocalDate.parse(str, formatter);
	}

	/**
	 * (FR) Retourne un type LocalTime basé sur la chaine de formattage donnée.<br>
	 * <br>
	 * (ENG) Returns a LocalTime based on the given String representing the output
	 * format.<br>
	 * 
	 * @param str
	 * @return LocalTime
	 */
	public LocalTime StringToLocaTime(String str) {
		return LocalTime.parse(str, formatter);
	}

}
