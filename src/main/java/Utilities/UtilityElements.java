package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityElements {
  
	
	WebDriver driver;
	
	public UtilityElements(WebDriver driver)
	{
		this.driver=driver;
	}

	
	
	public void textInput(WebElement element , int seconds , String text )
	{
		  WebElement waitedelement=waitTillElementToBeClickable(element, seconds) ;
		  waitedelement.clear();
		  waitedelement.click();
		  waitedelement.sendKeys(text);
		  
	}
	
	public void clickInput(WebElement element , int seconds  )
	{
		  WebElement waitedelement=waitTillElementToBeClickable(element, seconds) ;
		 
		  waitedelement.click();
		  
	}
	public boolean displayed(WebElement element , int seconds  )
	{
		  WebElement waitedelement=waitTillElementToBeVisible(element, seconds) ;
		 return waitedelement.isDisplayed();
		  
	}
	
	
	
	
	public  WebElement waitTillElementToBeClickable(WebElement element , int seconds  )
	{   
	 WebElement  waitedelement= null;
		try {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(seconds));
		  waitedelement=wait.until(ExpectedConditions.elementToBeClickable(element));
	} catch (Exception e) {
		System.out.println("wainting explicity 10 secound");
		e.printStackTrace();
	}
	
  return waitedelement;

		
	}
	public  WebElement waitTillElementToBeVisible(WebElement element , int seconds  )
	{   
	 WebElement  waitedelement= null;
		try {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(seconds));
		  waitedelement=wait.until(ExpectedConditions.visibilityOf(element));
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		return waitedelement;
	}	
		
	}
	
	
	
	
	
	
}
