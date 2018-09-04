package com.criticalTools.section.system;

/**
 * 
 * (FR) Cette classe propose des services degestion de la mémoire.<br>
 * <br>
 * (ENG) This class provides memory managment services.
 * 
 * @author Faust MARIA DE AREVALO
 */
public class MemoryService {

	private static MemoryService instance = null;

	private MemoryService() {
	}

	public static MemoryService getInstance() {
		if (instance == null) {
			instance = new MemoryService();
		}
		return instance;
	}

	/**
	 * (FR) Exécution de GC. GC ne devrait pas être utilisé sur des système orienté
	 * serveur car cela pourrait éventuellement nuire à la qualité de service. <br>
	 * <br>
	 * (ENG) GC execution. GC should not be used on a service platform as it can
	 * disrupt the quality of service.
	 */
	public void executeSystemGc() {

		long memAvant = Runtime.getRuntime().freeMemory();
		long tempsAvant = System.currentTimeMillis();
		System.gc();
		long tempsApres = System.currentTimeMillis();
		long memApres = Runtime.getRuntime().freeMemory();

		String str = "Mémoire libre avant GC: " + (memAvant / 1048576) + "Mo / après GC: " + (memApres / 1048576)
				+ "Mo";

		long memBilan = memAvant - memApres;
		if (memBilan < 0) {
			str += " gain de : " + Math.abs(memBilan / 1048576) + "Mo.";
		} else {
			str += " Allocation de : " + (memBilan / 1048576) + "Mo.";
		}
		str += " Temps d'exécution: " + (tempsApres - tempsAvant) + "ms";

		System.out.println(str);
	}

	/**
	 * (FR) Retourne une chaine décrivant l'état de la mémoire.<br>
	 * <br>
	 * (ENG) Returns a string descibing the memory state.
	 * 
	 * @return String
	 */
	public String getRuntime() {
		Runtime rt = Runtime.getRuntime();

		long totalByte = rt.totalMemory();
		long freeByte = rt.freeMemory();
		long maxByte = rt.maxMemory();

		long totalMo = totalByte / 1024 / 1024;
		long maxMo = maxByte / 1024 / 1024;

		long usedMo = (totalByte - freeByte) / 1024 / 1024;
		double percent = freeByte / totalByte * 100;
		return "Used Memory: " + usedMo + "Mo on " + totalMo + "Mo (" + percent + "%). JavaMachine max: " + maxMo
				+ "Mo.";
	}

}
