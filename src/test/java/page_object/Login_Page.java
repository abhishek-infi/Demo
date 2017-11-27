package page_object;

import module.Start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Page extends Start {

	WebDriver driver;

	By username = By.id("username");
	By password = By.id("password");
	By Submit_Button = By.id("submi");

	public Login_Page(WebDriver driver) {
		this.driver = driver;
	}

	public Login_Page usernameAs(String uname) {
		driver.findElement(username).sendKeys(uname);
		return this;
	}

	public Login_Page passwordAs(String pass) {
		driver.findElement(password).sendKeys(pass);
		return this;
	}

	public void submit() {
		driver.findElement(Submit_Button).click();
	}

}
