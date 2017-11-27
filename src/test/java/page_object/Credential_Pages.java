package page_object;

import module.Start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Credential_Pages extends Start {

	By Menu = By.xpath(".//*[@id='step1']/a/em");
	By Administration = By.xpath(".//*[@id='step2']/span[2]/span/strong");
	By Credentials = By.xpath(".//*[@id='navigationbar']/li[3]/a/span");
	By Create_New = By.id("createCredentialsButton");
	By Type = By.id("createusernamepassword");
	By Name = By.id("up_name");
	By Description = By.id("up_description");
	By Username = By.id("userName");
	By Password = By.name("password");
	By Submit_Button = By
			.xpath(".//*[@id='usernameandpasswordform']/div[2]/button[1]");

	public Credential_Pages(WebDriver driver) throws InterruptedException {

		Start.driver = driver;

	}

	public void menu() {

		driver.findElement(Menu).click();
	}

	public void administration() throws InterruptedException {

		Thread.sleep(500);
		driver.findElement(Administration).click();

	}

	public void credential() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Credentials).click();
	}

	public void create_new() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Create_New).click();
	}

	public void type() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Type).click();
	}

	public Credential_Pages nameAs(String name) throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Name).sendKeys(name);
		return this;
	}

	public Credential_Pages DescriptionAs(String description)
			throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Description).sendKeys(description);
		return this;
	}

	public Credential_Pages usernameAs(String username)
			throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Username).sendKeys(username);
		return this;
	}

	public Credential_Pages PasswordAs(String password)
			throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Password).sendKeys(password);
		return this;
	}

	public void Submit() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Submit_Button).click();
	}

}
