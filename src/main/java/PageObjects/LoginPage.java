package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.UtilityElements;

public class LoginPage {
   
	WebDriver driver ;
	UtilityElements utilityelements;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.utilityelements=new UtilityElements(driver);
	}
	
	
	@FindBy(xpath = "//input[@id='user-name']")
	WebElement txtLoginUserName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement txtLoginPassword;

	@FindBy(xpath = "//input[@id='login-button']")
	WebElement btnLogin;
	@FindBy(xpath = "//h3[contains(text(), \"Epic sadface:\")]")
	WebElement WarningMessege;
	
	public void LoginCredentials(String userName ,String password) throws InterruptedException 
	{
		utilityelements.textInput(txtLoginUserName,10 ,userName);
	
		utilityelements.textInput(txtLoginPassword,10,password);
		
		
	}

	
	public boolean inavalidCredentailsMsg()
	{
		
		utilityelements.displayed(WarningMessege, 10);
		return true;
	}
	public LandingPage clickonLoginButton( )
	{   
		utilityelements.clickInput(btnLogin, 10);
		System.out.println("clicked");
		return new LandingPage(driver);
	}
	
	
}
