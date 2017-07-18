package Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import Pages.login;

public class Login extends start {
	
  public static void main(String args[]) throws Exception{
   	 
	    final FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("xpinstall.signatures.required", false);
        
        Login Lg = new Login();
    	
    	Lg.setupApplication();
    	Lg.signin();
    	 
    }
  @Test (description="signin")
    public void signin(){ 
    	    // Enter Username	
    	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 	 
			login.Username(driver).sendKeys("admin");
			
			// Enter Password
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			login.Password(driver).sendKeys("admin123");
			
			// Click on SignIn button
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			login.Submit_button(driver).click();
			
			


     }
     
     
     
     }
     

     
     
     
