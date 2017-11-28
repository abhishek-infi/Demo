package module;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page_object.Backend_Config_Page;
import page_object.Login_Page;

import com.aventstack.extentreports.Status;

public class Backend_Config extends Start {
	@Test
	public void Backend_Configuration() {

		test = extent.createTest("Backend_Config");

		test.log(Status.INFO, "Let's Login to Portal");
		new Login_Page(driver).usernameAs("admin").passwordAs("admin123")
				.submit();

		new Backend_Config_Page(driver).Menu();

		new Backend_Config_Page(driver).Administration();

		new Backend_Config_Page(driver).Backend_Config();

		new Backend_Config_Page(driver).Create_New();

		new Backend_Config_Page(driver).NameAs("This is Test").DescriptionAs(
				"This is Testting again");

		new Backend_Config_Page(driver).Submit();

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
