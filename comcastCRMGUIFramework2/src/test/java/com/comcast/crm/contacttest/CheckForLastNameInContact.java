package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
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

public class CheckForLastNameInContact {

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
				String LastName = eu.getContactDataFromExcelFile("Sheet1", 1, 2) + random_num;
				
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
				
				//regular test script 
				wu.waitForPageToLoad(driver);
				driver.get(URL);
				driver.manage().window().maximize();
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				driver.findElement(By.linkText("Contacts")).click();
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				driver.findElement(By.name("lastname")).sendKeys(LastName);
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				
				String lastname_aftersaving = driver.findElement(By.className("dvHeaderText")).getText();
				if(lastname_aftersaving.contains(LastName)) {
					System.out.println(lastname_aftersaving+" TestCase ==> Passed");
				}
				else {
					System.out.println(lastname_aftersaving+" TestCase ==> Failed");
				}
				
				String lastnametext_aftersaving = driver.findElement(By.id("dtlview_Last Name")).getText();
				if(lastnametext_aftersaving.equals(LastName)) {
					System.out.println(lastnametext_aftersaving+ " TestCase ==> Passed");
				}
				else {
					System.out.println(lastnametext_aftersaving+ " TestCase ==> Failed");
				}
						
				driver.quit();
	}

}
