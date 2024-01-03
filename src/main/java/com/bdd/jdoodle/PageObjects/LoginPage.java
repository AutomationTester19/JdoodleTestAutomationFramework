package com.bdd.jdoodle.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	
	public By loginBtn = By.xpath("//div[@id='navbar-collapse-basic']//button[@data-hs-overlay='#hs-login-modal']");
	public By btnlocator = By.xpath("//button[normalize-space()='<REPLACE>']");
	public By signupBtn = By.xpath("//button[@data-hs-overlay='#hs-register-modal' and normalize-space()='Sign Up']");
	public By fieldLocator = By.xpath("//input[@type='<REPLACE>' or @autocomplete='<REPLACE>' or @id='<REPLACE>']");
	public By searchBx = By.xpath("//div[@id='navbar-collapse-basic']//input[@id='searchBar']");
	public By defaultHeader = By.xpath("//h1[contains(@class,'text-md')]");
	
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this	);
	}
}
