package com.etsy.qa.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.etsy.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LAOD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT=30;
	
	public static void takeScreenshotAtEndofTest() throws IOException {
		File srcFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots" + System.currentTimeMillis()+ ".png"));
		
	}
	
}
