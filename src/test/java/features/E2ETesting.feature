
@E2E
Feature: E2E fuctinality of user from login to Checkout page
  I want to use this template for my feature file

Scenario: Check login functinality of valid user 

Given user is on login page 
When user enter the username "standard_user" and password "secret_sauce"
And click on the Login button
Given user is on Landing page
When user click on the menu button
Then user should see 
    |All items |
    | About |
    | Logout |
    |Reset app state  |
   And page title should be "String"
Given user is on Landing page
When click on the given <products> 
And click on addcart button 
Then user should navigate to product information page and AddCard button as Remove
  
   Examples:
   |products|
  |Sauce Labs Onesie|
   |Sauce Labs Bike Light|
   |Sauce Labs Bolt T-Shirt|
   |Sauce Labs Backpack|
    |Sauce Labs Fleece Jacket|
  |Test.allTheThings() T-Shirt (Red)|

 

  