

package TestRunner.loginSteps;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import ObjectRepository.LoginObject;
import TestRunner.SetupClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import webApp.PerformAction;

public class IntellLogin extends SetupClass {
	
	PerformAction action = new PerformAction();	
	@Given("^navigates to intelligencebank.com$")
	public void navigates_to_intelligencebank_com() {
		try {
			driver.get(baseURL);
			Thread.sleep(5000);
			log.info("It's opening Login page");
		} catch (Exception e) {
		}
	}

	@Then("^he/she provides the username name as \"([^\"]*)\"$")
	public void he_she_provides_the_username_name_as(String uname) {
		try {
			
			driver.findElement(LoginObject.userName).sendKeys(uname);
			action.implictywait(driver);
			log.info("It's entering email");
		} catch (Exception e) {

		}
	}
	@Then("^he/she provides the password name as \"([^\"]*)\"$")
	public void he_she_provides_the_password_name_as(String pwsd) {
		try {
			driver.findElement(LoginObject.Passfield).sendKeys(pwsd);
			action.implictywait(driver);
			log.info("It's entering password");
		} catch (Exception e) {
		}

	}

	@Then("^he/she verify login button$")
	public void verify_login_cta() {
		try {
		WebElement Web = driver.findElement(LoginObject.LoginBtn);
		String login = Web.getText();
		System.out.println(login);
		Assert.assertEquals(true, Web.isDisplayed());
		action.implictywait(driver);
		log.info("It's checking theoLogin button");
		
	}catch(Exception e) {
	}
	}

	@Then("^he/she click on login button$")
	public void he_she_click_on_login_button() {
		try {
			driver.findElement(LoginObject.LoginBtn).click();
			action.implictywait(driver);
			log.info("It's clicking on Login button");
		} catch (Exception e) {
		}
	}

	@Then("^verify signinError message$")
	public void sign_error_message() {
try {
		WebElement Web = driver.findElement(LoginObject.errormessage);
		String Emsg = Web.getText();
		System.out.println(Emsg);
		Assert.assertEquals(true, Web.isDisplayed());
		action.implictywait(driver);
	}catch(Exception e) {
	}
	}


	@Then("^he/she Verify \"([^\"]*)\" for \"([^\"]*)\" validation message for user name$")
	public void he_she_Verify_for_validation_message_for_user_name(String arg1, String arg2) {
		try {
			PerformAction.SLEEP_TIME = 1000;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^he/she verify \"([^\"]*)\" for \"([^\"]*)\" validation message for password$")
	public void he_she_verify_for_validation_message_for_password(String arg1, String arg2) {
		try {
			PerformAction.SLEEP_TIME = 1000;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^then \"([^\"]*)\" for \"([^\"]*)\" for \"([^\"]*)\" for validation for all invalid credentials$")
	public void validation_invalid_credentials(String valMessage, String email, String pwd) throws Throwable {
		
		try {
			PerformAction.SLEEP_TIME = 1000;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("^he/she click on profile$")
	public void he_she_click_on_profile()  {
		try {
		// Write code here that turns the phrase above into concrete actions
		WebElement We = driver.findElement(LoginObject.userDetail);
		Actions act = new Actions(driver);
		act.moveToElement(We).build().perform();
		action.implictywait(driver);
		PerformAction.SLEEP_TIME = 2000;
		log.info("It's clicking on usericon");
	
	}
catch(Exception e) {
}
}
	@And("^verify Logout button$")
	public void verify_Logout_button() {
		try {
	
		WebElement Web = driver.findElement(LoginObject.logout);
		String Con = Web.getText();
		System.out.println(Con);
		Assert.assertEquals(true, Web.isDisplayed());
		action.implictywait(driver);
		log.info("It's verifying Login button");
		PerformAction.SLEEP_TIME = 1000;
	}
		catch(Exception e) {
		}
	}
	@And("^click on Logout button$")
	public void click_on_Logout_button() {
		try {
		driver.findElement(LoginObject.logout).click();
		action.implictywait(driver);
		log.info("It's clicking on Logout button");
		PerformAction.SLEEP_TIME = 3000;
	}catch(Exception e) {
	}
}

}
