package com.crm.generic.baseutility.contacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;

public class ContactLastNameUsingBaseClassTest extends BaseClass{
	@Test(groups= {"RT"})
	public void contactLastNameTest() throws Exception {
		System.out.println("Execute contactLastNameTest...");
		System.out.println("=============================================");
		
		String lastname_data = eu.getContactDataFromExcelFile("Sheet1", 1, 2) + ju.randomNum();
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname_data);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		String lastname_aftersaving = driver.findElement(By.className("dvHeaderText")).getText();
		if(lastname_aftersaving.contains(lastname_data)) {
			System.out.println(lastname_aftersaving+" TestCase ==> Passed");
		}
		else {
			System.out.println(lastname_aftersaving+" TestCase ==> Failed");
		}
		
		String lastnametext_aftersaving = driver.findElement(By.id("dtlview_Last Name")).getText();
		if(lastnametext_aftersaving.equals(lastname_data)) {
			System.out.println(lastnametext_aftersaving+ " TestCase ==> Passed");
		}
		else {
			System.out.println(lastnametext_aftersaving+ " TestCase ==> Failed");
		}
	}
	
	@Test
	public void contactLastNameStartEndDateTest() throws Exception {
		System.out.println("Execute contactLastNameStartEndDateTest...");
		System.out.println("=============================================");
		
		String LastName = eu.getContactDataFromExcelFile("Sheet1", 4, 2) + ju.randomNum();
		String startdate = ju.SystemCurrentDate_yyyyMMdd();
		String dateafter30days = ju.requiredDate(30);
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startdate);
		
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(dateafter30days);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		String lastnametext_aftersaving = driver.findElement(By.id("dtlview_Last Name")).getText();
		if(lastnametext_aftersaving.contains(LastName)) {
			System.out.println(lastnametext_aftersaving+ " TestCase ==> Passed");
		}
		else {
			System.out.println(lastnametext_aftersaving+ " TestCase ==> Failed");
		}
		
		String startdate_aftersaving = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(startdate_aftersaving.equals(startdate)) {
			System.out.println(startdate_aftersaving+" TestCase ==> Passed");
		}
		else {
			System.out.println(startdate_aftersaving+" TestCase ==> Failed");
		}
		
		String enddate_aftersaving = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(enddate_aftersaving.equals(dateafter30days)) {
			System.out.println(enddate_aftersaving+" TestCase ==> Passed");
		}
		else {
			System.out.println(enddate_aftersaving+" TestCase ==> Failed");
		}
		
	}
}
