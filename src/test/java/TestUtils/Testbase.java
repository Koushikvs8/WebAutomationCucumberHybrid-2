package TestUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public  class Testbase {
  public static  WebDriver driver;
  public static Properties prop; 
  private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
 public static WebDriver webdriverManeger() 
  {
	     // logic for reading the property
	  prop= new Properties();
	  FileInputStream file = null;
	try {
		file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\Resources\\config.properties");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   try {
		prop.load(file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	  
	 String browser=prop.getProperty("browser");
	 String url =prop.getProperty("QAUrl");
	  
	 if(driver==null)
	 {
		 if(browser.equalsIgnoreCase("chrome")) {
			 driver=new ChromeDriver(); 
		 }
		 else if (browser.equalsIgnoreCase("FirFox")) {
			 driver=new FirefoxDriver();
		}
		 else if (browser.equalsIgnoreCase("Edge")) {
			 driver=new EdgeDriver();
			}
	 }
	 
	 
	 
    
     driver.get(url);
     driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	   return driver;
	  
  }
  
  
  public static WebDriver  getDriver()
  {
	  return driver;
  }
  
	
}
