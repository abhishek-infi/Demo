package Login_Process;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Demo.start;
import Pages.login;

public class Login extends start {
	
  public static void main() throws Exception{
   	 
	    final FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("xpinstall.signatures.required", false);
        
        Login Lg = new Login();
    	
    	Lg.setupApplication();
    	Lg.signin();
    	 
    }
  
  @BeforeClass
  public void starting()
  {
	  System.out.println("Lets Login!!"); 
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
  
  @AfterClass
	public void ending() {
		
		driver.quit();
		
	}
     
     
     }
     

     
     
     
