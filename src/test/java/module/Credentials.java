package module;

import java.io.IOException;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page_object.Credential_Pages;
import page_object.LoginPages;

public class Credentials extends Start {

	@Test
	public void cred() throws Exception {

		test = extent.createTest("cred");

		// Enter the Usernmae and Password on Login Page
		new LoginPages(driver).usernameAs("admin").passwordAs("admin123")
				.submit();
		// Click on Menu icon
		new Credential_Pages(driver).menu();
		// Click on 'Administration' module from Menu
		new Credential_Pages(driver).administration();
		// Click on 'Credentials' option
		new Credential_Pages(driver).credential();
		// Clickk on 'Create New' button
		new Credential_Pages(driver).create_new();
		// Select Type of Credentials
		new Credential_Pages(driver).type();
		// Click on 'Username & Password' option
		new Credential_Pages(driver).nameAs("Credential");
		// Enter Description
		new Credential_Pages(driver).DescriptionAs("Creaet Credential");
		// Enter Username
		new Credential_Pages(driver).usernameAs("Admin");
		// Enter Password
		new Credential_Pages(driver).PasswordAs("Admin123");
		// Click on Submit button
		new Credential_Pages(driver).Submit();

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		// Here will compare if test is failing then only it will enter into if
		// condition
		if (result.getStatus() == ITestResult.FAILURE) {

			String screenShotPath = Utility.captureScreenshot(driver,
					"screenshotName");
			test.fail("Snapshot below: "
					+ test.addScreenCaptureFromPath(screenShotPath));

		}

	}
}
