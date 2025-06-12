package com.comcast.crm.orgtest.objectrepositoryutility;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.Generic.FileUtility.ExcelUtility;
import com.comcast.crm.Generic.FileUtility.FileUtility;
import com.comcast.crm.Generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.Generic.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CheckforOrganizationName {

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
		String orgname_data = eu.getDataFromExcelFile("Sheet1", 1, 2) + random_num;
		
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
		driver.get("http://localhost:8888/");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp("jdbc:mysql://localhost:3306/std","admin", "admin");
		
		HomePage hp = new HomePage(driver);
		hp.getOrglnk().click();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getcreateOrg().click();
		
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.orgName(orgname_data);
		
		OrganizationInformationPage cip = new OrganizationInformationPage(driver);
		String actualheader_text = cip.getActualheadertext().getText();
		if(actualheader_text.contains(orgname_data)) {
			System.out.println(actualheader_text+ "TestCase ====> PASSED");
		}
		else {
			System.out.println(actualheader_text+ " TestCase ====> FAILED");
		}
		
		String actualtextfield_text = cip.getActualtextfieldtext().getText();
		if(actualtextfield_text.equals(orgname_data)) {
			System.out.println(actualtextfield_text+" TestCase ====> PASSED");
		}else {
			System.out.println(actualtextfield_text+ " TestCase ====> FAILED");
		}
		//closing browser
		driver.quit();

	}

}
