package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManeger {
   WebDriver driver;
   LandingPage landingpage;
   
 
 public PageObjectManeger(WebDriver  driver)
 {
	 this.driver=driver;
 }
 
 public LandingPage getLandingPage()
 {    landingpage=new LandingPage(driver);
	 return landingpage;
 }
 
 
}
