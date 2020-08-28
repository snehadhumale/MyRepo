package com.etsy.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;
import org.testng.internal.PropertiesFile;

import com.etsy.qa.utilities.EventListeners;
import com.etsy.qa.utilities.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	static EventFiringWebDriver e_driver;
	static EventListeners eventListener;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("E:/Selenium_Framework/EtsyTest/src/main/java"
					+ "/com/etsy/qa/configration/config.properties");

			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
		   driver = new FirefoxDriver();
		}
		
		e_driver= new EventFiringWebDriver(driver);
		//now create object of EventListener handler to register it with EventFiringWebDriver
		eventListener=new EventListeners();
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LAOD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public static void mouseOverOn(WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}
	
}