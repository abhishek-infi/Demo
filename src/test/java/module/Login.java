package module;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import page_object.LoginPage;

public class Login {
	public static WebDriver driver;

	@Test()
	public void signin() throws Exception {

		System.setProperty("webdriver.gecko.driver",
				"D:\\geckodriver-v0.16.1-win64");
		System.setProperty("webdriver.chrome.driver",
				"D:\\Abhishek K\\CromeDriver\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");

		WebDriver driver = new ChromeDriver(options);
		driver.get("http://opshub.flintcloud.info");

		/*
		 * driver = new ChromeDriver();
		 * driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 * driver.manage().window().maximize();
		 * driver.get("http://opshub.flintcloud.info");
		 */

		// Extent Report object
		// test = extent.createTest("Login");

		// Property file object

		Properties obj = new Properties();

		FileInputStream objFile = new FileInputStream(
				System.getProperty("user.dir") + "/DataFile.Properties/");

		obj.load(objFile);

		try {

			new LoginPage(driver).usernameAs(obj.getProperty("username"))
					.passwordAs(obj.getProperty("password")).submit();

			if (driver.getTitle().contains("Flint by Infiverve Technologies"))
				// Pass
				System.out
						.println("Page title contains \"Flint by Infiverve Technologies\" ");
			else
				// Fail
				System.out
						.println("Page title doesn't contains \"Flint by Infiverve Technologies\" ");

		}

		catch (RuntimeException e) {

			System.out.println(e.getStackTrace());

		}

	}

	/*
	 * @AfterMethod public void tearDown(ITestResult result) {
	 * 
	 * // Here will compare if test is failing then only it will enter into if
	 * // condition if (ITestResult.FAILURE == result.getStatus()) { try {
	 * 
	 * String screenShotPath = Utility.captureScreenshot(driver,
	 * "screenshotName"); test.fail("Snapshot below: " +
	 * test.addScreenCaptureFromPath(screenShotPath));
	 * 
	 * } catch (Exception e) {
	 * System.out.println("Exception while taking screenshot " +
	 * e.getMessage());
	 * 
	 * } }
	 * 
	 * }
	 */

}
