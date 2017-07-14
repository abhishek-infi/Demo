package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Demo.start;

public class add_provider extends start {
	
	 private static WebElement element = null;
	 
	 public static WebElement Provider(WebDriver driver){
		 
		 element = driver.findElement(By.xpath("html/body/div[1]/aside[1]/div/nav/ul/li[5]/a"));
		 return element;
		 
		 
	 }

 public static WebElement Create_New(WebDriver driver){
		 
		 element = driver.findElement(By.id("createProvider"));
		 return element;
		 
		 
	 }

public static WebElement VMware (WebDriver driver){
		 
		 element = driver.findElement(By.xpath(".//*[@id='createProvider']/div/div/div/div/div[2]/div[3]/div/div/div[2]/div/p/a"));
		 return element;
		 
		 
	 }

 public static WebElement Provider_name (WebDriver driver){
	 
	 element = driver.findElement(By.id("vmware_provider_name"));
	 return element;
	 
	 
    }
 
public static WebElement vmware_provider_description (WebDriver driver){
	 
	 element = driver.findElement(By.id("vmware_provider_description"));
	 return element;
	 
	 
    }
public static WebElement vmware_provider_hostname (WebDriver driver){
	 
	 element = driver.findElement(By.id("vmware_provider_hostname"));
	 return element;
	 
	 
   }

public static WebElement vmware_provider_username (WebDriver driver){
	 
	 element = driver.findElement(By.id("vmware_provider_username"));
	 return element;
	 
	 
  }

public static WebElement provider_password (WebDriver driver){
	 
	 element = driver.findElement(By.id("provider_password"));
	 return element;
	 
	 
 }

public static WebElement Register_button (WebDriver driver){
	 
	 element = driver.findElement(By.xpath(".//*[@id='vmwareForm']/div[4]/div[2]/button[1]"));
	 return element;
	 
	 
}

	 
}
