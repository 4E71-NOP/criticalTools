package com.criticalTools.agent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Faust MARIA DE AREVALO<br>
 *         (FR) Cette classe est un gestionnaire de connexion MySQL.<br>
 * 		<br>
 *         (ENG)This class is a MySQL connection manager.<br>
 */
public class MySQLCnx {

	public static Connection cnx = null;

	private static String bddServeur = "localhost";
	private static String bddProtocol = "mysql";
	private static String bddNom = "code_test";
	private static String bddUtilisateur = "root";
	private static String bddMdp = "1a2b3c4d";
	private static String bddOptions = "";
	private static String cnxUrl = "";

	/**
	 * (FR) Crée une chaine de connexion pour l'amorcage de la connexion à la
	 * BDD.<br>
	 * <br>
	 * (ENG)Create the connection string to be used for the DB handshake.<br>
	 */
	public static void makeCnxUrl() {
		cnxUrl = "jdbc:" + bddProtocol + "://" + bddServeur + "/" + bddNom + "?user=" + bddUtilisateur + "&password="
				+ bddMdp;
		if (bddOptions.length() > 0) {
			cnxUrl += "&" + bddOptions;
		}
	}

	public static Connection getConnexion()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		if (cnx == null) {
			makeCnxUrl();

			try {
				// Class.forName("com.mysql.jdbc.Driver");
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			} catch (ClassNotFoundException e) {
				System.out
						.println("Where is the MySQL JDBC Driver? Please consider adding the driver to your project.");
				e.printStackTrace();
			}

			// System.out.println("MySQLCnx() : com.mysql.jdbc.Driver : " + cnxUrl);
			cnx = DriverManager.getConnection(cnxUrl);
			System.out.println("MySQLCnx() : Création de la connexion");
		} else {
			System.out.println("MySQLCnx() : Réutilisation de la connexion");
		}
		return cnx;
	}

	public static String getInfos() {
		return "Informations de la connexion : " + cnxUrl;
	}

	public static String getBddServeur() {
		return bddServeur;
	}

	public static void setBddServeur(String bddServeur) {
		MySQLCnx.bddServeur = bddServeur;
	}

	public static String getBddProtocol() {
		return bddProtocol;
	}

	public static void setBddProtocol(String bddProtocol) {
		MySQLCnx.bddProtocol = bddProtocol;
	}

	public static String getBddNom() {
		return bddNom;
	}

	public static void setBddNom(String bddNom) {
		MySQLCnx.bddNom = bddNom;
	}

	public static String getBddUtilisateur() {
		return bddUtilisateur;
	}

	public static void setBddUtilisateur(String bddUtilisateur) {
		MySQLCnx.bddUtilisateur = bddUtilisateur;
	}

	public static String getBddMdp() {
		return bddMdp;
	}

	public static void setBddMdp(String bddMdp) {
		MySQLCnx.bddMdp = bddMdp;
	}

	public static String getBddOptions() {
		return bddOptions;
	}

	public static void setBddOptions(String bddOptions) {
		MySQLCnx.bddOptions = bddOptions;
	}

	public static String getCnxUrl() {
		return cnxUrl;
	}

	public static void setCnxUrl(String cnxUrl) {
		MySQLCnx.cnxUrl = cnxUrl;
	}

	// ----------------------------------------------------------------------------------------
	// Récupération et affichage des données

}