package com.alayacare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver = null;
	protected WebDriverWait wait = null;
	
	BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy(css = "div.collapse.navbar-collapse li#li_myaccount > a")
	WebElement myAccount;
	    
	@FindBy(css = "div.collapse.navbar-collapse li#li_myaccount > ul > li:nth-child(1) > a")
	WebElement loginOption;	 
	
	
	public LoginPage getLoginPage() {
		myAccount.click();
		loginOption.click();
		
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public void waitUntilVisible(String cssSelector) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(cssSelector))));
	}
	
	public void waitUntilVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
