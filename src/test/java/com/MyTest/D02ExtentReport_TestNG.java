package com.MyTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class D02ExtentReport_TestNG {
	WebDriver driver;
	ExtentSparkReporter htmlReport;
	ExtentReports report;

	ExtentTest test;

	@Test(priority = 1)
	public void orangeHRM() {
		test = report.createTest("OrangeHRM Test");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Assert.assertTrue(driver.getTitle().contains("Orange"));

	}

	@Test(priority = 2)
	public void googleTest() {
		test = report.createTest("Google Test");
		driver.get("https://www.google.com");
		Assert.assertTrue(driver.getTitle().contains("Orange"));
	}

	@Test(priority = 3)
	public void openFacebook() {
		test = report.createTest("Facebook Test");
		driver.get("https://www.facebook.com/");

		throw new SkipException("Skipping this test");
	}

	@AfterMethod
	public void createReport(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS)
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		else if (result.getStatus() == ITestResult.FAILURE)
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		else if (result.getStatus() == ITestResult.SKIP)
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
	}

	@BeforeTest
	public void beforeTest() {
		htmlReport = new ExtentSparkReporter("My New first Report");
		report = new ExtentReports();
		report.attachReporter(htmlReport);

		report.setSystemInfo("machine name", "samsung");
		report.setSystemInfo("tester name", "Banti");
		report.setSystemInfo("os", "windows11");
		report.setSystemInfo("Browser Name", "Chrome");

		// config of look and feel report
		htmlReport.config().setDocumentTitle("my first extent report");
		htmlReport.config().setReportName("Google Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setTimeStampFormat("EEEE MMM DD, YYYY HH:MM:SS");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {

		driver.close();
		report.flush();
	}

}
