package com.crm.generic.baseutility;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.comcast.crm.Generic.DatabaseUtility.DatabaseUtility;
import com.comcast.crm.Generic.FileUtility.ExcelUtility;
import com.comcast.crm.Generic.FileUtility.FileUtility;
import com.comcast.crm.Generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.Generic.WebDriverUtility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	public DatabaseUtility du = new DatabaseUtility();
	public FileUtility fu = new FileUtility();
	public ExcelUtility eu = new ExcelUtility();
	public static JavaUtility ju = new JavaUtility();
	int random_num = ju.randomNum();
	public static String timestamp = ju.timeStampforSSFileName();
	static String time_stamp = timestamp;
	public WebDriver driver = null;
	public static WebDriver listnerdriver = null;
	
	
	@BeforeSuite(groups= {"ST","RT"})
	public void configBS() throws Exception {
		System.out.println("==Connect to DB, Report Config==");
		du.getConnection();
	}
	
	@Parameters("BROWSER_")
	@BeforeClass(groups= {"ST","RT"})
	public void configCS(String browser) throws Exception {
	//public void configCS() throws Exception {
		System.out.println("==Launch the BROWSER==");
		//String BROWSER = fu.getDataFromPropertiesFile("browser");
		String BROWSER = browser;
		
		if( BROWSER.equals("chrome")){
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}	
		else {
			driver = new FirefoxDriver();
		}	
		listnerdriver = driver;
		UtilityClassObject.setDriver(driver);
	}

	
	@BeforeMethod(groups= {"ST","RT"})
	public void configBM() throws Exception {
		System.out.println("==Login==");
		 String URL = fu.getDataFromPropertiesFile("url");
		 String UNAME = fu.getDataFromPropertiesFile("username");
		 String PWD = fu.getDataFromPropertiesFile("password");

		 LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, UNAME, PWD);
	}
	
	@AfterMethod(groups= {"ST","RT"})
	public void configAM() {
		System.out.println("==Logout==");
		HomePage hp = new HomePage(driver);
		hp.logoutOrgPage();
	}
	
	@AfterClass(groups= {"ST","RT"})
	public void configAC() {
		System.out.println("==Close the BROWSER==");
		driver.quit();
	}
	
	@AfterSuite(groups= {"ST","RT"})
	public void configAS() {
		System.out.println("==Close DB, Report BackUp==");
		du.closeConnection();
	}
}
