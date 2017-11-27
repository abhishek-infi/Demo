package module;

import java.io.IOException;

import javax.naming.ldap.ExtendedRequest;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page_object.Backend_Job_Pages;
import page_object.LoginPages;

import com.aventstack.extentreports.ExtentReporter;

public class Backend_Job extends Start {

	ExtentReporter report;
	ExtendedRequest logger;

	@Test
	public void job() throws InterruptedException {

		test = extent.createTest("job");

		// Login to Portal
		new LoginPages(driver).usernameAs("admin").passwordAs("admin123")
				.submit();

		// Click on Menu
		new Backend_Job_Pages(driver).Menu();
		// Click on Asministration Module
		new Backend_Job_Pages(driver).Administration();
		// Click on "Backend Jobs" option.
		new Backend_Job_Pages(driver).Backendjob();
		// Click on 'Create New' button.
		new Backend_Job_Pages(driver).CreateNew();
		// Enter Name for Job
		new Backend_Job_Pages(driver).nameAs("Testing");
		// Enter Description of Job
		new Backend_Job_Pages(driver).descriptionAs("New Backend Job");
		// Enter Cron Expression
		new Backend_Job_Pages(driver).cronAs("0 0/1 * 1/1 * ? *");
		// Select TimeZone
		new Backend_Job_Pages(driver).timezon();
		// Enter Flintbit
		new Backend_Job_Pages(driver).triggerAs("hello:example.rb");

		// new Backend_Job_Pages(driver).jsonAs("");
		// Click on Submit button
		new Backend_Job_Pages(driver).Submit();
		// If Backend Job Created Successfully then Print the message

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