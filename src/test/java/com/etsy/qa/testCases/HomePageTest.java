package com.etsy.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.etsy.qa.base.TestBase;
import com.etsy.qa.pages.HomePage;

public class HomePageTest extends TestBase {
	HomePage homepage;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homepage= new HomePage();
	}
	
	@Test(priority=1)
	public void testHomePageTitle() {
		String title=homepage.validatePageTitle();
		Assert.assertEquals(title, "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone");
	}
	
	@Test(priority=2)
	public void testHomePageLogo() {
		boolean value=homepage.validateLogo();
		Assert.assertTrue(value);
	}
	
	@Test(priority=3)
	public void testSigninButton() {
		homepage.clickOnSigninBtn();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
