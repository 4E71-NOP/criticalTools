package com.criticalTools.section.system;

/**
 * 
 * (FR) Cette classe propose un service de reconnaissance du système.<br>
 * <br>
 * (ENG) This class provides a scout service of the system.
 * 
 * @author Faust MARIA DE AREVALO
 */
public class SystemScout {
	private static SystemScout instance = null;
	private boolean updateDone = false;

	private String fileSeparator;
	private String javaClassPath;
	private String javaHome;
	private String javaVendor;
	private String javaVendorUrl;
	private String javaVersion;
	private String lineSeparator;
	private String osArch;
	private String osName;
	private String osVersion;
	private String pathSeparator;
	private String userDir;
	private String userHome;
	private String userName;

	private SystemScout() {
	}

	public static SystemScout getInstance() {
		if (instance == null) {
			instance = new SystemScout();
		}
		return instance;
	}

	/**
	 * (FR)Cette méthode lance toutes les requetes pour obtenir les informations du
	 * système.<br>
	 * <br>
	 * (ENG) This méthod runs all the requests to get the system informations.
	 */
	private void doScout() {
		this.fileSeparator = (String) System.getProperties().get("file.separator");
		this.javaClassPath = (String) System.getProperties().get("java.class.path");
		this.javaHome = (String) System.getProperties().get("java.home");
		this.javaVendor = (String) System.getProperties().get("java.vendor");
		this.javaVendorUrl = (String) System.getProperties().get("java.vendor.url");
		this.javaVersion = (String) System.getProperties().get("java.version");
		this.lineSeparator = (String) System.getProperties().get("line.separator");
		this.osArch = (String) System.getProperties().get("os.arch");
		this.osName = (String) System.getProperties().get("os.name");
		this.osVersion = (String) System.getProperties().get("os.version");
		this.pathSeparator = (String) System.getProperties().get("path.separator");
		this.userDir = (String) System.getProperties().get("user.dir");
		this.userHome = (String) System.getProperties().get("user.home");
		this.userName = (String) System.getProperties().get("user.name");
	}

	public String getAllInformation() {
		if (!updateDone) {
			doScout();
		}

		return "file.separator: '" + fileSeparator + "';\n" + "java.class.path: " + javaClassPath + ";\n"
				+ "java.home: " + javaHome + ";\n" + "java.vendor: " + javaVendor + ";\n" + "java.vendor.url: "
				+ javaVendorUrl + ";\n" + "java.version: " + javaVersion + ";\n" + "line.separator: '" + lineSeparator
				+ "';\n" + "os.arch: " + osArch + ";\n" + "os.name: " + osName + ";\n" + "os.version: " + osVersion
				+ ";\n" + "path.separator: '" + pathSeparator + "';\n" + "user.dir: " + userDir + ";\n" + "user.home: "
				+ userHome + ";\n" + "user.name: " + userName + ";\n";
	}

	private void checkUpdateDone() {
		if (updateDone == false) {
			doScout();
			updateDone = !updateDone;
		}
	}

	// -------------------------------------------------------------------------
	public String getFileSeparator() {
		checkUpdateDone();
		return fileSeparator;
	}

	public String getJavaClassPath() {
		checkUpdateDone();
		return javaClassPath;
	}

	public String getJavaHome() {
		checkUpdateDone();
		return javaHome;
	}

	public String getJavaVendor() {
		checkUpdateDone();
		return javaVendor;
	}

	public String getJavaVendorUrl() {
		checkUpdateDone();
		return javaVendorUrl;
	}

	public String getJavaVersion() {
		checkUpdateDone();
		return javaVersion;
	}

	public String getLineSeparator() {
		checkUpdateDone();
		return lineSeparator;
	}

	public String getOsArch() {
		checkUpdateDone();
		return osArch;
	}

	public String getOsName() {
		checkUpdateDone();
		return osName;
	}

	public String getOsVersion() {
		checkUpdateDone();
		return osVersion;
	}

	public String getPathSeparator() {
		checkUpdateDone();
		return pathSeparator;
	}

	public String getUserDir() {
		checkUpdateDone();
		return userDir;
	}

	public String getUserHome() {
		checkUpdateDone();
		return userHome;
	}

	public String getUserName() {
		checkUpdateDone();
		return userName;
	}

	@Override
	public String toString() {
		checkUpdateDone();
		return "systemScout [fileSeparator=" + fileSeparator + ", javaClassPath=" + javaClassPath + ", javaHome="
				+ javaHome + ", javaVendor=" + javaVendor + ", javaVendorUrl=" + javaVendorUrl + ", javaVersion="
				+ javaVersion + ", lineSeparator=" + lineSeparator + ", osArch=" + osArch + ", osName=" + osName
				+ ", osVersion=" + osVersion + ", pathSeparator=" + pathSeparator + ", userDir=" + userDir
				+ ", userHome=" + userHome + ", userName=" + userName + "]";
	}

}
