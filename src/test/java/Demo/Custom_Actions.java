package Demo;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Login_Process.LoginPages;
import Pages.Custom_actions_page;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Custom_Actions extends Start {

	ExtentReports report;
	ExtentTest logger;
	String driverPath = "D:\\geckodriver-v0.16.1-win64\\geckodriver.exe";

	@Test
	public void create_custom_action() throws InterruptedException {
		report = new ExtentReports("D:/Reports/Report.html");

		logger = report.startTest("Create Custom Action");

		// Login To Portal
		new LoginPages(driver).usernameAs("admin").passwordAs("admin123")
				.submit();

		new Custom_actions_page(driver).submit();

		new Custom_actions_page(driver).admin();

		new Custom_actions_page(driver).custom_ac();

		new Custom_actions_page(driver).createnew();

		new Custom_actions_page(driver).nameAs("fortesting").descriptionAs(
				"description");

		new Custom_actions_page(driver).category();

		new Custom_actions_page(driver).assetsubtype();

		new Custom_actions_page(driver).assettype();

		new Custom_actions_page(driver).flintnameAs("hello:example.rb");

		new Custom_actions_page(driver).submit_butto();

		new Custom_actions_page(driver).Save_Button();

		logger.log(LogStatus.PASS, "Custom Action Created Successfully");
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
