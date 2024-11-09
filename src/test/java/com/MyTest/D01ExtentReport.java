package com.MyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class D01ExtentReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("My first Report");
		ExtentReports report=new ExtentReports();
		report.attachReporter(htmlReport);
		ExtentTest test;
		
		//add environment
		report.setSystemInfo("machine name", "samsung");
		report.setSystemInfo("tester name", "Banti");
		report.setSystemInfo("os", "windows11");
		report.setSystemInfo("Browser Name", "Chrome");
		
		//config of look and feel report
		htmlReport.config().setDocumentTitle("my first extent report");
		htmlReport.config().setReportName("Google Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setTimeStampFormat("EEEE MMM DD, YYYY HH:MM:SS");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.close();
		
		test=report.createTest("Google Test");
		test.log(Status.PASS, MarkupHelper.createLabel("Google Title:Pass", ExtentColor.GREY));
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Extent Report", Keys.ENTER);
		driver.close();
		test=report.createTest("Google search Test");
		test.log(Status.PASS, MarkupHelper.createLabel("Google Title:Pass", ExtentColor.GREY));
		
		report.flush();//generate report

	}

}
