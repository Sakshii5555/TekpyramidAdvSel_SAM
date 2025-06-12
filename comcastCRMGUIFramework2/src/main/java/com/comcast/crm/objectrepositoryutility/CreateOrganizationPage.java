package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	WebDriver driver;
	public CreateOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement orgname;
	
	@FindBy(name="button")
	private WebElement savebtn;
	
	public void orgName(String org_name) {
		orgname.sendKeys(org_name);
		savebtn.click();
	}
}
