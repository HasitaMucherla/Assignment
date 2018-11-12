package com.alayacare.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.alayacare.pages.LandingPage;

import utilities.ConfigReadUtility;

public class BasePageTest {
	
	static WebDriver driver = null;
	
	static public LandingPage initialization() {
		
		ConfigReadUtility.initConfigFiles();
	    String driverProp = ConfigReadUtility.getDriverProp();
		String driverPath = ConfigReadUtility.getDriverPath();
		
		String browser = ConfigReadUtility.getBrowserType();
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty(driverProp, driverPath);
			driver = new ChromeDriver();
		} else {
			// Default browser would be used.
		}
		
	    driver.get(ConfigReadUtility.getLandingURL());
		         
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return PageFactory.initElements(driver, LandingPage.class);
	}

}
