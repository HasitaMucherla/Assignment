package com.alayacare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserAccountPage extends BasePage {
	
	@FindBy(css = "h3.RTL")
	WebElement username;
	
	@FindBy(css = "ul.nav.navbar-nav.go-right > li:nth-child(1)")
	WebElement homeOption;

	public UserAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public String getLoggedInUserName() {
	    return username.getText();
	}
}
