package com.bdd.jdoodle.utilities;


import org.openqa.selenium.JavascriptExecutor;

import com.bdd.jdoodle.PageObjects.BasePage;



public class WaitUtility extends BasePage {

	
	public  void waitForAjaxLoadToComplete() 
	{
		utils.sleep(3000);
	    while (true)
	    {
	    	System.out.println("");
	        if((Boolean) ((JavascriptExecutor)driver()).executeScript("return document.readyState").equals("complete") 
	        		 || (Boolean) ((JavascriptExecutor)driver()).executeScript("return jQuery.active == 0")) {
	        	break;
	        }
	    }
	}
}
