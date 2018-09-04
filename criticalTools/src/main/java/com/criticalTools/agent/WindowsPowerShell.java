package com.criticalTools.agent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * (FR) Cette classe est un gestionnaire d'éxécution d'un PowerShell
 * Windows.<br>
 * <br>
 * (ENG) This class is a execution manager of a Windows PowerShell.<br>
 * 
 * @author Faust MARIA DE AREVALO<br>
 */
public class WindowsPowerShell {
	private static WindowsPowerShell instance = null;

	private WindowsPowerShell() {
	}

	public static WindowsPowerShell getInstance() {
		if (instance == null) {
			instance = new WindowsPowerShell();
		}
		return instance;
	}

	/**
	 * (FR) Exécute un PowerShell Windows avec une ligne de commande fournie par
	 * l'utilisateur.<br>
	 * <br>
	 * (ENG)Execute a Windows PowerShell with a complementary command line given by
	 * the user.<br>
	 * 
	 * @param commandString
	 * @return List<String>
	 * @throws IOException
	 */
	public List<String> Execute(String commandString) throws IOException {
		List<String> result = new ArrayList<String>();

		String command = "powershell.exe " + commandString;
		Process powerShellProcess = Runtime.getRuntime().exec(command);

		powerShellProcess.getOutputStream().close();
		String line;

		BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
		while ((line = stdout.readLine()) != null) {
			result.add(line);
		}
		stdout.close();

		BufferedReader stderr = new BufferedReader(new InputStreamReader(powerShellProcess.getErrorStream()));
		while ((line = stderr.readLine()) != null) {
			result.add(line);
		}
		stderr.close();

		return result;
	}
}
