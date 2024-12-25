package Stepdefination;

import java.util.List;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Landingpage {
      WebDriver driver ;
	
	
	@Given("user is on Landing page")
	public void user_is_on_landing_page() {
	    
	}

	@When("user click on the menu button")
	public void user_click_on_the_menu_button() {
	   
	}

	@Then("user should see")
	public void user_should_see(io.cucumber.datatable.DataTable dataTable) {
	  List<String> elements=dataTable.asList(String.class);
	  
	  
	  
	}

	@Then("page title shold be {string}")
	public void page_title_shold_be(String string) {
	  
	}
}
