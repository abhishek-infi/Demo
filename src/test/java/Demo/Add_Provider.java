package Demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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

        
		// Click on 'Provider' option.
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/aside[1]/div/nav/ul/li[5]/a"))).click();
			
		
	    // Click on 'Create New' button.
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("createProvider")).click();

		// Select VMware Provider
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='createProvider']/div/div/div/div/div[2]/div[3]/div/div/div[2]/div/p/a"))
				.click();

		// Enter VMware Provider Name
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("vmware_provider_name")).sendKeys("VMware55 Infiverve");

		// Description
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("vmware_provider_description")).sendKeys("VMware_55_Testing");

		// VMware URL
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("vmware_provider_hostname")).sendKeys("vmware55.infiverve.com:5443");

		// Enter Username
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("vmware_provider_username")).sendKeys("root");

		// Enter Password
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("provider_password")).sendKeys("vmware");

		// Click on Register Button

		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(".//*[@id='vmwareForm']/div[4]/div[2]/button[1]")).click();
		
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		

	}
	
	  
	  
	  
	 
	public static void main (String[] args) throws Exception
	{
		Add_Provider AP = new Add_Provider();
		AP.setupApplication();
	    AP.signin();
		 synchronized (AP) {
	            AP.wait(1000);
	        }
		 AP.Provider();
		
	}

	@AfterClass
	public void ending() {
		
		driver.quit();

	}

}
