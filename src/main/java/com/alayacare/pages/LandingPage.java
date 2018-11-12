package com.alayacare.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

	@FindBy(css = "div.col-md-12 > ul > li.text-center.go-right.active > a")
	WebElement hotelsOption;
	
	@FindBy(css = "div.select2-container.hotelsearch.locationlisthotels > a > span.select2-chosen")
	WebElement  hotelORcityName;
	
	@FindBy(css = "#select2-drop > ul > li:nth-child(2) > ul > li")
	WebElement dynamicEntrySingapore;
	
	@FindBy(css = "input[class='form input-lg dpd1'][name='checkin']")
	WebElement checkInField;
	
	@FindBy(css = "div.datepicker-days > table > tbody > tr:nth-child(3) > td:nth-child(1)")
	List<WebElement> checkInDates;
	
	@FindBy(css = "#dpd2 > div > input")
	WebElement checkOutField;
	
	@FindBy(id = "travellersInput")
	WebElement personsField;
	
	@FindBy(id = "adultPlusBtn")
	WebElement adultPlusBtn;
	
	@FindBy(id = "adultMinusBtn")
	WebElement adultMinusBtn;
	
	@FindBy(id = "childPlusBtn")
	WebElement childPlusBtn;
	
	@FindBy(id = "childMinusBtn")
	WebElement childMinusBtn;
	
	@FindBy(css = "#hotels > form > div.col-md-2.form-group.go-right.col-xs-12.search-button > button")
	WebElement searchBtn;
	
	@FindBy(css = "div.col-md-9.col-xs-12 > div.row > div > table > tbody > tr")
	List<WebElement> searchResults;
	
	
	public LandingPage(WebDriver driver) {
		super(driver);
	}
	
	public void chooseHotelsOption() {
		hotelsOption.click();
	}
	
	public void setCityName(String cityName) {
		Actions actions = new Actions(driver);
		actions.moveToElement(hotelORcityName);
		actions.click();
		actions.sendKeys("Singapore");
		actions.build().perform();
		
		waitUntilVisible(dynamicEntrySingapore);
		actions.moveToElement(dynamicEntrySingapore);
		actions.click().build().perform();
	}
	
	public void setCheckInDate() {
		waitUntilVisible(checkInField);
		checkInField.click();
		checkInDates.get(0).click();
	}
	
	public void setCheckOutDate() {
		
	}
	
	public void setAdults() {
		personsField.click();
		adultPlusBtn.click();
		adultPlusBtn.click();
		adultMinusBtn.click();
	}
	
	public void setChilds() {
		childPlusBtn.click();
		childPlusBtn.click();
		childMinusBtn.click();
	}
	
	public int search() {
		searchBtn.click();
		
		return searchResults.size();
	}

}
	
