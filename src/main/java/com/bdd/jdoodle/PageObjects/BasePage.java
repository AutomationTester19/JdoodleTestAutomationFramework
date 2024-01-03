package com.bdd.jdoodle.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bdd.jdoodle.ExtendedManager.DriverManager;

public class BasePage extends DriverManager {

	
	public WebElement getWebElement(By locator) {

		return driver().findElement(locator);
	}

	public List<WebElement> getWebElementList(By locator) {

		return driver().findElements(locator);
	}

	public String getXpathWebElementToString(By locator, String type) {
		String xpath = locator.toString();
		xpath = xpath.substring(xpath.indexOf('/')).trim(); 
		xpath = xpath.replace("<REPLACE>", type);
		return xpath;
}

}