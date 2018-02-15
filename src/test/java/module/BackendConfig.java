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

import page_object.BackendConfigPage;
import page_object.LoginPage;

import com.aventstack.extentreports.Status;

public class BackendConfig extends Start {
	@Test
	public void Backend_Configuration() throws IOException {

		test = extent.createTest("Backend_Config");

		test.log(Status.INFO, "Let's Login to Portal");

		// jFairy object

		Fairy fairy = Fairy.create();

		TextProducer textProducer = fairy.textProducer();

		// Property file object
		Properties obj = new Properties();

		FileInputStream objFile = new FileInputStream(
				System.getProperty("user.dir") + "/DataFile.Properties/");

		obj.load(objFile);

		new LoginPage(driver).usernameAs(obj.getProperty("username"))
				.passwordAs(obj.getProperty("password")).submit();

		new BackendConfigPage(driver).Menu();

		new BackendConfigPage(driver).Administration();

		new BackendConfigPage(driver).Backend_Config();

		new BackendConfigPage(driver).Create_New();

		new BackendConfigPage(driver).NameAs(textProducer.sentence(8))
				.DescriptionAs(textProducer.randomString(10));

		new BackendConfigPage(driver).Submit();

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		// Here will compare if test is failing then only it will enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {

				test.log(Status.ERROR,
						"Test Case Failed, Please check the attachedd screenshot");
				// Take Screenshot
				String screenShotPath = Utility.captureScreenshot(driver,
						"screenshotName");
				// Save Screenshot in Report
				test.fail("Snapshot below: "
						+ test.addScreenCaptureFromPath(screenShotPath));

			} catch (Exception e) {
				System.out.println("Exception while taking screenshot"
						+ e.getMessage());
			}
		}

	}
}
