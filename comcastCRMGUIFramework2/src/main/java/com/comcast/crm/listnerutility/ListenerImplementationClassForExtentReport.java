package com.comcast.crm.listnerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.Generic.WebDriverUtility.UtilityClassObject;
import com.crm.generic.baseutility.BaseClass;

public class ListenerImplementationClassForExtentReport implements ISuiteListener, ITestListener{
	public ExtentSparkReporter spark ;
	public ExtentReports report;
	public ExtentTest test;
	
	
	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"===== TESTCASE STARTED =====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+"===== TESTCASE SUCCEED =====");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String method_name = result.getMethod().getMethodName();
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		TakesScreenshot ts = (TakesScreenshot)BaseClass.listnerdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
			
		test.addScreenCaptureFromBase64String(filepath, method_name+"_"+time);
		test.log(Status.FAIL, method_name+"===== TESTCASE FAILED =====");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ISuite suite) {
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		System.out.println("===== SUITE STARTED =====");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+ time + ".html");
		spark.config().setDocumentTitle("CRM Report");
		spark.config().setReportName("CRM Create Org Report");
		spark.config().setTheme(Theme.DARK);
				
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("BROWSER", "Chrome");
		report.setSystemInfo("Os", "Windows");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("===== SUITE FINISHED =====");
		report.flush();
	}
	
}
