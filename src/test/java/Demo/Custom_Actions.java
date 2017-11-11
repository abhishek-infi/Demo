package Demo;

import org.testng.annotations.Test;

import Pages.custom_actions_page;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;

public class Custom_Actions extends start {
	
	String driverPath = "D:\\geckodriver-v0.16.1-win64\\geckodriver.exe";
	


	  @Test ()
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
	
  @Test (dependsOnMethods={"signin"})
  public void create_custom_action() {
	   
	  
	  new custom_actions_page(driver)
	  .submit();
	  
	  
	  new custom_actions_page(driver)
	  .admin();
	  
	  
	  new custom_actions_page(driver)
	  .custom_ac();
	  
	 
	  new custom_actions_page(driver)
	  .createnew();
	  
	  
	  new custom_actions_page(driver)
	  .nameAs("name")
	  .descriptionAs("description");
	  
	  
	  new custom_actions_page(driver)
	  .category();
	 
	  
	  new custom_actions_page(driver)
	  .assetsubtype();
	  
	  
	  new custom_actions_page(driver)
	  .assettype();

	  
	  new custom_actions_page(driver)
	  .flintnameAs("Flintname");
	  
	  
	  new custom_actions_page(driver)
	  .submit_butto();
	  
	  
	  new custom_actions_page(driver)
      .Save_Button();
  }
  
  public static void main (String[] args) throws Exception
  {
	  Custom_Actions CS = new Custom_Actions ();
	  
	  CS.signin();
	  CS.create_custom_action();
	  
  }
   
  @AfterTest
  public void afterTest() {
	  
	//  driver.quit();
  }

}
