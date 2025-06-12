package com.comcast.advancereporting;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.generic.baseutility.BaseClass;

public class SampleReportTest extends BaseClass{
	
	public ExtentReports report;
	
	@BeforeSuite
	public void configBS() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./advanceReport/report1.html");
		spark.config().setDocumentTitle("CRM Test Suite results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OperatingSystem", "Windows");
		report.setSystemInfo("BROWSER", "Chrome");
	}
	
	@AfterSuite
	public void configAS() {
		report.flush();
	}
	
	@Test
	public void createOrg() {	
		ExtentTest test = report.createTest("createOrg");
		
		test.log(Status.INFO,"Login to Application");
		test.log(Status.INFO,"Navigate to Organization Page");
		test.log(Status.INFO,"Create Organization");
		
		if("NandiniAgro".equals("NandiniAgroTech")) {
			test.log(Status.PASS,"Organization is created");
		}else {
			test.log(Status.FAIL,"Organization is not created");
		}	
	}
	
	@Test
	public void createOrgWithDate() {	
		ExtentTest test = report.createTest("createOrgWithDate");
		
		test.log(Status.INFO,"Login to Application");
		test.log(Status.INFO,"Navigate to Organization Page");
		test.log(Status.INFO,"Create Organization");
		
		if("NandiniAgroTech".equals("NandiniAgroTech")) {
			test.log(Status.PASS,"createOrgWithDate is created");
		}else {
			test.log(Status.FAIL,"createOrgWithDate is not created");
		}	
	}
	
	@Test
	public void createOrgWithIndusrtyType() {	
		ExtentTest test = report.createTest("createOrgWithIndusrtyType");
		
		test.log(Status.INFO,"Login to Application");
		test.log(Status.INFO,"Navigate to Organization Page");
		test.log(Status.INFO,"Create Organization");
		
		if("NandiniTech".equals("NandiniAgroTech")) {
			test.log(Status.PASS,"createOrgWithIndusrtyType is created");
		}else {
			test.log(Status.FAIL,"createOrgWithIndusrtyType is not created");
		}	
	}
}
