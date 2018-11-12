package com.alayacare.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.alayacare.pages.LandingPage;
import com.alayacare.pages.LoginPage;
import com.alayacare.pages.UserAccountPage;


public class HotelSearchTest extends BasePageTest{

	public static LandingPage landingPage = null;
	public static LoginPage loginPage = null;
	public static UserAccountPage usrAcctPage = null;
	
	@BeforeClass
	void setup() {
		landingPage = BasePageTest.initialization();
		landingPage.chooseHotelsOption();
	}
	
	@AfterClass
	void tearDown() {
		driver.close();
	}
	
	@Test
	void hotelBooking() throws InterruptedException {
		// Enter "Singapore" in search field and choose the dynamic search entry.
		landingPage.setCityName("Singapore");
		landingPage.setCheckInDate();
		landingPage.setCheckOutDate();
		landingPage.setAdults();
		landingPage.setChilds();
		
	    Assert.assertEquals(landingPage.search() > 0, true);
	}
}

