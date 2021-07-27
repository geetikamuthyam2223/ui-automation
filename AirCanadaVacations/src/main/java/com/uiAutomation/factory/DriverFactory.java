package com.uiAutomation.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * This method  is used to initialize the threadlocal driver on the basis of given browser
 * @author m9599
 * @param browser
 * @return this will return tldriver.
 */
public class DriverFactory {
	public WebDriver driver;
	public static ThreadLocal <WebDriver> tlDriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is " + browser);
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Please pass the correct  browser value:"+ browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	/**
	 * This method gets the driver with ThreadLocal
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
		
	}
}
