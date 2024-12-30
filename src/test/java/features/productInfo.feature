


Feature: product information Fuctinality

 Background:
 Scenario Outline:
   Given user is on login page 
   When user enter the username "standard_user" and password "secret_sauce"
   And click on the Login button
   Given user is on Landing page
   When click on the product
   |Sauce Labs Onesie|
   Then user should navigate to product information


 Scenario: Check login functinality of valid user 

Given  click on addcart buttone

