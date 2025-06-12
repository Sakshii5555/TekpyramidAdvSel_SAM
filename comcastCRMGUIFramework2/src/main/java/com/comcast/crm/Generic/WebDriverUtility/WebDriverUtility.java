package com.comcast.crm.Generic.WebDriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPresent(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void switchToTabOnURL(WebDriver driver, String PartialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			String windowId = itr.next();
			driver.switchTo().window(windowId);
			
			String actualUrl = driver.getCurrentUrl();
			if(actualUrl.contains(PartialURL)) {
				break;
			}
		}
	}
		
	public void switchToTabOnTitle(WebDriver driver, String PartialTitle) {
		Set<String> set = driver.getWindowHandles();
			Iterator<String> itrr = set.iterator();
			while(itrr.hasNext()) {
				String windowId = itrr.next();
				driver.switchTo().window(windowId);
				
				String actualUrl = driver.getTitle();
				if(actualUrl.contains(PartialTitle)) {
				break;
				}
			}
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void select(WebElement ele, String text) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(text);
	}
	
	public void select(WebElement ele, int index) {
		Select sel = new Select(ele);
		sel.selectByIndex(index);
	}
	
	public void mousemoveOnEle(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
}
