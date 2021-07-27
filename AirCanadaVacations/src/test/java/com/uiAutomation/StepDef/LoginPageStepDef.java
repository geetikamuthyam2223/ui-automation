package com.uiAutomation.StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import com.uiAutomation.Pages.LoginPage;
import com.uiAutomation.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDef {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	
	@Given("User is on Home Page")
	public void user_is_on_HomePage() {
		DriverFactory.getDriver().get("https://vacations-qa.aircanada.com/");
	}

	@When("User clicks on SignIn button from dropdown")
	public void click_signInButton_Dropdown() {
		loginPage.clickSignInButtonfromDropdown();
		
	}

	@And("User gives username and password")
	public void valid_username_pasword_given(String username, String pass) {
		loginPage.clickSignInButtonfromDropdown();
		loginPage.enteruserName(username);
		loginPage.enterpassword(pass);
	}

	@Then("login must be successful")
	public void login_must_successful() {
		System.out.println("User is on homepage");
	}

}


	


