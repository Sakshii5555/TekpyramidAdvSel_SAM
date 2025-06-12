package com.comcast.listner.practicetest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;

public class CheckNetwork extends BaseClass{
	@Test(retryAnalyzer = com.comcast.crm.listnerutility.ImplementationOfRetryAnalyzerClass.class)
	public void checkforNetwork(Method m) {
		System.out.println(m.getName()+" Execution Started ====>");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Administrator - Home - vtiger CRM 5");
		System.out.println("Step_1");
		System.out.println("Step_2");
		System.out.println(m.getName()+" Execution Ended ====>");
	}
}
