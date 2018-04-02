package TestRunner;

import java.io.FileReader;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import GenericAction.ReusableActions;
import webApp.CommonData;

public class SetupClass {
	public static WebDriver driver;
	public static String baseURL;
	public static String appiumVersion;
	public static Properties property = new Properties(System.getProperties());
	public static String sauceURL;
	public static String browserName;
	public static String platformVersion;
	public static String platform;
	public static String platformName;
	public static String deviceName;
	public static String deviceOrientation;
	public static String oncloud;
	public static String onjenkins;
	public static Logger log;
	public static DesiredCapabilities capabilities;
	public static ReusableActions reusableMethods = new ReusableActions();
	public static String lbrowser;
public static String localtest;
	
@BeforeClass
	public static void before_Class() throws Exception {
		log = Logger.getLogger(BeforeClass.class.getName());
		property.load(new FileReader(
				"F:\\AutoProject\\bank\\src\\main\\resources\\configuration.property"));

		baseURL = property.getProperty("base_url");
		sauceURL = property.getProperty("sauce_url");
		deviceName = property.getProperty("device_name");
		browserName = property.getProperty("browser");
		appiumVersion = property.getProperty("appium_version");
		platformVersion = property.getProperty("platform_version");
		platformName = property.getProperty("platform_name");
		platform = property.getProperty("platform");
		oncloud = property.getProperty("oncloud");
		onjenkins = property.getProperty("onjenkins");
		lbrowser= property.getProperty("local_browser");
		localtest=property.getProperty("localtest");
		/*** To run desktop project condition if onMobile is equal to "no" then */
		//if (browser.equalsIgnoreCase("chrome"))
		if ((localtest.equals("yes"))&& oncloud.equals("no")) {
			/*** To run desktop project on local */
			lbrowser= System.setProperty(CommonData.Chrome_Name, CommonData.Chrome_Path);
			lbrowser=System.getProperty("local_browser");
			driver=new ChromeDriver();
			System.out.println("Bname====="+baseURL);
			System.out.println(lbrowser);
			System.out.println(baseURL);
		} 
		else if ((oncloud.equals("yes"))&& onjenkins.equals("no")) {
			baseURL = property.getProperty("base_url");
			System.out.println("Bname====="+baseURL);
			sauceURL = property.getProperty("sauce_url");
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "64");
			caps.setCapability("name", "My Desktop automation test");
			driver = new RemoteWebDriver(new URL(sauceURL), caps);
			
		}
		else {
			System.out.println("test");
			browserName = System.getenv("SELENIUM_BROWSER");
			platform = System.getenv("SELENIUM_PLATFORM");
			platformVersion = System.getenv("SELENIUM_VERSION");

			System.out.println("browserName======" + browserName);
			System.out.println("platform======" + platform);
			System.out.println("platformVersion====" + platformVersion);

			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("platform", platform);
			capability.setBrowserName(browserName);
			// capability.setCapability("browser", browserName);
			capability.setCapability("version", platformVersion);
			capability.setCapability("name",
					"My Desktop automation test******************");

			driver = new RemoteWebDriver(new URL(sauceURL), capability);
			System.out.println("after run");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void afterClass() throws InterruptedException {
		try {
		Thread.sleep(3000);
		driver.quit();
		
}catch (Exception e) {
}}
}
