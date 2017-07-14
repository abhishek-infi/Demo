package Demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Pages.add_provider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;


public class Add_Provider extends start {

	String driverPath = "/usr/local/bin/geckodriver";
	


	  @Test (description="signin")
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
	
	@Test(description = "add provider", dependsOnMethods={"signin"})

	private void Provider() throws Exception {
		
		
		// Click on Provider option from Add Provider.
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
         add_provider.Provider(driver).click();
         
         //Click on Create_New button 
         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
         add_provider.Create_New(driver).click();
         
         // Click on VMware Provider Option
         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
         add_provider.VMware(driver).click();
         
         
         // Enter VMware Name
         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
         add_provider.Provider_name(driver).sendKeys("VMware_Demo");
         
         // Enter Description
         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
         add_provider.vmware_provider_description(driver).sendKeys("Description");
         
         
         // Enter Hostname
         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
         add_provider.vmware_provider_hostname(driver).sendKeys("vmware55.infiverve.com:5443");
         
         // Enter Provider Username
         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
         add_provider.vmware_provider_username(driver).sendKeys("root");
         
         // Enter Password
         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
         add_provider.provider_password(driver).sendKeys("vmware");
         
         // Click on Register button
         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
         add_provider.Register_button(driver).click();
         
       }
	 
	public static void main (String[] args) throws Exception
	{
		Add_Provider AP = new Add_Provider();
		AP.setupApplication();
	    AP.signin();
		 /*synchronized (AP) {
	            AP.wait(1000);
	        }*/
		 AP.Provider();
		
	}

	@AfterClass
	public void ending() {
		
		//driver.quit();

	}

}
