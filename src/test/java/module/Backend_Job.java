package module;

import java.io.IOException;

import javax.naming.ldap.ExtendedRequest;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page_object.Backend_Job_Page;
import page_object.Login_Page;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.Status;

public class Backend_Job extends Start {

	ExtentReporter report;
	ExtendedRequest logger;

	@Test
	public void job() throws InterruptedException {

		test = extent.createTest("job");

		test.log(Status.INFO, "Let's Login to Portal");
		// Login to Portal
		new Login_Page(driver).usernameAs("admin").passwordAs("admin123")
				.submit();

		test.log(Status.INFO, "Login Successfull");

		// Click on Menu
		new Backend_Job_Page(driver).Menu();
		// Click on Asministration Module
		new Backend_Job_Page(driver).Administration();
		// Click on "Backend Jobs" option.
		new Backend_Job_Page(driver).Backendjob();
		// Click on 'Create New' button.
		new Backend_Job_Page(driver).CreateNew();
		// Enter Name for Job
		new Backend_Job_Page(driver).nameAs("Testing");
		// Enter Description of Job
		new Backend_Job_Page(driver).descriptionAs("New Backend Job");
		// Enter Cron Expression
		new Backend_Job_Page(driver).cronAs("0 0/1 * 1/1 * ? *");
		// Select TimeZone
		new Backend_Job_Page(driver).timezon();
		// Enter Flintbit
		new Backend_Job_Page(driver).triggerAs("hello:example.rb");

		// new Backend_Job_Pages(driver).jsonAs("");
		// Click on Submit button
		new Backend_Job_Page(driver).Submit();
		// If Backend Job Created Successfully then Print the message

		test.log(Status.INFO, "Backend Job Created Successfully");

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

			test.log(Status.FAIL,
					"Test Case Failed, Please check the screenshot");
			String screenShotPath = Utility.captureScreenshot(driver,
					"screenshotName");
			test.fail("Snapshot below: "
					+ test.addScreenCaptureFromPath(screenShotPath));
		}

	}
}