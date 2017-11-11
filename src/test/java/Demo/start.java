package Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class start {
	
	
public static WebDriver driver;
	
	@BeforeClass
	public void setupApplication()
	{ 
	     System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.16.1-win64");
	     System.setProperty("webdriver.chrome.driver", "D:\\Abhishek K\\CromeDriver\\chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     driver.manage().window().maximize(); 
	     driver.get("http://opshub.flintcloud.info");
	       
		
	}
	@AfterClass
	public void closeApplication()
	{
	//	driver.quit();
		
	}
}
