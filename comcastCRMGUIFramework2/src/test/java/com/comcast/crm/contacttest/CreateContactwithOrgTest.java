package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactwithOrgTest {

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
				String contactorgname = eu.getContactDataFromExcelFile("Sheet1", 7, 2) + random_num;
				String contactlastname = eu.getContactDataFromExcelFile("Sheet1", 7, 3) + random_num;
				
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
				//organization
				wu.waitForPageToLoad(driver);
				driver.get(URL);
				driver.manage().window().maximize();
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				driver.findElement(By.linkText("Organizations")).click();
				
				driver.findElement(By.xpath("//img[@title ='Create Organization...']")).click();
				driver.findElement(By.name("accountname")).sendKeys(contactorgname);
				driver.findElement(By.name("button")).click();
				
				//verify header phone number info expected
				String orgname_aftersaving = driver.findElement(By.className("dvHeaderText")).getText();
				if(orgname_aftersaving.contains(contactorgname)) {
					System.out.println(orgname_aftersaving+" TestCase ==> Passed)");
				}
				else {
					System.out.println(orgname_aftersaving+" TestCase ==> Failed)");
				}
				
				//navigate to contacts
				driver.findElement(By.linkText("Contacts")).click();
				//click on create org
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				//enter lastname
				driver.findElement(By.name("lastname")).sendKeys(contactlastname);
				//click on + sysmbol
				driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
				
				//switch to child window
				wu.switchToTabOnURL(driver, "module=Accounts");
				
				driver.findElement(By.name("search_text")).sendKeys(contactorgname);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[text()='"+contactorgname+"']")).click();
				
				//switch to parent window
				wu.switchToTabOnURL(driver, "Contacts&action");
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//verify header phone number info expected
				String lastname_aftersaving = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(lastname_aftersaving.contains(contactlastname)) {
					System.out.println(lastname_aftersaving+" TestCase ==> Passed)");
				}
				else {
					System.out.println(lastname_aftersaving+" TestCase ==> Failed)");
				}
				
				String actOrgname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
				if(actOrgname.trim().equals(contactorgname)) {
					System.out.println(actOrgname+" TestCase ==> Passed)");
				}
				else {
					System.out.println(actOrgname+"  TestCase ==> Failed)");
				}
				
				driver.quit();
	}

}
