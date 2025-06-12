package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Organizations")
	private WebElement orglnk;
	
	@FindBy(linkText = "Products")
	private WebElement productlnk;
	
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement ele2;
	
	public WebElement getProductlnk() {
		return productlnk;
	}

	public void setProductlnk(WebElement productlnk) {
		this.productlnk = productlnk;
	}

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	public WebElement getOrglnk() {
		return orglnk;
	}
	
	public void logoutOrgPage() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).click().perform();
		signoutLink.click();
	}
	
}
