package module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Start {

	// Public variables for Extent Report
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static WebDriver driver;

	@BeforeClass
	public void setupApplication() {
		System.setProperty("webdriver.gecko.driver",
				"D:\\geckodriver-v0.16.1-win64");
		System.setProperty("webdriver.chrome.driver",
				"D:\\Abhishek K\\CromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://opshub.flintcloud.info");

	}

	// Code Starts here to Generate the Extent HTML Report

	@AfterClass
	public void closeApplication() {
		// driver.quit();

	}

	@BeforeSuite
	public void generate() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
				+ "/test-output/MyOwnReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle(
				"AutomationTesting in Demo project");
		htmlReporter.config().setReportName("Flint Test Cases Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);

	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName()
							+ " Test case FAILED due to below issues:",
							ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(
					Status.PASS,
					MarkupHelper.createLabel(result.getName()
							+ " Test Case PASSED", ExtentColor.GREEN));
		} else {
			test.log(
					Status.SKIP,
					MarkupHelper.createLabel(result.getName()
							+ " Test Case SKIPPED", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
}
