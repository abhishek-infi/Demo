package Demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.add_provider_page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;



public class Add_Provider extends start {


	@BeforeClass
	public void starting()
	{
			
	System.out.println("Lets Begun!!");
		
	}
	    @Test (description="SignIn")
	    public void signin() throws Exception {     
	    	 
				 // To Locate the Username field
		        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
         	    driver.findElement(By.id("username")).sendKeys("admin");
				
				
				// To locate the Password field
         	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				driver.findElement(By.id("password")).sendKeys("admin123");
				
				
				// Click on Login button
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				driver.findElement(By.id("submit")).click();
	  }
	
	@Test(dependsOnMethods={"signin"})

	public void Provider() throws Exception {
		
		
		new add_provider_page(driver)
		.Menu();
		
		
		new add_provider_page(driver)
		.Administration();
		
		 
		new add_provider_page(driver)
		.Provider();
		
		 
		new add_provider_page(driver)
		.Create_New();
		
		 
		new add_provider_page(driver)
		.Type();
		
		
		new add_provider_page(driver)
		.ProvidernameAs("vmware456");
		
		
		new add_provider_page(driver)
		.DescriptionAs("testing");
		
		
		new add_provider_page(driver)
		.hostnameAs("vmware55.infiverve.com:5443");
		
		
		new add_provider_page(driver)
		.usernameAs("root");
	
		
		new add_provider_page(driver)
		.PasswordAs("vmware");
		
		 
		new add_provider_page(driver)
		.Verify_cred();
		
		
		new add_provider_page(driver)
		.Register_button();
		
		
       }
	 
	public static void main () throws Exception
	{
		Add_Provider AP = new Add_Provider();
		AP.setupApplication();
	    AP.signin();
		AP.Provider();
		
	}

	@AfterClass
	public void ending() {
		
		//driver.quit();

	}

}