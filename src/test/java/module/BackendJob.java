package module;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.naming.ldap.ExtendedRequest;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page_object.BackendJobPage;
import page_object.LoginPage;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.Status;

public class BackendJob extends Start {

	ExtentReporter report;
	ExtendedRequest logger;

	@Test
	public void job() throws InterruptedException, IOException {

		test = extent.createTest("job");

		// Property file object
		Properties obj = new Properties();

		FileInputStream objFile = new FileInputStream(
				System.getProperty("user.dir") + "/DataFile.Properties/");

		obj.load(objFile);

		test.log(Status.INFO, "Let's Login to Portal");
		// Login to Portal
		new LoginPage(driver).usernameAs(obj.getProperty("username"))
				.passwordAs(obj.getProperty("password")).submit();

		test.log(Status.INFO, "Login Successfull");

		// Click on Menu
		new BackendJobPage(driver).Menu();

		// Click on Asministration Module
		new BackendJobPage(driver).Administration();

		// Click on "Backend Jobs" option.
		new BackendJobPage(driver).Backendjob();

		// Click on 'Create New' button.
		new BackendJobPage(driver).CreateNew();

		// Enter Name for Job
		new BackendJobPage(driver).nameAs("Testing");

		// Enter Description of Job
		new BackendJobPage(driver).descriptionAs("New Backend Job");

		// Enter Cron Expression
		new BackendJobPage(driver).cronAs("0 0/1 * 1/1 * ? *");

		// Select TimeZone
		new BackendJobPage(driver).timezon();

		// Enter Flintbit
		new BackendJobPage(driver).triggerAs("hello:example.rb");

		// new Backend_Job_Pages(driver).jsonAs("");
		// Click on Submit button
		new BackendJobPage(driver).Submit();
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