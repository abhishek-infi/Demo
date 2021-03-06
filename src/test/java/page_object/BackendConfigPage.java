package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BackendConfigPage {
	WebDriver driver;

	By Menu = By.xpath(".//*[@id='step1']/a/em");
	By Administration = By.xpath(".//*[@id='step2']/span[2]/span/strong");
	By Backend_Config = By.xpath("//*[@id='navigationbar']/li[23]/a");
	By Create_New = By.xpath("/html/body/div[1]/section/div/div[1]/div[2]/a");
	By Name = By.name("configuration_name");
	By Description = By.name("configuration_description");
	By Config = By.xpath("//*[@id='editor-config']");
	By Submit = By.xpath("//*[@id='configuration']/div[4]/div/div/button/b");

	public BackendConfigPage(WebDriver driver) {
		this.driver = driver;
	}

	public BackendConfigPage Menu() {
		driver.findElement(Menu).click();
		return this;

	}

	public BackendConfigPage Administration() {
		driver.findElement(Administration).click();
		return this;

	}

	public BackendConfigPage Backend_Config() {
		driver.findElement(Backend_Config).click();
		return this;

	}

	public BackendConfigPage Create_New() {
		driver.findElement(Create_New).click();
		return this;

	}

	public BackendConfigPage NameAs(String name) {
		driver.findElement(Name).sendKeys(name);
		return this;
	}

	public BackendConfigPage DescriptionAs(String Descr) {
		driver.findElement(Description).sendKeys(Descr);
		return this;
	}

	/*
	 * public Backend_Config_Page JsonAs(String json) {
	 * driver.findElement(Config).sendKeys(json); return this; }
	 */

	public BackendConfigPage Submit() {
		driver.findElement(Submit).click();
		return this;

	}

}
