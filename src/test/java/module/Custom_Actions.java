package module;

import java.io.IOException;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page_object.Custom_actions_page;
import page_object.LoginPages;

public class Custom_Actions extends Start {

	@Test
	public void create_custom_action() throws InterruptedException {

		test = extent.createTest("create_custom_action");
		// Login To Portal
		new LoginPages(driver).usernameAs("admin").passwordAs("admin123")
				.submit();
		// Click on Menu
		new Custom_actions_page(driver).submit();
		// Click on 'Administration' option
		new Custom_actions_page(driver).admin();
		// Click on 'Custom Actions' option
		new Custom_actions_page(driver).custom_ac();
		// Click on 'Create New' button
		new Custom_actions_page(driver).createnew();
		// Enter Action Name
		new Custom_actions_page(driver).nameAs("fortesting").descriptionAs(
				"description");
		// Select Category
		new Custom_actions_page(driver).category();
		// Select Asset Sub Type
		new Custom_actions_page(driver).assetsubtype();
		// Select Asset Type
		new Custom_actions_page(driver).assettype();
		// Enter Flintbit
		new Custom_actions_page(driver).flintnameAs("hello:example.rb");
		// Click on 'Submit' button
		new Custom_actions_page(driver).submit_butto();
		// Click on 'Save' button
		new Custom_actions_page(driver).Save_Button();

	}

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
