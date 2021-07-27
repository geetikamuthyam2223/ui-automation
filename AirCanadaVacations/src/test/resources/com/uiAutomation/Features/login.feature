@SmokeTest
Feature: User Authentication in Login Page
  
  Scenario: User with valid Credentials - positive testcase
	Given User is on Home Page
	When User clicks on SignIn button from dropdown
	And user navigates to signIn page
	And Give username and password
	And Click on login button
	Then login must be successful