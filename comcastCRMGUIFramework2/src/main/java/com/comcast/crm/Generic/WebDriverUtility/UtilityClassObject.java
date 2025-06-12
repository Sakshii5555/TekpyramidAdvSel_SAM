package com.comcast.crm.Generic.WebDriverUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static void setDriver(WebDriver actualdriver) {
		driver.set(actualdriver);
	}
	
	public static ExtentTest getTest() {
		return test.get();
	}
	public static void setTest(ExtentTest actualtest) {
		test.set(actualtest);
	}
	
}
