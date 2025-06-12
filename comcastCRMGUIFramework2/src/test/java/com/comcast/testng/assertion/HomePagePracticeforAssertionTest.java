package com.comcast.testng.assertion;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomePagePracticeforAssertionTest {
	@Test
	public void verifyHomeText(Method m) {
		System.out.println(m.getName()+ "Test Start..");
		
		String expectedresult = "Homee";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		String actualresult = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		
		if(actualresult.trim().equals(expectedresult)) {
			System.out.println("== TESTCASE PASSED ==");
		}
		else {
			System.out.println("== TESTCASE FAILED ==");
		}
		driver.close();
		System.out.println(m.getName()+ "Test End..");
	}
	
	@Test
	public void verifyLogo(Method m) {
		System.out.println(m.getName()+ "Test Start..");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		Boolean actualresult = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		
		if(actualresult.TRUE) {
			System.out.println("== TESTCASE PASSED ==");
		}
		else {
			System.out.println("== TESTCASE FAILED ==");
		}
		driver.close();
		System.out.println(m.getName()+ "Test End..");
	} 
}
