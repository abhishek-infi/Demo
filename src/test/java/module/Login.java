package module;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page_object.Login_Page;

public class Login extends Start {

	@Test
	public void signin() throws Exception {
		test = extent.createTest("Login");
		new Login_Page(driver).usernameAs("admin").passwordAs("admin123")
				.submit();

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
