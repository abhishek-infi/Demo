package module;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.text.TextProducer;

import java.io.FileInputStream;
import java.util.Properties;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page_object.EditProviderPage;
import page_object.LoginPage;

import com.aventstack.extentreports.Status;

public class EditProvider extends Start {

	@Test(description = "Test Case to Edit Provider")
	public void UpdateProvider() throws Exception {

		test = extent.createTest("Provider");

		// Property file object
		Properties obj = new Properties();
		FileInputStream objFile = new FileInputStream(
				System.getProperty("user.dir") + "/DataFile.Properties/");
		obj.load(objFile);

		// Object Created for the jfairy automated data library.
		Fairy fairy = Fairy.create();
		fairy.person();
		TextProducer textProducer = fairy.textProducer();

		// Login
		test.log(Status.INFO, "Let's Login to Portal");

		new LoginPage(driver).usernameAs(obj.getProperty("username"))
				.passwordAs(obj.getProperty("password")).submit();

		// Click on 'Administration' module

		new EditProviderPage(driver).Menu();

		// Click on "administration' module.
		new EditProviderPage(driver).Administration();

		// Click on 'Providers' option
		new EditProviderPage(driver).Provider();

		// Click on 'Action Tab'
		new EditProviderPage(driver).ActionTab();

		// Enter Username
		new EditProviderPage(driver).Username(obj.getProperty("Username"));

		// Enter Password
		new EditProviderPage(driver).Password(obj.getProperty("Password"));

		// Enter some value in Description filed.
		new EditProviderPage(driver).Description(textProducer.randomString(5));

		// Click on 'Update Button
		new EditProviderPage(driver).Update();

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		// Here will compare if test is failing then only it will enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {

				test.log(Status.ERROR,
						"Test Case Failed, Please check the attachedd screenshot");
				// Take Screenshot
				String screenShotPath = Utility.captureScreenshot(driver,
						"screenshotName");
				// Save Screenshot in Report
				test.fail("Snapshot below: "
						+ test.addScreenCaptureFromPath(screenShotPath));

			} catch (Exception e) {
				System.out.println("Exception while taking screenshot"
						+ e.getMessage());
			}
		}
	}
}