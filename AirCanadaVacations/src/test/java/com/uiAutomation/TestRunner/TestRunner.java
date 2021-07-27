package com.uiAutomation.TestRunner;


import io.cucumber.junit.CucumberOptions;


@CucumberOptions(
		features="./src/test/resources/com/uiAutomation/Features",
		glue= {"com.uiAutomation.StepDef", "com.uiAutomation.AppHooks"}, 
		monochrome = true,
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestRunner {

}
