package TestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "F:\\AutoProject\\bank\\src\\test\\resources\\Intelligence.feature" }, format = {
		"pretty", "html:target2" })
public class Ruuner {

	@BeforeClass
	public static void beforeClass() throws Exception {
		
			SetupClass.before_Class();
		
	}

	@AfterClass
	public static void afterClass() throws Exception {
	
			SetupClass.afterClass();

		
	}

}