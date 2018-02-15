package library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class IsPresent {

	public boolean IsElementPresent(WebDriver driver, By locator) {
		// Set the timeout to something low
		try {
			driver.findElement(locator);
			// If element is found set the timeout back and return true
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			System.out.println("Element Found You are on right page");
			return true;
		} catch (NoSuchElementException e) {
			// If element isn't found, set the timeout and return false
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			System.out.println("No Such element Found");
			return false;
		}
	}
}
