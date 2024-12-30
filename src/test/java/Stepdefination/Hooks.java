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

public class Hooks {
WebDriver driver;

@Before
public void setup() 
{
	Testbase.webdriverManeger();
}
	

@After
public void tearDown() throws InterruptedException 
{ 
	
	
	if(driver!=null)
   Testbase.getDriver().quit(); // Quit the driver after each scenario
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
