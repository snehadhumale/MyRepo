package com.etsy.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.etsy.qa.base.TestBase;
import com.etsy.qa.pages.HomePage;
import com.etsy.qa.pages.RegisterPage;
import com.etsy.qa.pages.SigninPage;

public class RegisterPageTest extends TestBase{
	
	RegisterPage regPage;
	HomePage homePage;
	SigninPage signinPage;
	

	public RegisterPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		signinPage =new SigninPage();
		regPage = new RegisterPage();
		
	}
	
    @Test
    public void testRegisteration() {
    	
      homePage.clickOnSigninBtn();	
      signinPage.clickOnregisterBtn();
	  regPage.registerOnEtsy("sdhumale@gmail.com", "sneha1234", "Sneha");
	  
  }
    /*@AfterMethod
	public void tearDown() {
		driver.quit();
	}*/

}
