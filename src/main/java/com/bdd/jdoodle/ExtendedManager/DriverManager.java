package com.bdd.jdoodle.ExtendedManager;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bdd.jdoodle.PageObjects.BasePage;
import com.bdd.jdoodle.PageObjects.LoginPage;
import com.bdd.jdoodle.utilities.CommonUtility;
import com.bdd.jdoodle.utilities.WaitUtility;




public class DriverManager {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static ChromeOptions options = new ChromeOptions();

	public static WebDriverWait webDriverWait = null;
	protected static PropertyReaderManager propertyManager = null;
	protected static LoginPage loginPage = null;
	protected static BasePage basePage = null;
	protected static CommonUtility utils = null;
	protected static WaitUtility waitUtils = null;
	

	
	public static WebDriver driver() {
		return driver.get();
	}

	public static void PageObectInitialization() {

		propertyManager = new PropertyReaderManager();
		loginPage = new LoginPage(driver());
		basePage = new BasePage();
		utils = new CommonUtility();
		waitUtils = new WaitUtility();
		
	}

	public static void destroyPageObjects() {

		propertyManager = null;
	    loginPage = null;
	    basePage = null;
	    utils = null;
	    waitUtils = null;
	}


	public static void createInstance(String input) {

		switch (input.toLowerCase()) {
		case "chrome":
			Map<String, Object> preference = new HashMap<String, Object>();
			preference.put("profile.default_content_setting_values.notifications", 1);
			options.setExperimentalOption("prefs", preference);
			driver.set(new ChromeDriver(options));
			break;
		case "edge":
			driver.set(new EdgeDriver());
			break;
		default:
			break;
		}
	}

	public static void openBrowser() {

		if (System.getProperty("browser") == "gridurl") {
			/**
			 * Add RemoteWebDriver Details if any
			 */
		} else
			createInstance(propertyManager.getInputFromPropertyFile("browser"));
	}

	public static void launchJdoodleApp() {

		driver().get(propertyManager.getInputFromPropertyFile("url"));
	}

	public static void deleteAllCookies() {

		driver().manage().deleteAllCookies();
	}

	public static void maximizeWindow() {

		driver().manage().window().maximize();
	}

	public static void implicitWait(long timeout) {

		driver().manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}

	public static void pageLoadTimeOut(long timeout) {

		driver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
	}

	public static void visibilityOfElement(WebElement element, long timeUnit) {

		webDriverWait = new WebDriverWait(driver(), Duration.ofSeconds(timeUnit));
		webDriverWait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void headlessMode(String headLessMode) {

	}

}