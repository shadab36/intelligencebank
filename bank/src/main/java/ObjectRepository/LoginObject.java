package ObjectRepository;

import org.openqa.selenium.By;

/**
 * 
 * @LoginObjects Here I have created all objects which we will use to 
 * run Login test cases.
 *
 */
public class LoginObject {
	// Login Object
	public static By userName = By.name("username");
	public static By Passfield = By.name("password");
	public static By LoginBtn = By.name("submitBtn");
	public static By errormessage = By.id("ib-alerts");
	public static By userDetail = By.id("menu-userDetail");
	public static By logout = By.xpath("//*[@href='/logout/']");
	
}