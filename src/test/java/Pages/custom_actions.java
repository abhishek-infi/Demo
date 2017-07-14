package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Demo.start;

public class custom_actions extends start {
	
	private static WebElement element =null;
	
	// Navigation to the Custom Action Functionality.
	
	public static WebElement Menu (WebDriver driver){
		element = driver.findElement(By.xpath("html/body/div[1]/header/nav/div[2]/ul[2]/li/a"));
    return element;	
		
	}
	
	public static WebElement Administration (WebDriver driver){
		
		element = driver.findElement(By.xpath("html/body/div[1]/aside[2]/nav/div/ul/li/a[5]"));
		return element;
	}
	
	public static WebElement Custom_Action (WebDriver driver){
		
		element = driver.findElement(By.xpath("html/body/div[1]/aside[1]/div/nav/ul/li[15]/a"));
		return element;
	}
	
    public static WebElement Create_New_Button (WebDriver driver){
		
		element = driver.findElement(By.id("createAction"));
		return element;
	}
	
    // Create New Custom Action Form Starts here
    
    public static WebElement identifier (WebDriver driver){
    	
    	element = driver.findElement(By.id("action_name"));
    	return element;
    }
    
    public static WebElement name (WebDriver driver){
    	
    	element = driver.findElement(By.id("action_label"));
    	return element;
    	
    }
    
    public static WebElement action_description (WebDriver driver){
    	
    	element = driver.findElement(By.id("action_description"));
    	return element;
    }
    
    public static WebElement asset_category (WebDriver driver){
    	element = driver.findElement(By.id("action_category"));
    	return element;
    	
    }
    
    // Use Below Elememts from Asset_Category drop-down list.
    
    public static WebElement Asset_Category_ALL (WebDriver driver){
	   	element = driver.findElement(By.xpath("html/body/div[3]/div/div/form/div[1]/div[3]/div[2]/div/select/option[1]"));
	   	return element;
	   	
	   }
    
    public static WebElement COMPUTE (WebDriver driver){
    	element = driver.findElement(By.xpath("html/body/div[3]/div/div/form/div[1]/div[3]/div[2]/div/select/option[2]"));
    	return element;
    	
    }
    
    public static WebElement NETWORK (WebDriver driver){
    	element = driver.findElement(By.xpath("html/body/div[3]/div/div/form/div[1]/div[3]/div[2]/div/select/option[3]"));
    	return element;
    	
    }
    public static WebElement STORAGE (WebDriver driver){
    	element = driver.findElement(By.xpath("html/body/div[3]/div/div/form/div[1]/div[3]/div[2]/div/select/option[4]"));
    	return element;
    	
    }
    
    //------------------------ Asset Type ----------------
    
   public static WebElement asset_type (WebDriver driver){
    	
    	element = driver.findElement(By.id("action_type"));
    	return element;
    }
    
  // Use Below Element from Asset_Type Drop-down
   
   public static WebElement Action_Type_ALL (WebDriver driver){
	   	element = driver.findElement(By.xpath("html/body/div[3]/div/div/form/div[1]/div[4]/div[1]/div/select/option[1]"));
	   	return element;
	   	
	   }

  public static WebElement VIRTUAL_MACHINE (WebDriver driver){
   	element = driver.findElement(By.xpath("html/body/div[3]/div/div/form/div[1]/div[4]/div[1]/div/select/option[2]"));
   	return element;
   	
   }
  
 /* public static WebElement SWITCH (WebDriver driver){
	   	element = driver.findElement(By.xpath("html/body/div[3]/div/div/form/div[1]/div[4]/div[1]/div/select/option[2]"));
	   	return element;
	   	
	   }
  
  public static WebElement ROUTER (WebDriver driver){
	   	element = driver.findElement(By.xpath("html/body/div[3]/div/div/form/div[1]/div[4]/div[1]/div/select/option[3]"));
	   	return element;
	   	
	   }
  
  public static WebElement WIRELESS (WebDriver driver){
	   	element = driver.findElement(By.xpath("html/body/div[3]/div/div/form/div[1]/div[4]/div[1]/div/select/option[4]"));
	   	return element;
	   	
	   }*/
   
    
    public static WebElement asset_subtype (WebDriver driver){
    	
    	element = driver.findElement(By.id("action_subType"));
    	return element;
    }
    
    public static WebElement flintbit_name (WebDriver driver){
    
    	
    	element = driver.findElement(By.id("flintbit_name"));
    	return element;
    }
    
     public static WebElement submit_Button (WebDriver driver){
    
    	
    	element = driver.findElement(By.id("submit_action"));
    	return element;
    }
  
  
}
