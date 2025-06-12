package com.testng.annotation.dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.Generic.FileUtility.ExcelUtility;

public class DataProviderInRealTestScript {
	@Test(dataProvider="getData")
	public void getProductInfoTest(String brandname, String productname) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://flipkart.com");
		
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("iphone",Keys.ENTER);
		String x = "//div[text()='"+productname+"']/../../div[2]/div[1]/div[1]/div[1]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws Exception {
		ExcelUtility eu = new ExcelUtility();
		int lastrownum = eu.rowCount("product");
		
		Object[][] obj = new Object[lastrownum][2];
		
		for(int i=0;i<lastrownum;i++) {
			obj[i][0] = eu.getDataFromExcelFile("product", i+1, 0);
			obj[i][1] = eu.getDataFromExcelFile("product", i+1, 1);
		}
		
		
		return obj;
	}
}
