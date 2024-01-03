package com.bdd.jdoodle.StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.bdd.jdoodle.ExtendedManager.DriverManager;
import com.bdd.jdoodle.utilities.Log;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class BasePageStepDefination extends DriverManager {
	


	@Then("Verify Login Button is Displayed once Jdoodle Application is Opened")
	public void validateBtnIsDisplayed() {
		
		boolean flag = false;
		flag = basePage.getWebElement(loginPage.loginBtn).isDisplayed();
		if(flag) {
			Log.info("Login Button is Displayed when Jdoodle Application is Opened");
		}
		else
			Log.error("Login Button is Not Displayed when Jdoodle Application is Opened");
	}

	@And("Validate the title {string} in Jdoodle Application Page")
	public void validateTitleOfPage(String title) {

		boolean flag = false;
		try {

			if (title.isEmpty()) {
				Log.error("Title is Empty");
				Assert.assertFalse(false);
			} else {
				Assert.assertEquals(title, driver().getTitle());
				flag = true;
			}
		} catch (NullPointerException e) {
			Log.error("Invalid Title " + title + " Passed in StepDefination ");
			e.printStackTrace();
		}

		if(flag) {
			Log.info("Title of Jdoodle Application : " +title);
		}
	}

	
	@Then("Validate {string} Button is Displayed in Jdoodle Application")
	public void verifyBtnIsDisplayed(String buttonName) {
		
		boolean flag = false;
		String locator = basePage.getXpathWebElementToString(loginPage.btnlocator, buttonName);
		WebElement btnName = driver().findElement(By.xpath(locator));
		try {			
			if(btnName.isDisplayed()) {
				flag = true;
			}
		}catch(Exception e) {
			Log.error("Unable to find the WebElement");
			e.printStackTrace();
		}
		if(flag) {
			
			Log.info(buttonName+" is Displayed in Jdoodle Application");
		}
	}
}
