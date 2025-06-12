package com.crm.generic.baseutility.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.Generic.DatabaseUtility.DatabaseUtility;
import com.crm.generic.baseutility.BaseClass;

public class OrgNameUsingBaseClassTest extends BaseClass{

		@Test(groups= {"ST"})
		public void orgNameTest() throws Exception {
			System.out.println("Execute OrgNameTest...");
			System.out.println("=============================================");
			
			String orgname_data = eu.getDataFromExcelFile("Sheet1", 1, 2) + ju.randomNum();

			driver.findElement(By.linkText("Organizations")).click();
			
			driver.findElement(By.xpath("//img[@title ='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(orgname_data);
			driver.findElement(By.name("button")).click();
			
			//checking for actual and expected result
			String orgname_aftersaving = driver.findElement(By.className("dvHeaderText")).getText();
			if(orgname_aftersaving.contains(orgname_data)) {
				System.out.println(orgname_aftersaving+" TestCase ==> Passed)");
			}
			else {
				System.out.println(orgname_aftersaving+" TestCase ==> Failed)");
			}
			
			String entereddata_aftersaving = driver.findElement(By.xpath("//span[@id = 'dtlview_Organization Name']")).getText();
			if(entereddata_aftersaving.equals(orgname_data)) {
				System.out.println(entereddata_aftersaving+" TestCase ==> Passed)");
			}
			else {
				System.out.println(entereddata_aftersaving+"  TestCase ==> Failed)");
			}
		}
		
		
		@Test(groups= {"ST","RT"})
		public void orgIndustryTypeTest() throws Exception {
			System.out.println("Execute orgIndustryTypeTest...");
			System.out.println("=============================================");
			
			String orgname_data = eu.getDataFromExcelFile("Sheet1", 4, 2) + ju.randomNum();
			String industry_data = eu.getDataFromExcelFile("Sheet1", 4, 3);
			String type_data = eu.getDataFromExcelFile("Sheet1", 4, 4);
			
			driver.findElement(By.linkText("Organizations")).click();
			
			driver.findElement(By.xpath("//img[@title ='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(orgname_data);
			
			WebElement industry_dropdown = driver.findElement(By.name("industry"));
			Select industryobj = new Select(industry_dropdown);
			industryobj.selectByVisibleText(industry_data);
			
			WebElement type_dropdown = driver.findElement(By.name("accounttype"));
			Select typeobj = new Select(type_dropdown);
			typeobj.selectByVisibleText(type_data);
			
			driver.findElement(By.name("button")).click();
			
			String industrydata_aftersaving = driver.findElement(By.xpath("//span[@id='dtlview_Industry']")).getText();
			if(industrydata_aftersaving.equals(industry_data)) {
				System.out.println(industrydata_aftersaving+" TestCase ==> Passed");
			}
			else {
				System.out.println(industrydata_aftersaving+" Test Case ==> Failed");
			}
			
			String typedata_aftersaving = driver.findElement(By.xpath("//span[@id='dtlview_Type']")).getText();
			if(typedata_aftersaving.equals(type_data)){
				System.out.println(typedata_aftersaving+"TestCase ==> Passed");
			}
			else {
				System.out.println(typedata_aftersaving+"TestCase ==> Failed");
			}
		}
}
