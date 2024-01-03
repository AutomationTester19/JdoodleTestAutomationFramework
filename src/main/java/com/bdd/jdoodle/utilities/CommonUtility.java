package com.bdd.jdoodle.utilities;

import com.bdd.jdoodle.PageObjects.BasePage;

public class CommonUtility extends BasePage {

	public  void sleep(long timeUnit) {
		
		try {
			Thread.sleep(timeUnit);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
