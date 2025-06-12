package com.crm.generic.baseutility;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UsageOfReportLogTest {
	@Test
	public void TestA(Method m) {
		Reporter.log(m.getName()+ " TestCase Starts",true);
		Reporter.log("Test1", true);
		Reporter.log("STEP-1",true);
		Reporter.log("STEP-2",true);
		Reporter.log("STEP-3",true);
		Reporter.log("STEP-4",true);
		Reporter.log(m.getName()+" TestCase Ends",true);
	}
	
	@Test
	public void TestB(Method m) {
		Reporter.log(m.getName()+ " TestCase Starts", true);
		Reporter.log("Test2",true);
		Reporter.log("STEP-1", false);
		Reporter.log("STEP-2", false);
		Reporter.log("STEP-3", false);
		Reporter.log("STEP-4", false);
		Reporter.log(m.getName()+" TestCase Ends", true);
	}
}
