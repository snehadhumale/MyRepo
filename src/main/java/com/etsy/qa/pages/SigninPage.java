package com.etsy.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.etsy.qa.base.TestBase;

public class SigninPage extends TestBase {

	//pageFactory 

@FindBy(id="join_neu_email_field")
WebElement uname;

@FindBy(id="join_neu_password_field")
WebElement pass;

@FindBy(xpath="//span[@class=\"checkbox-label\"]")
WebElement staySiginCheck;

@FindBy(xpath="//button[@class='btn btn-large width-full btn-primary']")
WebElement signinBtn;

@FindBy(xpath="//button[contains(text(),'Register')]")
WebElement registerBtn;


public SigninPage() 
{
	super();
	PageFactory.initElements(driver, this);
}

public HomePage signinToAccount(String email,String password)
{
	//uname.sendKeys(prop.getProperty("username"));
	//pass.sendKeys(prop.getProperty("password"));
	//staySiginCheck.isSelected();
	uname.sendKeys(email);
	pass.sendKeys(password);
	signinBtn.click();
	return new HomePage();
	
}

public RegisterPage clickOnregisterBtn()
{
	registerBtn.click();
	return new RegisterPage();
}
}

