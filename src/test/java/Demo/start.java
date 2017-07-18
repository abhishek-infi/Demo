package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class start {
	
	
public WebDriver driver;
	
	@BeforeClass
	public void setupApplication()
	{
		
		
		//System.out.println("--------Driver----------"+driver.getClass());
		
		        final FirefoxProfile firefoxProfile = new FirefoxProfile();
	            firefoxProfile.setPreference("xpinstall.signatures.required", false);
	            driver = new FirefoxDriver(firefoxProfile);
	            driver.get("http://swoop.infiverve.com");
                System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.16.1-win64");
                System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		        driver.manage().window().maximize();
		
		
		
		
        
		
	}
	
	
	@AfterClass
	public void closeApplication()
	{
	//	driver.quit();
		
	}
}
