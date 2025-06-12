package com.comcast.testng.assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.Generic.FileUtility.ExcelUtility;
import com.comcast.crm.Generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.crm.generic.baseutility.BaseClass;

public class OrgNameAssertionUsage extends BaseClass{
	@Test()
	public void orgNameTest() throws Exception {
		System.out.println("Execute OrgNameTest...");
		System.out.println("=============================================");
		
		String orgname_data = eu.getDataFromExcelFile("Sheet1", 1, 2) + ju.randomNum();

		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@title ='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname_data);
		driver.findElement(By.name("button")).click();
		
		//checking for actual and expected result
		OrganizationInformationPage op = new OrganizationInformationPage(driver);
		
		String orgname_aftersaving = op.getActualheadertext().getText();
		boolean test = orgname_aftersaving.contains(orgname_data);
		Assert.assertEquals(test, true);
//		if(orgname_aftersaving.contains(orgname_data)) {
//			System.out.println(orgname_aftersaving+" TestCase ==> Passed)");
//		}
//		else {
//			System.out.println(orgname_aftersaving+" TestCase ==> Failed)");
//		}
		
		String entereddata_aftersaving = op.getActualtextfieldtext().getText();
		boolean testtextfield = entereddata_aftersaving.equals(orgname_data);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(testtextfield, true);
//		if(entereddata_aftersaving.equals(orgname_data)) {
//			System.out.println(entereddata_aftersaving+" TestCase ==> Passed)");
//		}
//		else {
//			System.out.println(entereddata_aftersaving+"  TestCase ==> Failed)");
//		}
	}
}
