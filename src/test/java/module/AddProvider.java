package module;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.text.TextProducer;

import java.io.FileInputStream;
import java.util.Properties;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page_object.AddProviderPage;
import page_object.LoginPage;

import com.aventstack.extentreports.Status;

public class AddProvider extends Start {

	@Test(description = "Test Case to Add New Provider")
	public void Provider() throws Exception {

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

		// Click on Menu
		new AddProviderPage(driver).Menu();

		// Click on 'Administration' From Menu
		new AddProviderPage(driver).Administration();

		// Click on 'Provider' Option
		new AddProviderPage(driver).Provider();

		// Click on 'Create New' button on Provider page
		new AddProviderPage(driver).Create_New();

		// Select The type of provider you want (VMware)
		new AddProviderPage(driver).Type();

		// Enter The Name of Provider
		new AddProviderPage(driver).ProvidernameAs(obj
				.getProperty("ProviderName"));

		// Enter Description
		new AddProviderPage(driver).DescriptionAs(textProducer.randomString(5));

		// Enter HostName
		new AddProviderPage(driver).hostnameAs(obj.getProperty("Hostname"));

		// Provider Username
		new AddProviderPage(driver).usernameAs(obj.getProperty("Username"));

		// Enter Password
		new AddProviderPage(driver).PasswordAs(obj.getProperty("Password"));

		// Verify Credentials button
		new AddProviderPage(driver).Verify_cred();

		// Click on Register button
		new AddProviderPage(driver).Register_button();

		test.log(Status.INFO, "Provider Added Successfully");

	}

	/*
	 * The method tearDown will execute after each method present in class. The
	 * method contains the Screenshot capture logic if test case get Failed.
	 */

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

	@AfterClass
	public void close() {

	}
}