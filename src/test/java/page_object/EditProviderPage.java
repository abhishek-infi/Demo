package page_object;

import library.IsPresent;
import module.Start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProviderPage extends Start {
	// All Identifiers
	By Menu = By.xpath(".//*[@id='step1']/a/em");
	By Administration = By.xpath(".//*[@id='step2']/span[2]/span/strong");
	By Provider = By.xpath(".//*[@id='step3']/span");
	By ActionTab = By.id("actionTabProvider");
	By Username = By.id("vmware_provider_username");
	By Password = By.id("vmware_provider_password");
	By Update = By
			.xpath("/html/body/div[3]/div/div/div[2]/div/div/form/div[4]/div/div/div[2]/button");
	By Description = By.id("vmware_provider_description");

	public EditProviderPage(WebDriver driver) throws InterruptedException {

		Start.driver = driver;
	}

	// Click on Menu.
	public void Menu() {
		driver.findElement(Menu).click();

	}

	// Click on 'Administration' option.
	public void Administration() {

		driver.findElement(Administration).click();
	}

	// Click on 'Provider' option
	public void Provider() throws InterruptedException {

		driver.findElement(Provider).click();

	}

	// Select Edit Option from 'Dropdown' list.
	public void ActionTab() throws InterruptedException {

		// Verify the Title of Page
		new IsPresent().IsElementPresent(driver, By.id("dynamicPageTitle"));

		driver.findElement(ActionTab).click();
	}

	// Enter a Username
	public void Username(String username) {
		driver.findElement(Username).sendKeys(username);
	}

	// Enter a Password
	public void Password(String password) {
		driver.findElement(Password).sendKeys(password);
	}

	public void Description(String description) {

		driver.findElement(Description).sendKeys(description);

	}

	public void Update() {
		driver.findElement(Update).click();
	}

}