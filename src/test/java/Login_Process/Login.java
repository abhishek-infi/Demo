package Login_Process;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Demo.start;

public class Login extends start {
	
  
  @BeforeClass
  public void starting()
  {
	  System.out.println("Lets Login!!"); 
  } 
 
  @Test (description="signin")
    public void signin()throws Exception{ 
	  
	new LoginPages(driver)
	  .usernameAs("admin")
	  .passwordAs("admin123")
	  .submit();
	 
	  

     }
  public static void main() throws Exception{
	   	 
        Login Lg = new Login();
     	Lg.setupApplication();
  		Lg.signin();
  	 
  }

  @AfterClass
	public void ending() {
		
	//	driver.quit();
		
	}
     
     
     }