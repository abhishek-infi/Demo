package Demo;

import library.Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Login_Process.LoginPages;
import Pages.add_provider_page;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Add_Provider extends Start {

	ExtentReports report;
	ExtentTest logger;

	@Test
	public void Provider() throws Exception {

		report = new ExtentReports("D:/Reports/Report.html");

		logger = report.startTest("Add Provider");

		// Login To Portal
		new LoginPages(driver).usernameAs("admin").passwordAs("admin123")
				.submit();

		// Click on Menu
		new add_provider_page(driver).Menu();

		// Click on Administration From Menu
		new add_provider_page(driver).Administration();

		// Click on 'Provider' Option
		new add_provider_page(driver).Provider();

		// Click on 'Create New' button on Provider page
		new add_provider_page(driver).Create_New();

		// Select The type of provider you want (VMware)
		new add_provider_page(driver).Type();

		// Enter The Name of Provider
		new add_provider_page(driver).ProvidernameAs("vmware456");

		// Enter Description
		new add_provider_page(driver).DescriptionAs("testing");

		// HostName
		new add_provider_page(driver).hostnameAs("vmware55.infiverve.com:5443");

		// Provider Username
		new add_provider_page(driver).usernameAs("root");

		// Password
		new add_provider_page(driver).PasswordAs("vmware");

		// Verify Credentials button
		new add_provider_page(driver).Verify_cred();

		// Click on Register button
		new add_provider_page(driver).Register_button();

		logger.log(LogStatus.PASS, "Provider Created Successfully");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		// Here will compare if test is failing then only it will enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {

				Utility.captureScreenshot(driver, "AddProviderfail.png");

			} catch (Exception e) {
				System.out.println("Exception while taking screenshot "
						+ e.getMessage());
			}
		}

		report.endTest(logger);
		report.flush();
		driver.close();

	}
}