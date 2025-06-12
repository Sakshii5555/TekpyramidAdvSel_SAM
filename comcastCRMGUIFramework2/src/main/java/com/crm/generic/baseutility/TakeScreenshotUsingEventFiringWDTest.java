package com.crm.generic.baseutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TakeScreenshotUsingEventFiringWDTest {
	@Test
	public void screenshotTest() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://flipkart.com");
		//EventFiringWebDriver ef = new EventFiringWebDriver(driver);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File destfile = new File("./screenshots/flipkartwebpagess.png");
		FileUtils.copyFile(srcfile, destfile);		
	}
}
