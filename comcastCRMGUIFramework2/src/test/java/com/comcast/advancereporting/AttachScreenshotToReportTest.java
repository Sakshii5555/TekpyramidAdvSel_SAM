package com.comcast.advancereporting;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.listnerutility.ListnerImplementationClass;
import com.crm.generic.baseutility.BaseClass;

public class AttachScreenshotToReportTest {
	ExtentReports report;
	
	@BeforeSuite
	public void configBS() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReporting/report.html");
		spark.config().setDocumentTitle("CRM Report");
		spark.config().setReportName("CRM Create Org Report");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("BROWSER", "Chrome");
		report.setSystemInfo("Os", "Windows");
	}
	
	@AfterSuite
	public void configAS() {
		report.flush();
	}
	
	@Test
	public void createOrg() {	
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = report.createTest("createOrg");
		
		test.log(Status.INFO,"Login to Application");
		test.log(Status.INFO,"Navigate to Organization Page");
		test.log(Status.INFO,"Create Organization");
		
		if("NandiniAgro".equals("NandiniAgroTech")) {
			test.log(Status.PASS,"Organization is created");
		}else {
			test.addScreenCaptureFromBase64String(filepath, "ErrorFileofOrgPage");
		}	
		driver.close();
	}
}
