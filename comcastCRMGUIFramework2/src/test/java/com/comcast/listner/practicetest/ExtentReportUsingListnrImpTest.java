package com.comcast.listner.practicetest;

import java.lang.reflect.Method;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.Generic.WebDriverUtility.UtilityClassObject;
import com.crm.generic.baseutility.BaseClass;

//@Listeners(com.comcast.crm.listnerutility.ListenerImplementationClassForExtentReport.class)
public class ExtentReportUsingListnrImpTest extends BaseClass{
	@Test
	public void createInvoicetest(Method m) {
		UtilityClassObject.getTest().log(Status.INFO, (m.getName()+" Execution Started ====>"));
		System.out.println(m.getName()+" Execution Started ====>");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
		UtilityClassObject.getTest().log(Status.INFO, actualTitle);
		System.out.println("Step_1");
		UtilityClassObject.getTest().log(Status.INFO,"Step_1");
		System.out.println("Step_2");
		UtilityClassObject.getTest().log(Status.INFO,"Step_2");
		System.out.println("Step_3");
		UtilityClassObject.getTest().log(Status.INFO,"Step_3");
		System.out.println("Step_4");
		UtilityClassObject.getTest().log(Status.INFO,"Step_4");
		System.out.println(m.getName()+" Execution Ended ====>");
		UtilityClassObject.getTest().log(Status.INFO, (m.getName()+" Execution Ended ====>"));
		
	}
	
	@Test
	public void createInvoicewithContactTest(Method m) {
		UtilityClassObject.getTest().log(Status.INFO, (m.getName()+" Execution Started ====>"));
		System.out.println(m.getName()+" Execution Started ====>");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualTitle, "Login");
		UtilityClassObject.getTest().log(Status.INFO, actualTitle);
		System.out.println("Step_1");
		UtilityClassObject.getTest().log(Status.INFO,"Step_1");
		System.out.println("Step_2");
		UtilityClassObject.getTest().log(Status.INFO,"Step_2");
		System.out.println("Step_3");
		UtilityClassObject.getTest().log(Status.INFO,"Step_3");
		System.out.println("Step_4");
		UtilityClassObject.getTest().log(Status.INFO,"Step_4");
		sa.assertAll();
		System.out.println(m.getName()+" Execution Ended ====>");
		UtilityClassObject.getTest().log(Status.INFO, (m.getName()+" Execution Ended ====>"));
		
	}
}
