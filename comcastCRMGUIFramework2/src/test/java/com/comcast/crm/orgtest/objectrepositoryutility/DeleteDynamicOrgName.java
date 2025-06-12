package com.comcast.crm.orgtest.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.Generic.FileUtility.ExcelUtility;
import com.comcast.crm.Generic.FileUtility.FileUtility;
import com.comcast.crm.Generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.Generic.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteDynamicOrgName {

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
				String orgname_data = eu.getDataFromExcelFile("Sheet1", 10, 2) + random_num;
				
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
			
				hp.getOrglnk().click();
				op.getSearchtextfield().sendKeys(orgname_data);
				wu.select(op.getSearchfielddropdown(), "Organization Name");
				op.getSubmitbtn().click();
				
				driver.findElement(By.xpath("//a[text()='"+orgname_data+"']/../../td[8]/a[text()='del']")).click();
				
				wu.switchToAlertAndAccept(driver);
				driver.quit();

	}

}
