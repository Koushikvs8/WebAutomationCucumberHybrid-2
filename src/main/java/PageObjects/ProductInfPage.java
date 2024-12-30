package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.UtilityElements;

public class ProductInfPage {
	WebDriver driver ;
	UtilityElements utilityelements;
	
	public ProductInfPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.utilityelements=new UtilityElements(driver);
	}
	
	
	@FindBy(xpath = "//button[@id='add-to-cart']")
	WebElement addCart;

	

	@FindBy(xpath = "//button[@id='remove']")
	WebElement remove;
	
	
	

	@FindBy(xpath = "//button[@id='back-to-products']")
	WebElement backtoProductsButton; 
	
	public void clickOnAddCart() 
	{
		
		utilityelements.clickInput(addCart, 10);
         
	}
   
	
	public LandingPage backToLandingPage() 
	{
		
		utilityelements.clickInput(backtoProductsButton, 10);
       return new LandingPage(driver);
	}
	
	public Boolean backToLandingPageDisplay() 
	{
		
		Boolean status=utilityelements.displayed(backtoProductsButton, 10);
       return status;
	}
	public Boolean removeButtoneDisplay() 
	{
		
		Boolean status=utilityelements.displayed(remove, 10);
       return status;
	}
	
	
	
}
