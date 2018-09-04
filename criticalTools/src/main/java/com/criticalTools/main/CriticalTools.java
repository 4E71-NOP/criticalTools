package com.criticalTools.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.criticalTools.agent.MySQLCnx;
import com.criticalTools.section.convert.DateManipulation;
import com.criticalTools.section.convert.NumberRepesentation;
import com.criticalTools.section.hardware.HardwareInformation;
import com.criticalTools.section.system.MemoryService;
import com.criticalTools.section.system.SystemScout;

/**
 * (FR) Faust MARIA DE ARAVALO - Tous droits réservés. Ce projet se présente
 * sous la forme d'une librairie qui contient un certain nombre de
 * fonctionnalités pouvant aider le programmeur sur plusieurs thématiques<br>
 * <br>
 * Reconnaissance : Système hote<br>
 * Reconnaissance : Hardware<br>
 * Fonctions de représentation / conversion de nombre : depuis la base 2 jusqu'à
 * 35 (hex dec bin dozenal etc;) <br>
 * Fonctions de manipulation de date<br>
 * Fonctions de nettoyage de la mémoire<br>
 * <br>
 * <br>
 * <br>
 * (ENG) Faust MARIA DE ARAVALO - All rights reserved. This project is delivered
 * as a library that contains a number of functionalities to help the programmer
 * on several aspects.<br>
 * <br>
 * Scouting : Host<br>
 * Scouting : Hardware<br>
 * Representation / Convertion number functionalities : from base 2 to 35 (hex
 * dec bin dozenal etc;)<br>
 * Date and timestamps manipulation<br>
 * Memory cleaning functionalities<br>
 * 
 * @author Faust MARIA DE ARAVALO
 */

public class CriticalTools {

	public static void main(String[] args) {
		// Init

		SystemScout ss = SystemScout.getInstance();
		MemoryService ms = MemoryService.getInstance();
		HardwareInformation hi = HardwareInformation.getInstance();
		DateManipulation dm = DateManipulation.getInstance();
		NumberRepesentation nr = NumberRepesentation.getInstance();

		ss.getAllInformation();
		hi.update();

		// List System.getenv()
		// https://docs.oracle.com/javase/tutorial/essential/environment/env.html
		/*
		 * Map<String, String> env = System.getenv(); for (String envName :
		 * env.keySet()) { System.out.format("%s=%s%n", envName, env.get(envName)); }
		 * 
		 * 
		 * System.out.println(SystemScout.getInstance().getAllInformation());
		 * 
		 * System.out.println(ms.getRuntime()); ms.executeSystemGc();
		 * 
		 * System.out.println(hi.toString());
		 * System.out.println(hi.getRuntimeCpuPopulation());
		 * 
		 * String dateOk = "2018-05-14"; String dateNok = "2018/05/14"; String timeOk =
		 * "22:13:14"; String dateTimeOk = dateOk + " " + timeOk; String dateTimeNok =
		 * dateNok + " " + timeOk; long timestampLong = 1526328794000l; Date d = new
		 * Date(); Timestamp t = Timestamp.valueOf(dateTimeOk);
		 * System.out.println(t.toString() + " vs " + dm.TimestampToStringTimeOnly(t));
		 * System.out.println(dateTimeOk + " vs " + dm.TimestampToStringDateTime(t));
		 * System.out.println(timestampLong + " vs " +
		 * dm.TimestampToLongMillisecond(t));
		 */

		try {
			MySQLCnx.makeCnxUrl();
			Connection cnx = MySQLCnx.getConnexion();
			Statement st01 = cnx.createStatement();
			ResultSet rs01 = st01.executeQuery("SELECT * FROM code_test.utilisateurs;");
			System.out.println("Main:\n" + rs01.getMetaData().toString());
			rs01.close();
			st01.close();
		} catch (Exception e) {
			System.err.println("Main:\n" + e.getMessage());
		}
	}

}
