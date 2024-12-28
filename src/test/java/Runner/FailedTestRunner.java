package Runner;



import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class FailedTestRunner {
	@CucumberOptions(features = "@target/failed_Scenarious.txt" ,glue = "Stepdefination",
			monochrome=true,plugin= {"pretty","html:target/cucumber.html", "json:target/cucumber.json",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} )
			public class TestNGRunner extends AbstractTestNGCucumberTests {
			    
				   @Override
				    @DataProvider(parallel =false)
				   public  Object[][] scenarios()
				   {
					   return super.scenarios();
				   }
				
				
			}
}
