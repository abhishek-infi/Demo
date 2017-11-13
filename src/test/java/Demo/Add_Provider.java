package Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.add_provider_page;

public class Add_Provider extends start {

	@BeforeClass
	public void starting() {

		System.out.println("Lets Begun!!");

	}

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
	public void Provider() throws Exception {

		// Click on Menu
		new add_provider_page(driver).Menu();

		// Click on Administration From Menu
		new add_provider_page(driver).Administration();

		// Click on 'Provider' Option
		new add_provider_page(driver).Provider();

		// Click on 'Create New' button on Provider page
		new add_provider_page(driver).Create_New();

		// Select The type of provider you want (VMware)
		new add_provider_page(driver).Type();

		// Enter The Name of Provider
		new add_provider_page(driver).ProvidernameAs("vmware456");

		// Enter Description
		new add_provider_page(driver).DescriptionAs("testing");

		// HostName
		new add_provider_page(driver).hostnameAs("vmware55.infiverve.com:5443");

		// Provider Username
		new add_provider_page(driver).usernameAs("root");

		// Password
		new add_provider_page(driver).PasswordAs("vmware");

		// Verify Credentials button
		new add_provider_page(driver).Verify_cred();

		// Click on Register button
		new add_provider_page(driver).Register_button();

	}

	public static void main() throws Exception {
		Add_Provider AP = new Add_Provider();
		AP.setupApplication();
		AP.signin();
		AP.Provider();

	}

	@AfterClass
	public void ending() {

		// driver.quit();

	}

}