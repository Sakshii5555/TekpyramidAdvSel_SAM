package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement actualheadertext;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement actualtextfieldtext;
	
	public WebElement getActualheadertext() {
		return actualheadertext;
	}

	public WebElement getActualtextfieldtext() {
		return actualtextfieldtext;
	}
	
	
}
