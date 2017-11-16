package Demo;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Login_Process.LoginPages;
import Pages.Backend_Job_Pages;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Backend_Job extends Start {

	ExtentReports report;
	ExtentTest logger;

	@Test
	public void job() throws InterruptedException {

		report = new ExtentReports("D:/Reports/Report.html");

		logger = report.startTest("Creaet Backend Job");

		new LoginPages(driver).usernameAs("admin").passwordAs("admin123")
				.submit();

		new Backend_Job_Pages(driver).Menu();

		new Backend_Job_Pages(driver).Administration();

		new Backend_Job_Pages(driver).Backendjob();

		new Backend_Job_Pages(driver).CreateNew();

		new Backend_Job_Pages(driver).nameAs("Testing");

		new Backend_Job_Pages(driver).descriptionAs("New Backend Job");

		new Backend_Job_Pages(driver).cronAs("0 0/1 * 1/1 * ? *");

		new Backend_Job_Pages(driver).timezon();

		new Backend_Job_Pages(driver).triggerAs("hello:example.rb");

		// new Backend_Job_Pages(driver).jsonAs("");

		new Backend_Job_Pages(driver).Submit();

		logger.log(LogStatus.PASS, "Backend Job Created Successfully");

	}

	@AfterMethod()
	public void tearDown(ITestResult result) {

		// Here will compare if test is failing then only it will enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {

			Utility.captureScreenshot(driver, "CustomActionFail.png");
		}

		report.endTest(logger);
		report.flush();

	}
}