package com.bdd.jdoodle.StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.bdd.jdoodle.ExtendedManager.DriverManager;
import com.bdd.jdoodle.utilities.Log;

import io.cucumber.java.en.Then;

public class LoginPageStepDefination extends DriverManager {

	@Then("Click on Login Button in Jdoodle Application")
	public void clickedOnloginBtn() {

		boolean flag = false;
		WebElement loginButton = basePage.getWebElement(loginPage.loginBtn);
		flag = loginButton.isDisplayed();
		try {
			if (flag) {
				loginButton.click();
			} else {
				Log.error("Login Button is Not Displayed in Jdoodle Application");
			}
		} catch (Exception e) {
			Log.error("Unable to locate the WebElement");
			e.printStackTrace();
		}
		if (flag) {
			Log.info("Clicked on Login Button in Jdoodle Application");
		}

	}

	@Then("Click on Sign up Button in Sign up Jdoodle Application Page")
	public void signUpBtn() {

		boolean flag = false;
		WebElement signUpBtn = basePage.getWebElement(loginPage.signupBtn);
		flag = signUpBtn.isDisplayed();
		try {
			if (flag) {
				signUpBtn.click();
			} else {
				Log.error("SignUp Button is Not Displayed in Jdoodle Application");
			}
		} catch (Exception e) {
			Log.error("Unable to locate the WebElement");
			e.printStackTrace();
		}
		if (flag) {
			Log.info("Clicked on SignUp Button in Jdoodle Application");
		}
	}

	@Then("Verify {string} field is Displayed as {string} in Signup Jdoodle Application")
	public void validateField(String fieldName, String locator) {

		boolean flag = false;
		String loc = basePage.getXpathWebElementToString(loginPage.fieldLocator, locator);
		WebElement fieldname = driver().findElement(By.xpath(loc));
		try {
			if (fieldname.isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			Log.error("Unable to locate the WebElement");
			e.printStackTrace();
		}
		if (flag) {
			Log.info(fieldName + " is Displayed in Signup Jdoodle Application");
		}
	}

	@Then("Enter Programming Language Name as {string} in Jdoodle Search Box")
	public void clickAndEnterText(String input) {

		boolean flag = false;
		WebElement webelement = basePage.getWebElement(loginPage.searchBx);
		flag = webelement.isDisplayed();
		try {
			if (flag) {
				utils.sleep(500);
				webelement.click();
				webelement.clear();
				utils.sleep(200);
				webelement.sendKeys(String.valueOf(input));
			} else
				Log.error("Unable to find the Element ");
		} catch (NullPointerException e) {
			e.printStackTrace();
			Log.error("Unable to Enter Text in the Search Box Field ");
		}

		if (flag) {
			Log.info("Clicked And Entering Text as " + input + " in Search Box Field");
		}
	}
	
	
	@Then("Verify Default Header {string} in Jdoodle Application")
	public void verifyDefaultHeader(String header) {
		
		boolean flag = false;
		WebElement webelement = basePage.getWebElement(loginPage.defaultHeader);
		flag = webelement.isDisplayed();
		try {
			if (flag) {
				Assert.assertEquals(header, webelement.getAttribute("innerText"));
			} else
				Log.error("Unable to find the Element ");
		} catch (NullPointerException e) {
			e.printStackTrace();
			Log.error("Unable to Enter Text in the Search Box Field ");
		}
		
		if(flag) {
			Log.info(header+ " is Displayed as Default Header in Jdoodle Application");
		}
	}
}
