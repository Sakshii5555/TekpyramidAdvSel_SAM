package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.Generic.WebDriverUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement user_name;
	
	@FindBy(name="user_password")
	private WebElement user_pwd;
	
	//About Autohealing 
	
//	@FindBys({@FindBy(xpath="(//input[@value='Login'])[2]"), @FindBy(id="submitB")})
//	private WebElement login_btn;
	@FindAll({@FindBy(xpath="(//input[@value='Login'])[2]"), @FindBy(id="submitButton")})
	private WebElement login_btn;
	
//	@FindBy(id="submitButton")
//	private WebElement login_btn;

//	public WebElement getUser_name() {
//		return user_name;
//	}
//
//	public WebElement getUser_pwd() {
//		return user_pwd;
//	}
//
//	public WebElement getLogin_btn() {
//		return login_btn;
//	}
	
	public void loginToApp(String url,String uname, String upwd) {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		user_name.sendKeys(uname);
		user_pwd.sendKeys(upwd);
		login_btn.click();
	}
	
	
}
