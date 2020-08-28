package com.etsy.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.etsy.qa.base.TestBase;
import com.etsy.qa.pages.HomePage;
import com.etsy.qa.pages.SigninPage;

public class SigninPageTest extends TestBase {

	SigninPage signinPage;
	HomePage homePage;

	public SigninPageTest() {
		super();
	}

	@BeforeMethod()
	public void setUp() {

		initialization();
		signinPage = new SigninPage();
		homePage = new HomePage();

	}

	@Test(priority=1)
	public void testSignin() {
         homePage.clickOnSigninBtn();
		signinPage.signinToAccount("snehad@gmail.com","password");

	}

	@Test(priority=2)
	public void clickOnForRegister() {
		
		homePage.clickOnSigninBtn();
		signinPage.clickOnregisterBtn();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
