package com.etsy.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.etsy.qa.base.TestBase;

public class HomePage extends TestBase {


	@FindBy(xpath = "//div/a/span[@id='logo']")
	WebElement logo;

	@FindBy(xpath = "//input[@id='global-enhancements-search-query']")
	WebElement searchBox;

	@FindBy(xpath = "//ul[@class='wt-list-unstyled wt-pt-xs-2 wt-pb-xs-2']//li/descendant::strong")
	WebElement searchboxResults;
	
	@FindBy(xpath="//div[@class='wt-flex-shrink-xs-0']//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")
	WebElement clickSigninBtn;
	
	@FindBy(id="catnav-primary-link-10855")
	WebElement Jewll;
	
	public HomePage() {
		super();
	PageFactory.initElements(driver, this);

	}

	
	public String validatePageTitle() {

		return driver.getTitle();

	}

	public boolean validateLogo() {
		return logo.isDisplayed();

	}

	/*public void validateSearchBox() {

		searchBox.sendKeys("pillow");
		List<WebElement> list = (List<WebElement>) searchboxResults;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().contains("pillows and cushions")) {
				list.get(i).click();
				break;
			}
		}

	}*/
	
	
	public SigninPage clickOnSigninBtn() {
		clickSigninBtn.click();
		return new SigninPage();
	}
	
	
	
	
	public void checkSubmenuJewellery()
	{
		
	}
}
