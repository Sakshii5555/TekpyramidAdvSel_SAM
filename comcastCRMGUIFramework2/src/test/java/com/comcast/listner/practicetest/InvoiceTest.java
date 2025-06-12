package com.comcast.listner.practicetest;

import java.lang.reflect.Method;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.generic.baseutility.BaseClass;

//@Listeners(com.comcast.crm.listnerutility.ListnerImplementationClass.class)
public class InvoiceTest extends BaseClass{
	@Test
	public void createInvoicetest(Method m) {
		System.out.println(m.getName()+" Execution Started ====>");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Administrator - Home - vtiger CRM 5");
		System.out.println("Step_1");
		System.out.println("Step_2");
		System.out.println("Step_3");
		System.out.println("Step_4");
		System.out.println(m.getName()+" Execution Ended ====>");
	}
	
	@Test
	public void createInvoicewithContactTest(Method m) {
		System.out.println(m.getName()+" Execution Started ====>");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualTitle, "Login");
		System.out.println("Step_1");
		System.out.println("Step_2");
		System.out.println("Step_3");
		System.out.println("Step_4");
		sa.assertAll();
		System.out.println(m.getName()+" Execution Ended ====>");
	}
}
