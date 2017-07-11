package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class start {
	
	
public WebDriver driver;
	
	@BeforeClass
	public void setupApplication()
	{
		
		
		//System.out.println("--------Driver----------"+driver.getClass());
                driver=new FirefoxDriver();
	
		driver.manage().window().maximize();
		
		driver.get("http://swoop.infiverve.com");
		
		
		
	}
	
	
	@AfterClass
	public void closeApplication()
	{
		driver.quit();
		
	}
}
