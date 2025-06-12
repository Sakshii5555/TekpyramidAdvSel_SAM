package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;
	public OrganizationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createorg;
	
	@FindBy(name="search_text")
	private WebElement searchtextfield;
	
	@FindBy(name="search_field")
	private WebElement searchfielddropdown;
	
	@FindBy(name="submit")
	private WebElement submitbtn;
	
	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	public WebElement getSearchtextfield() {
		return searchtextfield;
	}

	public WebElement getSearchfielddropdown() {
		return searchfielddropdown;
	}

	public WebElement getcreateOrg() {
		return createorg;
	}
}
