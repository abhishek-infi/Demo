package module;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.text.TextProducer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page_object.CustomActionsPage;
import page_object.LoginPage;

import com.aventstack.extentreports.Status;

public class CustomActions extends Start {

	@Test
	public void create_custom_action() throws InterruptedException, IOException {

		test = extent.createTest("create_custom_action");

		// Object of jFairy
		Fairy fairy = Fairy.create();

		TextProducer textProducer = fairy.textProducer();

		// Property file object
		Properties obj = new Properties();

		FileInputStream objFile = new FileInputStream(
				System.getProperty("user.dir") + "/DataFile.Properties/");
		obj.load(objFile);

		// Login To Portal
		test.log(Status.INFO, "Lets Login to FLint Portal");
		new LoginPage(driver).usernameAs(obj.getProperty("username"))
				.passwordAs(obj.getProperty("password")).submit();

		// Click on Menu
		new CustomActionsPage(driver).submit();

		// Click on 'Administration' option
		new CustomActionsPage(driver).admin();

		// Click on 'Custom Actions' option
		new CustomActionsPage(driver).custom_ac();

		// Click on 'Create New' button
		new CustomActionsPage(driver).createnew();

		// Enter Action Name
		new CustomActionsPage(driver).nameAs(textProducer.randomString(10))
				.descriptionAs(textProducer.randomString(10));

		// Select Category
		new CustomActionsPage(driver).category();

		// Select Asset Sub Type
		new CustomActionsPage(driver).assetsubtype();

		// Select Asset Type
		new CustomActionsPage(driver).assettype();

		// Enter Flintbit
		new CustomActionsPage(driver).flintnameAs(obj.getProperty("flintbit"));

		// Click on 'Submit' button
		new CustomActionsPage(driver).submit_butto();

		// Click on 'Save' button
		new CustomActionsPage(driver).Save_Button();

	}

	/*
	 * The method tearDown will execute after each method present in class. The
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
