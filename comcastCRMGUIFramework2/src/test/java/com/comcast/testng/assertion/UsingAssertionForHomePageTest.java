package com.comcast.testng.assertion;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UsingAssertionForHomePageTest {
	@Test
	public void verifyHomeText(Method m) {
		System.out.println(m.getName()+ "Test Start..");
		SoftAssert sa = new SoftAssert();
		
		String expectedresult = "Home_ page";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		String actualresult = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		
		//Hard Assert
		//Assert.assertEquals(actualresult, expectedresult);
		
		sa.assertEquals(actualresult, expectedresult);
		driver.close();
		sa.assertAll();
		
		System.out.println(m.getName()+ "Test End..");
	}
	
	@Test
	public void verifyLogo(Method m) {
		System.out.println(m.getName()+ "Test Start..");
		
		SoftAssert sa = new SoftAssert();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		Boolean actuallogo = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		
		//Assert.assertTrue(actuallogo);
		sa.assertTrue(actuallogo);
		driver.close();
		sa.assertAll();
		System.out.println(m.getName()+ "Test End..");
	} 
}
