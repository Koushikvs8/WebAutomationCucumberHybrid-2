package Stepdefination;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import PageObjects.PageObjectManeger;
import PageObjects.ProductInfPage;
import TestUtils.Testbase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Landingpage {
      WebDriver driver ;
	  LandingPage landingpage;
	  LoginPage loginpage;
	  PageObjectManeger pageobject;
	  ProductInfPage productinfo;
	  
	@Given("user is on Landing page")
	public void user_is_on_landing_page() {
		driver=Testbase.getDriver();
		  pageobject=new PageObjectManeger(driver);
		landingpage=pageobject.getLandingPage();
	}

	@When("user click on the menu button")
	public void user_click_on_the_menu_button() throws InterruptedException {
		landingpage.clickOnMenu();
		
		
	}

	@Then("user should see")
	public void user_should_see(io.cucumber.datatable.DataTable dataTable) {
	  List<String> elements=dataTable.asList(String.class);
	  boolean status= landingpage.menuOptionsDisplay(elements);
	  System.out.println(status);
	  
	  landingpage.CloseMenu();
	  
	  
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String string) {
		boolean status=landingpage.productTitleDisplay();
		System.out.println(status);
		  Assert.assertTrue(status);
	}

  //this method is for selecting the product for data sets(running same scenario for multiple products)
	@When("^click on the given (.+)$")
	public void click_on_the_product(String product) {
		 
		  landingpage.clickOnProducts(product) ;
		  
		 
	}
	
	@Then("user should navigate to product information page")
	public void user_should_navigate_to_product_information_page() {
		productinfo=new ProductInfPage(driver);
		boolean status= productinfo.backToLandingPageDisplay();
		Assert.assertTrue(status);
	
	}

 @When("click on addcart button")
 public void click_on_addcart_button() {
	 
	productinfo.clickOnAddCart();
	 
 }
 
 @Then("user should navigate to product information page and AddCard button should be Remove")
	public void user_should_navigate_to_product_information_page_and_add_card_button_as_remove() {
	 boolean status= productinfo.removeButtoneDisplay();
	    productinfo.backToLandingPage();
		Assert.assertTrue(status);
	
	}
	
	  //this method is for selecting the product 
		
		@When("click on the product")
		public void click_on_the_product(io.cucumber.datatable.DataTable dataTable) {
			List<String> elements=dataTable.asList(String.class);
			  // landingpage.clickOnProducts(elements);
		   
	
	
	
		}
		
}
