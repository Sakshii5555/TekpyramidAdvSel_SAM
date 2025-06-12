package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.Generic.FileUtility.ExcelUtility;
import com.comcast.crm.Generic.FileUtility.FileUtility;
import com.comcast.crm.Generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.Generic.WebDriverUtility.WebDriverUtility;

public class CheckforIndusrtyAndType {

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
				String orgname_data = eu.getDataFromExcelFile("Sheet1", 4, 2) + random_num;
				String industrydata = eu.getDataFromExcelFile("Sheet1", 4, 3);
				String typedata =eu.getDataFromExcelFile("Sheet1", 4, 4);
				
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
				
				driver.findElement(By.linkText("Organizations")).click();
				
				driver.findElement(By.xpath("//img[@title ='Create Organization...']")).click();
				driver.findElement(By.name("accountname")).sendKeys(orgname_data);
				
				WebElement industry_dropdown = driver.findElement(By.name("industry"));
				Select industryobj = new Select(industry_dropdown);
				industryobj.selectByVisibleText(industrydata);
				
				WebElement type_dropdown = driver.findElement(By.name("accounttype"));
				Select typeobj = new Select(type_dropdown);
				typeobj.selectByVisibleText(typedata);
				
				driver.findElement(By.name("button")).click();
				
				String industrydata_aftersaving = driver.findElement(By.xpath("//span[@id='dtlview_Industry']")).getText();
				if(industrydata_aftersaving.equals(industrydata)) {
					System.out.println(industrydata_aftersaving+" TestCase ==> Passed");
				}
				else {
					System.out.println(industrydata_aftersaving+" Test Case ==> Failed");
				}
				
				String typedata_aftersaving = driver.findElement(By.xpath("//span[@id='dtlview_Type']")).getText();
				if(typedata_aftersaving.equals(typedata)){
					System.out.println(typedata_aftersaving+"TestCase ==> Passed");
				}
				else {
					System.out.println(typedata_aftersaving+"TestCase ==> Failed");
				}
						
				driver.quit();
	}

}
