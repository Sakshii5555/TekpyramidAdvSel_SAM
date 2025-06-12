package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.Generic.FileUtility.ExcelUtility;
import com.comcast.crm.Generic.FileUtility.FileUtility;
import com.comcast.crm.Generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.Generic.WebDriverUtility.WebDriverUtility;

public class ToCheckStartEndDateContactTest {

	public static void main(String[] args) throws Exception {
		
		//fetching data from FileUtility Class
		FileUtility fu = new FileUtility();			
		String BROWSER = fu.getDataFromPropertiesFile("browser");
		String URL = fu.getDataFromPropertiesFile("url");
		String USERNAME = fu.getDataFromPropertiesFile("username");
		String PASSWORD = fu.getDataFromPropertiesFile("password");
		
		//fetching data from JavaUtility Class 
		JavaUtility ju = new JavaUtility();
		int random_num = ju.randomNum();
		
		//fetching data from ExcelUtility Class
		ExcelUtility eu = new ExcelUtility();
		String LastName = eu.getContactDataFromExcelFile("Sheet1", 4, 2)+ random_num;
		
		//fetching data from JavaUtility class
		JavaUtility juObj = new JavaUtility();
		String startdate = juObj.SystemCurrentDate_yyyyMMdd();
		String dateafter30days = juObj.requiredDate(30);
		
		WebDriverUtility wu = new WebDriverUtility();
		
		//browser selection
		WebDriver driver = null;
		if( BROWSER =="chrome"){
				driver = new ChromeDriver();
			}
		else if(BROWSER == "edge") {
			driver = new EdgeDriver();
		}
		else if(BROWSER == "firefox") {
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		//regular testscript 
		wu.waitForPageToLoad(driver);
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startdate);
		
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(dateafter30days);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		String lastnametext_aftersaving = driver.findElement(By.id("dtlview_Last Name")).getText();
		if(lastnametext_aftersaving.contains(LastName)) {
			System.out.println(lastnametext_aftersaving+ " TestCase ==> Passed");
		}
		else {
			System.out.println(lastnametext_aftersaving+ " TestCase ==> Failed");
		}
		
		String startdate_aftersaving = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(startdate_aftersaving.equals(startdate)) {
			System.out.println(startdate_aftersaving+" TestCase ==> Passed");
		}
		else {
			System.out.println(startdate_aftersaving+" TestCase ==> Failed");
		}
		
		String enddate_aftersaving = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(enddate_aftersaving.equals(dateafter30days)) {
			System.out.println(enddate_aftersaving+" TestCase ==> Passed");
		}
		else {
			System.out.println(enddate_aftersaving+" TestCase ==> Failed");
		}
		
		driver.quit();

	}

}
