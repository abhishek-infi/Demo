package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Demo.Start;

public class Backend_Job_Pages extends Start {

	By Menu = By.xpath(".//*[@id='step1']/a/em");
	By Administration = By.xpath(".//*[@id='step2']/span[2]/span/strong");
	By Backendjob = By.xpath(".//*[@id='navigationbar']/li[22]/a/span");
	By CreateNew = By.xpath(".//*[@id='createScheduler1']");
	By Name = By.id("name");
	By Description = By.id("description");
	By Cron = By.id("cronExpression");
	By Timezon = By.xpath(".//*[@id='timezone']/option[1]");
	By Trigger = By.id("trigger");
	/*
	 * By JSON = By
	 * .xpath(".//*[@id='createandupdatemodal']/div/div/div[2]/form/div[1]/div[4]"
	 * );
	 */
	By Submit = By.id("submitButtonOfSchedules");

	public Backend_Job_Pages(WebDriver driver) throws InterruptedException {

		Start.driver = driver;

	}

	public void Menu() {
		driver.findElement(Menu).click();
	}

	public void Administration() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Administration).click();
	}

	public void Backendjob() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Backendjob).click();
	}

	public void CreateNew() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(CreateNew).click();
	}

	public Backend_Job_Pages nameAs(String name) throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Name).sendKeys(name);
		return this;
	}

	public Backend_Job_Pages descriptionAs(String descrip)
			throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Description).sendKeys(descrip);
		return this;
	}

	public Backend_Job_Pages cronAs(String cron) throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Cron).sendKeys(cron);
		return this;
	}

	public void timezon() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Timezon).click();
	}

	public Backend_Job_Pages triggerAs(String trigger)
			throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(Trigger).sendKeys(trigger);
		return this;
	}

	/*
	 * public Backend_Job_Pages jsonAs(String Json) throws InterruptedException
	 * { Thread.sleep(500); driver.findElement(JSON).sendKeys(Json); return
	 * this; }
	 */
	public void Submit() {
		driver.findElement(Submit).click();
	}

}
