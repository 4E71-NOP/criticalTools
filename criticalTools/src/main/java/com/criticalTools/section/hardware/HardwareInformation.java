package com.criticalTools.section.hardware;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.criticalTools.agent.WindowsPowerShell;
import com.criticalTools.section.system.SystemScout;

/**
 * 
 * (FR)Cette classe permet de récupérer des informations sur la machine
 * hote.<br>
 * <br>
 * (ENG) This class allows to get the host machine informations.
 * 
 * @author Faust MARIA DE AREVALO<br>
 */
public class HardwareInformation {
	private static HardwareInformation instance = null;
	private SystemScout ss = null;
	private boolean updateDone = false;

	private String vendorId;
	private String modelName;
	private int numberOfCpu;
	private String cacheSize;
	private String flags;
	private Map<String, String> cpuMhzSnapshot = new HashMap<String, String>(); // CPU id , freq

	private HardwareInformation() {
	}

	public static HardwareInformation getInstance() {
		if (instance == null) {
			instance = new HardwareInformation();
		}
		return instance;
	}

	// -------------------------------------------------------------------------
	/**
	 * (FR)Cette méthode vérifie sur quel OS se trouve le programme et entame la
	 * récupération des informations<br>
	 * <br>
	 * (ENG) This method checks what is the host OS on which the program runs and
	 * start to harvest the informations.
	 */
	public void getCpuInformations() {
		numberOfCpu = 0; // reset
		cpuMhzSnapshot.clear();
		ss = SystemScout.getInstance();

		String osGlobalName = ss.getOsName();
		if (osGlobalName.matches(".?Windows.*")) {
			System.out.println("Win");
			osGlobalName = "Windows";
		}

		switch (osGlobalName) {
		case "Linux":
			System.out.println("Linux system, opening /proc/cpuinfo");

			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader("/proc/cpuinfo"));

				String str;
				while ((str = br.readLine()) != null) {
					if (str.matches("^vendor_id.*")) {
						vendorId = str.replaceAll("^vendor_id.*\\s: ", "");
					} else if (str.matches("^model name.*")) {
						modelName = str.replaceAll("^model name.*\\s: ", "");
					} else if (str.matches("^processor.*")) {
						numberOfCpu++;
					} else if (str.matches("^cache size.*")) {
						cacheSize = str.replaceAll("^cache size.*\\s: ", "");
					} else if (str.matches("^flags.*")) {
						flags = str.replaceAll("^flags.*\\s: ", "");
					} else if (str.matches("^cpu MHz.*")) {
						cpuMhzSnapshot.put("CPU" + numberOfCpu, str.replaceAll("^cpu MHz.*\\s: ", ""));
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (br != null) {
						br.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			break;
		case "Windows":
			System.out.println("Windows system, Trying PowerShell comands");

			WindowsPowerShell wps = WindowsPowerShell.getInstance();
			try {
				List<String> winStr = wps.Execute("Get-WmiObject win32_processor");
				for (String s : winStr) {
					if (s.matches("^Manufacturer.*")) {
						vendorId = s.replaceAll("^Manufacturer.*\\s: ", "");
					} else if (s.matches("^Name.*")) {
						modelName = s.replaceAll("^Name.*\\s: ", "");
					}
					System.out.println(s);

				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			// modelName = System.getenv("PROCESSOR_IDENTIFIER") + " / " +
			// System.getenv("PROCESSOR_PROCESSOR_ARCHITECTURE")
			// + " / " + System.getenv("PROCESSOR_REVISION");
			numberOfCpu = Integer.parseInt(System.getenv("NUMBER_OF_PROCESSORS"));
			cacheSize = "...";
			flags = "...";

			break;
		}
	}

	public void update() {
		getCpuInformations();
	}

	private void checkUpdateDone() {
		if (updateDone == false) {
			getCpuInformations();
			updateDone = !updateDone;
		}
	}

	public String getRuntimeCpuPopulation() {
		return "CPU population : " + Runtime.getRuntime().availableProcessors();
	}

	// -------------------------------------------------------------------------
	public String getVendorId() {
		checkUpdateDone();
		return vendorId;
	}

	public String getModelName() {
		checkUpdateDone();
		return modelName;
	}

	public int getNumberOfCpu() {
		checkUpdateDone();
		return numberOfCpu;
	}

	public String getCacheSize() {
		checkUpdateDone();
		return cacheSize;
	}

	public String getFlags() {
		checkUpdateDone();
		return flags;
	}

	public Map<String, String> getCpuMhz() {
		checkUpdateDone();
		return cpuMhzSnapshot;
	}

	@Override
	public String toString() {
		return "HardwareInformation [\nvendorId=" + vendorId + ",\n modelName=" + modelName + ",\n numberOfCpu="
				+ numberOfCpu + ",\n cacheSize=" + cacheSize + ",\n flags=" + flags + ",\n cpuMhz=" + cpuMhzSnapshot
				+ "\n]";
	}

}
