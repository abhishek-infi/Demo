package page_object;

import module.Start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPages extends Start {

	WebDriver driver;

	By username = By.id("username");
	By password = By.id("password");
	By Submit_Button = By.id("submi");

	public LoginPages(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPages usernameAs(String uname) {
		driver.findElement(username).sendKeys(uname);
		return this;
	}

	public LoginPages passwordAs(String pass) {
		driver.findElement(password).sendKeys(pass);
		return this;
	}

	public void submit() {
		driver.findElement(Submit_Button).click();
	}

}
