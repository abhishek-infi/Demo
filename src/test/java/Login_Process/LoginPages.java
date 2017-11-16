package Login_Process;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Demo.Start;

public class LoginPages extends Start {

	WebDriver driver;

	By username = By.id("username");
	By password = By.id("password");
	By Submit_Button = By.id("submit");

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
