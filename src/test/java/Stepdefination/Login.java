package Stepdefination;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	WebDriver driver;
	LoginPage login;
	LandingPage landingPage;
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://www.saucedemo.com/");
	   
	}

	@When("user enter the username {string} and password {string}")
	public void user_enter_the_username_and_password(String username, String password) throws InterruptedException {
	   login =new LoginPage(driver);
	   login.LoginCredentials(username, password);
	}

	@When("click on the Login button")
	public void click_on_the_login_button() {
		login.clickonLoginButton();
	}

	@Then("user is navigated to Landing page")
	public void user_is_navigated_to_Landing_page() {
		
		landingPage=new LandingPage(driver);
		Boolean status=landingPage.LandingPageTitleDisplay();
	    Assert.assertTrue(status);
	}
}
