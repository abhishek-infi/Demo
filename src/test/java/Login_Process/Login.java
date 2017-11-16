package Login_Process;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Demo.Start;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Login extends Start {

	ExtentReports report;
	ExtentTest logger;

	@Test
	public void signin() throws Exception {

		report = new ExtentReports("D:/Reports/Report.html");

		logger = report.startTest("Login to the portal");

		new LoginPages(driver).usernameAs("admin").passwordAs("admin123")
				.submit();

		logger.log(LogStatus.PASS, "Login Successfull");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		// Here will compare if test is failing then only it will enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {

				Utility.captureScreenshot(driver, "Loginfail.png");

			} catch (Exception e) {
				System.out.println("Exception while taking screenshot "
						+ e.getMessage());
			}
		}

		report.endTest(logger);
		report.flush();
		// driver.close();
	}

}
