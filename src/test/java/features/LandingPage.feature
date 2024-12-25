
Feature: Landing page Functinality


  Scenario: user can Navigate to LandingPage
   Given user is on login  page 
   Given user is on Landing page
   When user click on the menu button
   Then user should see 
    |All items |
    | About |
    | Logout |
    |Reset app state  |
   And page title shold be "String"
    
 

 