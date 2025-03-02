package Stepdefination;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import TestUtils.Testbase;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Testbase {
WebDriver driver;

@Before
public void setup() throws InterruptedException 
{
	webdriverManeger();
}
	

@After
public void tearDown() throws InterruptedException 
{ 
	
	
	if(getDriver()!=null)
	{
   Testbase.getDriver().quit(); 
	}// Quit the driver after each scenario
	threadLocalDriver.remove();
	Thread.sleep(1000);
}
	

@AfterStep
public void AddScreenshot(Scenario scenario) throws IOException
{    WebDriver driver=Testbase.getDriver();
	if(scenario.isFailed())
{
	//
		System.out.println("taking screenshots");
		File sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent=FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
}
	
}

}
