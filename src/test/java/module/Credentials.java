package module;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page_object.CredentialPage;
import page_object.LoginPage;

import com.aventstack.extentreports.Status;

public class Credentials extends Start {

	@Test
	public void cred() throws Exception {

		test = extent.createTest("cred");

		test.log(Status.INFO, "Let's Login to Portal");

		// Property file object
		Properties obj = new Properties();

		FileInputStream objFile = new FileInputStream(
				System.getProperty("user.dir") + "/DataFile.Properties/");

		obj.load(objFile);

		// Enter the Usernmae and Password on Login Page
		new LoginPage(driver).usernameAs(obj.getProperty("username"))
				.passwordAs("password").submit();

		test.log(Status.INFO, "Login Successfull");

		// Click on Menu icon
		new CredentialPage(driver).menu();

		// Click on 'Administration' module from Menu
		new CredentialPage(driver).administration();

		// Click on 'Credentials' option
		new CredentialPage(driver).credential();

		// Clickk on 'Create New' button
		new CredentialPage(driver).create_new();

		// Select Type of Credentials
		new CredentialPage(driver).type();

		// Click on 'Username & Password' option
		new CredentialPage(driver).nameAs("Credential");

		// Enter Description
		new CredentialPage(driver).DescriptionAs("Creaet Credential");

		// Enter Username
		new CredentialPage(driver).usernameAs("Admin");

		// Enter Password
		new CredentialPage(driver).PasswordAs("Admin123");

		// Click on Submit button
		new CredentialPage(driver).Submit();

		test.log(Status.PASS, "Test Case Executed Successfully");

	}

	/*
	 * The menthod teardown will execute after each method present in class. The
	 * method contains the Screenshot capture logic if test case get Failed.
	 */

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		// Here will compare if test is failing then only it will enter into if
		// condition
		if (result.getStatus() == ITestResult.FAILURE) {

			test.log(Status.FAIL,
					"Test Case Failed, Please check the screenshot");
			String screenShotPath = Utility.captureScreenshot(driver,
					"screenshotName");
			test.fail("Snapshot below: "
					+ test.addScreenCaptureFromPath(screenShotPath));

		}

	}
}
