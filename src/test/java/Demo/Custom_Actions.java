package Demo;

import org.testng.annotations.Test;

import Pages.custom_actions;

import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Custom_Actions extends start {
	
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
	
  @Test (description = "create custom action", dependsOnMethods={"signin"})
  public void create_custom_action() {
	   
	  
	  // Click on Menu on right side of page
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  custom_actions.Menu(driver).click();
	  
	  
	  // Click on ADMINISTRATION module
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  custom_actions.Administration(driver).click();
	  
	  
	  //Click on Custom Action option
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  custom_actions.Custom_Action(driver).click();
	 
	  // Click on Create New button 
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  custom_actions.Create_New_Button(driver).click();
	  
	  // Enter value in Identifier field
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  custom_actions.identifier(driver).sendKeys("start");
	  
	  // Enter value in Name field
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  custom_actions.name(driver).sendKeys("Start");
	  
	  // Eneter value in Description field
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  custom_actions.action_description(driver).sendKeys("Testing");
	  
	  // Select Aseet Categoty 
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  custom_actions.asset_category(driver).click();
	 
	 // Clickable element is remaining
	  
	 
	  // Option COMPUTE
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  custom_actions.COMPUTE(driver).click();
	  
	  
	  // Select Asset Type 
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  custom_actions.asset_type(driver).click();
	 /* 
	  // Select VIRTUAL MACHINE option
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  custom_actions.VIRTUAL_MACHINE(driver).click();
	  */
	  
	  // Select Asset Subtype
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  custom_actions.asset_subtype(driver).click();
	 
	  // Enter Flintbit 
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  custom_actions.flintbit_name(driver).sendKeys("example:hello.rb");
	  
	  // Click on Submit button 
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  custom_actions.submit_Button(driver).click();
	  
	 }
  
  public static void main (String[] args) throws Exception
  {
	  Custom_Actions CS = new Custom_Actions ();
	  
	  CS.signin();
	  CS.create_custom_action();
	  
  }
   
  @AfterTest
  public void afterTest() {
  }

}
