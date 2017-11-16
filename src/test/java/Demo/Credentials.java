package Demo;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Login_Process.LoginPages;
import Pages.Credential_Pages;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Credentials extends Start {

	ExtentReports report;
	ExtentTest logger;

	@Test
	public void cred() throws Exception {

		report = new ExtentReports("D:/Reports/Report.html");

		logger = report.startTest("Create Credentials");

		new LoginPages(driver).usernameAs("admin").passwordAs("admin123")
				.submit();

		new Credential_Pages(driver).menu();

		new Credential_Pages(driver).administration();

		new Credential_Pages(driver).credential();

		new Credential_Pages(driver).create_new();

		new Credential_Pages(driver).type();

		new Credential_Pages(driver).nameAs("Credential");

		new Credential_Pages(driver).DescriptionAs("Creaet Credential");

		new Credential_Pages(driver).usernameAs("Admin");

		new Credential_Pages(driver).PasswordAs("Admin123");

		new Credential_Pages(driver).Submit();

		logger.log(LogStatus.PASS, "Credential Created Successfully");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		// Here will compare if test is failing then only it will enter into if
		// condition
		if (result.getStatus() == ITestResult.FAILURE) {

			Utility.captureScreenshot(driver, "CredentialFail.png");

		}
		report.endTest(logger);
		report.flush();

	}
}
