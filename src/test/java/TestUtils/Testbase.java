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
  protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
 public static WebDriver webdriverManeger() throws InterruptedException 
  {
	     // logic for reading the property
	 Thread.sleep(1000);
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
			 threadLocalDriver.set(new ChromeDriver());
		 }
		 else if (browser.equalsIgnoreCase("FirFox")) {
			 threadLocalDriver.set(new FirefoxDriver());
		}
		 else if (browser.equalsIgnoreCase("Edge")) {
			 threadLocalDriver.set(new EdgeDriver());
			}
	 }
	 
	 
	 
    
	 threadLocalDriver.get().get(url);;
	 threadLocalDriver.get().manage().deleteAllCookies();
	 threadLocalDriver.get().manage().window().maximize();
	 threadLocalDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	   return threadLocalDriver.get();
	  
  }
  
  
  public static WebDriver  getDriver()
  {
	  return threadLocalDriver.get();
  }
  
	
}
