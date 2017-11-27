package module;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page_object.Login_Page;
import page_object.Add_Provider_Page;

import com.aventstack.extentreports.Status;

public class Add_Provider extends Start {

	@Test
	public void Provider() throws Exception {

		test = extent.createTest("Provider");

		// Login To Portal

		test.log(Status.INFO, "Let's Login to Portal");
		new Login_Page(driver).usernameAs("admin").passwordAs("admin123")
				.submit();

		// Click on Menu
		new Add_Provider_Page(driver).Menu();

		// Click on 'Administration' From Menu
		new Add_Provider_Page(driver).Administration();

		// Click on 'Provider' Option
		new Add_Provider_Page(driver).Provider();

		// Click on 'Create New' button on Provider page
		new Add_Provider_Page(driver).Create_New();

		// Select The type of provider you want (VMware)
		new Add_Provider_Page(driver).Type();

		// Enter The Name of Provider
		new Add_Provider_Page(driver).ProvidernameAs("vmware456");

		// Enter Description
		new Add_Provider_Page(driver).DescriptionAs("testing");

		// Enter HostName
		new Add_Provider_Page(driver).hostnameAs("vmware55.infiverve.com:5443");

		// Provider Username
		new Add_Provider_Page(driver).usernameAs("root");

		// Enter Password
		new Add_Provider_Page(driver).PasswordAs("vmware");

		// Verify Credentials button
		new Add_Provider_Page(driver).Verify_cred();

		// Click on Register button
		new Add_Provider_Page(driver).Register_button();

		test.log(Status.INFO, "Provider Added Successfully");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		// Here will compare if test is failing then only it will enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {

				test.log(Status.ERROR,
						"Test Case Failed, Please check the attachedd screenshot");
				String screenShotPath = Utility.captureScreenshot(driver,
						"screenshotName");
				test.fail("Snapshot below: "
						+ test.addScreenCaptureFromPath(screenShotPath));

			} catch (Exception e) {
				System.out.println("Exception while taking screenshot"
						+ e.getMessage());
			}
		}

	}
}