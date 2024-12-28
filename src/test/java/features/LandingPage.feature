
Feature: Landing page Functinality

  Background:
   Given user is on login page 
   When user enter the username "standard_user" and password "secret_sauce"
   And click on the Login button

@LandingPage
  Scenario: user can see menu and its options
   Given user is on Landing page
   When user click on the menu button
   Then user should see 
    |All items |
    | About |
    | Logout |
    |Reset app state  |
   And page title should be "String"
    
 @Addcart
  Scenario Outline: select the product to Check its Details
  
   Given user is on Landing page
   When click on the given <products> 
   And click on addcart button
   Then user should navigate to product information page and AddCard button as Remove
   Examples:
   |products|
  |Sauce Labs Onesie|
   |Sauce Labs Bike Ligh|
   |Sauce Labs Bolt T-Shirt|
   |Sauce Labs Backpack|
   |Sauce Labs Fleece Jacket|
   |Test.allTheThings() T-Shirt (Red)|
   
 
   
   
   

 