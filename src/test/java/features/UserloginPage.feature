

@Login
Feature: user login functinality

 Scenario: Check login functinality of valid user 

Given user is on login page 
When user enter the username "standard_user" and password "secret_sauce"
And click on the Login button
Then user is navigated to Landing page

@Login
Scenario: Check login functinality of invalid user 

Given user is on login page 
When user enter the username "koushik" and password "secret_sauce"
And click on the Login button
Then user should get message that credentails are not valid

