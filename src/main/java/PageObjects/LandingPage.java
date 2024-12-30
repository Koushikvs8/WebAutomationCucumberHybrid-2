package PageObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.UtilityElements;

public class LandingPage {
	WebDriver driver ;
	UtilityElements webelements;
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		webelements=new UtilityElements(driver);
	}
	
	
	@FindBy(xpath = "//span[@class='title']")
	WebElement titleproduct;
	
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    WebElement BtnMenu;
	
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
    WebElement BtnLogout;
	
	@FindBy(xpath = "//a[@id='about_sidebar_link']")
    WebElement aboutlink;
	
	@FindBy(xpath = "//a[@id='inventory_sidebar_link']")
    WebElement allitemlink;
	
	@FindBy(xpath = "//a[@id='reset_sidebar_link']")//button[@id='react-burger-cross-btn']
    WebElement resetLink;
	
	@FindBy(xpath = "//button[@id='react-burger-cross-btn']")
    WebElement BtnCrossMenu;
	///////////////////////// products elements////////////
	@FindBy(xpath = "//div[@class='inventory_list']//div[@class='inventory_item']")
     List<WebElement> productItems;
	
	
	@FindBy(xpath = "//div[@class='inventory_list']//div[@class='inventory_item_img']")
	WebElement prodImge;
	
	@FindBy(xpath = "//div[@class='inventory_item_label']//a//div[text()=\"Sauce Labs Backpack\"]']")// 0 is element changes with changing value of zero
	WebElement prodName;
	
	By prodNames = By.xpath( "//div[@class='inventory_item_label']//a//div[text()=\"String\"]']");//String is replaced by the product name in user logic
	
	@FindBy(xpath = "//div[@class='inventory_list']//div[@class='inventory_item'][1]")// 1 is element changes with changing value of zero
	WebElement price;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement shoppingCartLink;
	
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	WebElement shoppingCartCount;
	
	@FindBy(xpath = "//div[@class='inventory_item']//div[2]//a/div[text()='Sauce Labs Bike Light']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']") // [n] generalized xpath for ADD to cart
	List<WebElement> addCarts;
	
	public void clickOnMenu() 
	{
		webelements.clickInput(BtnMenu, 10);
		System.out.println("clicked");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void CloseMenu() 
	{
		webelements.clickInput(BtnCrossMenu, 10);
		
	}
	
	
	public Boolean LandingPageTitleDisplay()
	{
		webelements.displayed(titleproduct, 10);
		System.out.println("displayed");
		return webelements.displayed(titleproduct, 10);
		
	}
	
	
	public Boolean menuOptionsDisplay(List<String> list)
	{   boolean status=false;
		List<String> list1=new ArrayList<String>(list);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list1);
		for (String string : list1) {
		
			if(string.equals("All items"))
			{
				status=webelements.displayed(allitemlink, 10);
				
			}
			else if (string.equals("About")) {
				status=webelements.displayed(aboutlink, 10);
			}
            else if (string.equals("Logout")) {
            	status=webelements.displayed(BtnLogout, 10);
			}
              else if (string.equals("Reset app state")) {
            	  status= webelements.displayed(resetLink, 10);
			}
         	
		}
	   
		System.out.println("displayed");
		System.out.println(status);
		return status;	
	}
	///////////
	
	public Boolean productTitleDisplay()
	{
		boolean status= webelements.displayed(titleproduct, 10);
		return status;
	}
	
	//////////////////
	public ProductInfPage clickOnProducts(String product) 
	{   
	    	  webelements.clickInput(driver.findElement(By.xpath("//div[@class='inventory_item']//div[2]//a/div[text()='"+product+"']")), 10);
	    	  
		return new ProductInfPage(driver);


	}
	//public ProductInfPage clickOnProducts(List<String> product) 
	//{   
	 //   	  webelements.clickInput(driver.findElement(By.xpath("//div[@class='inventory_item']//div[2]//a/div[text()='"+product+"']")), 10);
	  //  	  
	//	return new ProductInfPage(driver);


	//}
	
	public CartPage shoppingCartLink()
	{
		webelements.clickInput(shoppingCartLink, 10);
		
		return  new CartPage(driver);
	}
	
	public String shoppingCartCount()
	{
		
		return webelements.getTextfromElement(shoppingCartCount, 10);
		
	}
	
///////////////
}
