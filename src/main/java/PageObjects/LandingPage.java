package PageObjects;

import java.util.List;

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
	WebElement prodImage;
	
	@FindBy(xpath = "//div[@class='inventory_list']//div[@class='inventory_item_img']")
	WebElement prodImge;
	
	@FindBy(xpath = "//div[@class='inventory_item_label']//a[@id='item_"+0+"title_link']")// 0 is element changes with changing value of zero
	WebElement prodName;
	
	@FindBy(xpath = "//div[@class='inventory_list']//div[@class='inventory_item'][1]")// 1 is element changes with changing value of zero
	WebElement price;
	
	@FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory ']")
	WebElement addCart;
	
	@FindBy(xpath = "//div[@class='inventory_list']//div[@class='inventory_item']//button") // [n] generalized xpath for ADD to cart
	List<WebElement> addCarts;
	
	public void clickOnMenu()
	{
		webelements.clickInput(BtnMenu, 10);
	}
	
	public Boolean LandingPageTitleDisplay()
	{
		webelements.displayed(titleproduct, 10);
		System.out.println("displayed");
		return webelements.displayed(titleproduct, 10);
		
	}
	
	
}
