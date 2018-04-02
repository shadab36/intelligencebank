package TestHelper;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import GenericAction.Driver;
import ObjectRepository.LoginObject;

/**
 * 
 * @SetupClassExtends Here I have extends SetupClass to access all 
 * Setup Methods and Objects files.
 *
 */
public class LoginHelper extends Driver {

	/**
	 * 
	 * @getValMessageforgetHTML5messages Here I have used Java "Object" 
	 * class to access "getValMessage"
	 * Method and then created object "s" to store "js script executer" message value.
	 *
	 */
	
	public Object getValMessage(String str) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object s = js.executeScript("return document.getElementById('" + str
				+ "').validationMessage");
		System.out.println(s);
		 log.info("It's getting HTML5 validation message using JS executor");
		return s;
		
	}
	
	/**
	 * 
	 * @verifyLoginValMessage Here I am verifying Login Validation messages and for that
	 * I have created Regular Expressions to match the email if it "false" 
	 * and/or password blank then it will  compare HTML 5 error messages and if Email
	 * Format is correct then it will verify server side validation which appearing
	 * in red
	 *
	 */

	public void verifyLoginValMessage(String commonVal, String uName, String pwd) {
		/**
		 * 
		 * @RegularExpression I have stored regex in string "emailregex" then
		 * created "Boolean b" and match "uname" string with "emailregex" string.
		 * to check email is valid or not.
		 */
		String emailregex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		Boolean b = uName.matches(emailregex);
		log.info("It's verifying valid or invalid email using email regular expression");

		/**
		 * 
		 * @CheckEmailFormat If you un-comment if else condition it will print
		 * Email Address is Invalid or Valid
		 * 
		 *  if (b == false) {
			System.out.println("Email Address is Invalid");
		} else if (b == true) {
			System.out.println("Email Address is Valid");
		}
		 *
		 */	
		
		if (b == true && !pwd.isEmpty()) {
			log.info("It's running condition if email is valid and password is empty");
			/**
			 * 
			 * @Emailvlaid Here b is equals true means email is valid and password
			 * is not empty then it will check red validation message.
			 *
			 */
			reusableMethods.verifElementVisible(30, LoginObject.errormessage);
			String actualCommonErrMsg = driver.findElement(
					LoginObject.errormessage).getText();
			Assert.assertEquals(commonVal, actualCommonErrMsg);
		} else if (b == false) {
			log.info("It's running condition if email is invalid");
			/**
			 * 
			 * @Emailvlaid Here b is equals false means email is invalid 
			 *  then it will check HTML5 validation message for email.
			 *
			 */
			
			Assert.assertEquals(getValMessage("email"), commonVal);
		} else if (b == true && pwd.isEmpty()) {
			log.info("It's running condition if email is invalid and password is filled");
			/**
			 * 
			 * @Emailvlaid Here b is equals true means email is valid and password
			 * is empty then it will check HTML5 validation message for password.
			 *
			 */
			Assert.assertEquals(getValMessage("password"), commonVal);
		} 

	}

}