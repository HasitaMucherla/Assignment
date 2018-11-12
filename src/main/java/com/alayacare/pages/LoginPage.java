package com.alayacare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	 
	@FindBy(css = "[name='username']")
	WebElement emailId;
	    
	@FindBy(css = "[name='password']")
	WebElement password;
	
	@FindBy(id = "remember-me")
	WebElement rememberMe;

	@FindBy(css = "form#loginfrm button")
	WebElement logInButton;
	
	@FindBy(css = "div.resultlogin > div")
	WebElement inCrctCredentialsErrMsg;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	 
	public UserAccountPage logIn(String emailId, String password) {
		
	     this.emailId.sendKeys(emailId);
	     this.password.sendKeys(password);
	     logInButton.click();
	     waitUntilVisible("ul.nav.navbar-nav.go-right > li:nth-child(1)");
	     
	     return PageFactory.initElements(driver, UserAccountPage.class);
	 }
	
    public String inCrctUserCredentialsErrMsg() {
	     return inCrctCredentialsErrMsg.getText();
	}
}
