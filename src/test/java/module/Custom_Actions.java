package module;

import java.io.IOException;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page_object.Custom_Actions_Page;
import page_object.Login_Page;

public class Custom_Actions extends Start {

	@Test
	public void create_custom_action() throws InterruptedException {

		test = extent.createTest("create_custom_action");
		// Login To Portal
		new Login_Page(driver).usernameAs("admin").passwordAs("admin123")
				.submit();
		// Click on Menu
		new Custom_Actions_Page(driver).submit();
		// Click on 'Administration' option
		new Custom_Actions_Page(driver).admin();
		// Click on 'Custom Actions' option
		new Custom_Actions_Page(driver).custom_ac();
		// Click on 'Create New' button
		new Custom_Actions_Page(driver).createnew();
		// Enter Action Name
		new Custom_Actions_Page(driver).nameAs("fortesting").descriptionAs(
				"description");
		// Select Category
		new Custom_Actions_Page(driver).category();
		// Select Asset Sub Type
		new Custom_Actions_Page(driver).assetsubtype();
		// Select Asset Type
		new Custom_Actions_Page(driver).assettype();
		// Enter Flintbit
		new Custom_Actions_Page(driver).flintnameAs("hello:example.rb");
		// Click on 'Submit' button
		new Custom_Actions_Page(driver).submit_butto();
		// Click on 'Save' button
		new Custom_Actions_Page(driver).Save_Button();

	}

	/*
	 * The menthod teardown will execute after each method present in class. The
	 * method contains the Screenshot capture logic if test case get Failed.
	 */

	@AfterMethod()
	public void tearDown(ITestResult result) throws IOException {

		// Here will compare if test is failing then only it will enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {

			String screenShotPath = Utility.captureScreenshot(driver,
					"screenshotName");
			test.fail("Snapshot below: "
					+ test.addScreenCaptureFromPath(screenShotPath));
		}

	}
}
