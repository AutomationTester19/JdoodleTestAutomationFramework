package com.bdd.jdoodle.Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.bdd.jdoodle.ExtendedManager.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks extends DriverManager {
	
	
	@Before(order = 0)
	public void setUp(Scenario scenario) {
	
		PageObectInitialization();
		openBrowser();
		deleteAllCookies();
		maximizeWindow();
		launchJdoodleApp();
       waitUtils.waitForAjaxLoadToComplete();		
	}
	
	@After(order = 0)
	public void quitBrowser(Scenario scenario) {
		
		destroyPageObjects();
		if(driver!=null) {
			driver().quit();
		}
	}
	
	
	@AfterStep(order = 0)
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
			//scenario.log("Verifying the logs");
		}
	}

}
