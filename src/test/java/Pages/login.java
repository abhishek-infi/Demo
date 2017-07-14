package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Demo.start;

public class login extends start {
	
	 private static WebElement element = null;
	 
public static WebElement Username (WebDriver driver){
		 
		 element = driver.findElement(By.id("username"));
		 return element;
		 
		 
	 }
	
public static WebElement Password (WebDriver driver){
	 
	 element = driver.findElement(By.id("password"));
	 return element;
	 
	 
}

public static WebElement Submit_button (WebDriver driver){
	 
	 element = driver.findElement(By.id("submit"));
	 return element;
	 
	 
}

}
