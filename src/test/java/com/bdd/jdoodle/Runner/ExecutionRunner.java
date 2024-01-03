package com.bdd.jdoodle.Runner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@Test
@RunWith(Cucumber.class)
@CucumberOptions(features = { "src//main//resources//Features" }, glue = { "com.bdd.jdoodle.StepDefinitions",
		"com.bdd.jdoodle.Hooks" }, plugin = { "pretty", "html:target/cucumber-html-reports",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
		monochrome = false)
public class ExecutionRunner extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = true)
	public Object[][] Scenario() {
		return super.scenarios();
	}
}
