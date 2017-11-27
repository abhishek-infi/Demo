package page_object;

import module.Start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Custom_actions_page extends Start {

	WebDriver driver;

	By menu = By.xpath(".//*[@id='step1']/a/em");
	By Administration = By.xpath(".//*[@id='step2']/span[2]/span/strong");
	By Custom_action = By.xpath(".//*[@id='navigationbar']/li[4]/a/span");
	By Create_New = By.id("createAction");
	By name = By.id("action_name");
	By description = By.id("action_description");
	By category = By.xpath(".//*[@id='action_category']/option[4]");
	By assettype = By.xpath(".//*[@id='action_type']/option[2]");
	By assetsubtype = By.xpath(".//*[@id='action_subType']/option[1]");
	By flintname = By.id("flintbit_name");
	By submit_butto = By.id("submit_action");
	By save = By.id("update_action_button");

	public Custom_actions_page(WebDriver driver) {
		this.driver = driver;
	}

	public void submit() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(menu).click();

	}

	public void admin() {
		driver.findElement(Administration).click();

	}

	public void custom_ac() {
		driver.findElement(Custom_action).click();

	}

	public void createnew() {
		driver.findElement(Create_New).click();

	}

	public Custom_actions_page nameAs(String Name) {
		driver.findElement(name).sendKeys(Name);
		return this;
	}

	public Custom_actions_page descriptionAs(String descri) {
		driver.findElement(description).sendKeys(descri);
		return this;
	}

	public void category() {
		driver.findElement(category).click();

	}

	public void assettype() {
		driver.findElement(assettype).click();

	}

	public void assetsubtype() {
		driver.findElement(assetsubtype).click();

	}

	public Custom_actions_page flintnameAs(String Flintname) {
		driver.findElement(flintname).sendKeys(Flintname);
		return this;

	}

	public void submit_butto() throws InterruptedException {

		Thread.sleep(500);
		driver.findElement(submit_butto).click();
	}

	public void Save_Button() {
		driver.findElement(save).click();
	}

}
