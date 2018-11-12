package com.alayacare.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.alayacare.pages.LandingPage;
import com.alayacare.pages.LoginPage;
import com.alayacare.pages.UserAccountPage;

import utilities.ConfigReadUtility;

public class LoginPageTest extends BasePageTest{

	public static LandingPage landingPage = null;
	public static LoginPage loginPage = null;
	public static UserAccountPage usrAcctPage = null;
	
	@BeforeClass
	void setup() {
		landingPage = BasePageTest.initialization();
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}

	@Test(priority = 1, description = "This test case verifies error meassge funtionality when user gives bad password")
	void verifyIncorrectUserCredentials() {
		loginPage = landingPage.getLoginPage();
		loginPage.logIn(ConfigReadUtility.getUserID(), ConfigReadUtility.getBadPassword());
		String errMsgBadPassword = loginPage.inCrctUserCredentialsErrMsg();
		Assert.assertEquals("Invalid Email or Password", errMsgBadPassword);
	}

	@Test(priority = 2, description = "This testcase verify Login functionality with correct User Credentials")
	void verifyLogInFuntionality() {
		loginPage = landingPage.getLoginPage();
		usrAcctPage = loginPage.logIn(ConfigReadUtility.getUserID(), ConfigReadUtility.getPassword());
		Assert.assertEquals("Hi, Johny Smith", usrAcctPage.getLoggedInUserName());

	}
}
