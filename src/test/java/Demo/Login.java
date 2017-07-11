package Demo;

import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class Login extends start {
	
	
    String driverPath = "/usr/local/bin/geckodriver";
   //public WebDriver driver ;
    
    
    public static void main(String args[]) throws Exception{
   	 
    	Login Lg = new Login();
    	
    	Lg.setupApplication();
    	Lg.signin();
    	 
    }

    
    @Test (description="signin")
    public void signin(){     
    	 
			 // To Locate the Username field
			    	 
			driver.findElement(By.id("username")).sendKeys("admin");
			
			
			// To locate the Password field
			
			driver.findElement(By.id("password")).sendKeys("admin123");
			
			
			// Click on Login button
			
			driver.findElement(By.id("submit")).click();
			
			


     }
     
     
     
     }
     

     
     
     
