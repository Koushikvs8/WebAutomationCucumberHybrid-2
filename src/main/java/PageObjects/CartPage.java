package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.UtilityElements;

public class CartPage {
	WebDriver driver ;
	UtilityElements webelements;
	
	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		webelements=new UtilityElements(driver);
	}

	@FindBy(xpath = "//button[@id='continue-shopping']")
	WebElement continueShoppingBtn;
	
	@FindBy(xpath = "//button[@id='checkout']")
	WebElement checkOutBtn;
	
	
	@FindBy(xpath = "//div[@class=\"cart_item\"]/ancestor::div[@class=\"cart_list\"]//div[@class=\"item_pricebar\"]//button")
	WebElement cartProducts;
	
	

}
