package com.uiAutomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


public class LoginPage {

	private WebDriver driver;
	private By signIn = By.xpath("//div[@class = 'sign-in-wp']");
	private By signInoption = By.xpath("//div[@id = 'loginModal']//a[contains(text(),'Sign in')]");
	private By email = By.xpath("//form[@id='gigya-login-form']//input[@name = 'username']");
	private By password = By.xpath("//form[@id='gigya-login-form']//input[@name = 'password']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSignInButtonfromDropdown() {
		WebElement signIn_dropdown = driver.findElement(signIn);
		((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('style')", signIn_dropdown);
		List<WebElement> alloptions = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginModal")));
		System.out.println("<<<<<<<<<<<<------List of all stars, size------------>>>>>>>>>>"+alloptions.size());
		for (WebElement e : alloptions) {
		    if(e.getAttribute("innerHTML").contains("Sign in"))
		    {
		        new Actions(driver).moveToElement(e).build().perform();
		        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(signInoption)).click();
		    }
		}
	}

	public void enteruserName(String username) {
		driver.findElement(email).sendKeys(username);
	}

	public void enterpassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}

}
