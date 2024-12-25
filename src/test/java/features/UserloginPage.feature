
Feature: user login functinality

 Scenario: Check login functinality of valid user 

Given user is on login page 
When user enter the username "standard_user" and password "secret_sauce"
And click on the Login button
Then user is navigated to Landing page


 
