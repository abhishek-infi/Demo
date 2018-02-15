package page_object;

import junit.framework.Assert;
import module.Start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class AddProviderPage extends Start {

	By Menu = By.xpath(".//*[@id='step1']/a/em");
	By Administration = By.xpath(".//*[@id='step2']/span[2]/span/strong");
	By Provider = By.xpath(".//*[@id='step3']/span");
	By Create_new = By.id("createProvider");
	By Type = By
			.xpath(".//*[@id='createProvider']/div/div/div/div/div[2]/div[3]/div/div/div[2]/div");
	By Provider_name = By.id("vmware_provider_name");
	By Description = By.id("vmware_provider_description");
	By hostname = By.id("vmware_provider_hostname");
	By Username = By.id("vmware_provider_username");
	By Password = By.name("vmware_provider_password");
	By Verify_cred = By.xpath(".//*[@id='vmwareForm']/div[4]/div[1]/button");
	By Register_button = By
			.xpath(".//*[@id='vmwareForm']/div[4]/div[2]/button[1]");

	public AddProviderPage(WebDriver driver) throws InterruptedException {

		Start.driver = driver;
	}

	public void Menu() {
		driver.findElement(Menu).click();

	}

	public void Administration() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Administration).click();
	}

	public void Provider() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Provider).click();

		// Verify Whether the Page Navigates to 'Platform Config' Page after
		// clicking on 'Administration' For this Assert is added on Save button.
		WebElement Save = driver.findElement(By.id("createProvider"));
		Assert.assertEquals(true, Save.isDisplayed());
		test.log(Status.INFO,
				"Verified The Page, You are in 'Administration' Module.");

	}

	public void Create_New() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Create_new).click();

	}

	public void Type() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Type).click();

	}

	public AddProviderPage ProvidernameAs(String pname)
			throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Provider_name).sendKeys(pname);
		return this;
	}

	public AddProviderPage DescriptionAs(String desc)
			throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Description).sendKeys(desc);
		return this;
	}

	public AddProviderPage hostnameAs(String host) throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(hostname).sendKeys(host);
		return this;
	}

	public AddProviderPage usernameAs(String username)
			throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Username).sendKeys(username);
		return this;
	}

	public AddProviderPage PasswordAs(String pass) throws InterruptedException {

		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(Password));
		element.sendKeys(pass);
		return this;
	}

	public void Verify_cred() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(Verify_cred).click();

	}

	// Wait added to find element until its present on page
	public void Register_button() throws InterruptedException {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions
				.elementToBeClickable(Register_button));
		// driver.findElement(Register_button).click();
		element.click();

	}

}
