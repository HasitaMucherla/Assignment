package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReadUtility {

	static String landingURL = null;
	static String userID = null;
	static String password = null;
	static String badPassword = null;
	static String browser = null;
	static String driverProp = null;
	static String driverPath = null;

	public static void initConfigFiles() {

		Properties urlProps = new Properties();
		Properties credentialsProps = new Properties();
		Properties driverProps = new Properties();

		try {
			urlProps.load(new FileInputStream("configs\\Urls.properties"));
			landingURL = urlProps.getProperty("LandingURL");
			
			credentialsProps.load(new FileInputStream("configs\\UserCredentials.properties"));
			userID = credentialsProps.getProperty("emailId");
			password = credentialsProps.getProperty("password");
			badPassword = credentialsProps.getProperty("badPassword");

			driverProps.load(new FileInputStream("configs\\DriverPath.properties"));
			browser = driverProps.getProperty("Browser");			
			driverProp = driverProps.getProperty("DriverProp");
			driverPath = driverProps.getProperty("DriverPath");
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("FileNotFoundException Occured");
		} catch (IOException ioe) {
			System.out.println("IOException Occured");
		}
	}

	public static String getLandingURL() {
		return landingURL;
	}

	public static String getUserID() {
		return userID;
	}
	
	public static String getPassword() {
		return password;
	}

	public static String getBadPassword() {
		return badPassword;
	}


	public static String getBrowserType() {
		return browser;
	}

	public static String getDriverProp() {
		return driverProp;
	}

	public static String getDriverPath() {
		return driverPath;
	}

}