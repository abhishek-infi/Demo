package module;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page_object.LoginPages;
import page_object.add_provider_page;

public class Add_Provider extends Start {

	@Test
	public void Provider() throws Exception {

		test = extent.createTest("Provider");

		// Login To Portal
		new LoginPages(driver).usernameAs("admin").passwordAs("admin123")
				.submit();

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

		// Enter HostName
		new add_provider_page(driver).hostnameAs("vmware55.infiverve.com:5443");

		// Provider Username
		new add_provider_page(driver).usernameAs("root");

		// Enter Password
		new add_provider_page(driver).PasswordAs("vmware");

		// Verify Credentials button
		new add_provider_page(driver).Verify_cred();

		// Click on Register button
		new add_provider_page(driver).Register_button();

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		// Here will compare if test is failing then only it will enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {

				String screenShotPath = Utility.captureScreenshot(driver,
						"screenshotName");
				test.fail("Snapshot below: "
						+ test.addScreenCaptureFromPath(screenShotPath));

			} catch (Exception e) {
				System.out.println("Exception while taking screenshot "
						+ e.getMessage());
			}
		}

	}
}