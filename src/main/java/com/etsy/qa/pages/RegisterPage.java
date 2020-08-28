package com.etsy.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.etsy.qa.base.TestBase;

public class RegisterPage extends TestBase {

	@FindBy(id="join_neu_email_field")
	WebElement uname;
	
	@FindBy(id="join_neu_first_name_field")
	WebElement firstname;
	
	@FindBy(id="join_neu_password_field")
	WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-large width-full btn-primary']")
	WebElement registerBtn;
	
	@FindBy(id="join-neu-overlay-title")
	WebElement titleOnPage;
	
	
	public RegisterPage(){
		super();
		PageFactory.initElements(driver, this);

	}


	public HomePage registerOnEtsy(String email,String pass,String fname) {
		uname.sendKeys(email);
		password.sendKeys(pass);
		firstname.sendKeys(fname);
		registerBtn.click();
		return new HomePage();
		
	}
	
}
