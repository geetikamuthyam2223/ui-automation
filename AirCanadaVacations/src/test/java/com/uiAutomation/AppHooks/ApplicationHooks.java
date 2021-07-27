package com.uiAutomation.AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.uiAutomation.Utility.PropertiesFileReader;
import com.uiAutomation.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private PropertiesFileReader propertiesFileReader;
	Properties properties;
	
	@Before(order = 0)
	public void getProperty() {
		propertiesFileReader = new PropertiesFileReader();
		properties = propertiesFileReader.init_properties();
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		String browserName = properties.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order =  1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte [] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotName);
		}
	}
}
