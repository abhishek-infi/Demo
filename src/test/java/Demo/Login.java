package Demo;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import Pages.login;

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
    	
    	
    	
            // Enter Username	
    	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 	 
			login.Username(driver).sendKeys("admin");
			
			// Enter Password
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			login.Password(driver).sendKeys("admin123");
			
			// Click on SignIn button
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			login.Submit_button(driver).click();
			
			


     }
     
     
     
     }
     

     
     
     
