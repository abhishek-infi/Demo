package Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Credential_Pages;

public class Credentials extends start {

	@Test(description = "SignIn")
	public void signin() throws Exception {

		// To Locate the Username field
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("admin");

		// To locate the Password field
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("password")).sendKeys("admin123");

		// Click on Login button
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("submit")).click();
	}

	@Test(dependsOnMethods = { "signin" })
	public void cred() throws Exception {

		new Credential_Pages(driver).menu();

		new Credential_Pages(driver).administration();

		new Credential_Pages(driver).credential();

		new Credential_Pages(driver).create_new();

		new Credential_Pages(driver).type();

		new Credential_Pages(driver).nameAs("Credential");

		new Credential_Pages(driver).DescriptionAs("Creaet Credential");

		new Credential_Pages(driver).usernameAs("Admin");

		new Credential_Pages(driver).PasswordAs("Admin123");

		new Credential_Pages(driver).Submit();

	}

	@BeforeTest
	public void beforeTest() {

		System.out.println("Let's Create Credential");

	}

	@AfterTest
	public void afterTest() {

		// driver.quit();
	}

}
