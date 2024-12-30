package Stepdefination;

import org.openqa.selenium.WebDriver;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import PageObjects.PageObjectManeger;
import TestUtils.Testbase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class productinformation {
	 WebDriver driver ;
	  LandingPage landingpage;
	  LoginPage loginpage;
	  PageObjectManeger pageobject;
	  
	@Then("user should navigate to product information page and AddCard button as Remove")
	public void user_should_navigate_to_product_information_page_and_add_card_button_as_remove() {
	   
		
		  pageobject =new PageObjectManeger(driver);
		 landingpage=pageobject.getLandingPage();
	}

	
	
}
