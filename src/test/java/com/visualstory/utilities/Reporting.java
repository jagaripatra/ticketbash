package com.visualstory.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.visualstory.testcases.BaseTest;

public class Reporting extends TestListenerAdapter {

	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;

	String timeStamp = new SimpleDateFormat("dd-MMM-yy-HH-mm-ss-a").format(new Date());

	@Override
	public void onStart(ITestContext testContext) {
		String reportPath = "C:\\VisualStoryReport\\reports\\TestRunResults_" + timeStamp + "\\report.html";

		htmlReporter = new ExtentSparkReporter(reportPath);
		htmlReporter.config().setDocumentTitle("VisualStory Test Project");
		htmlReporter.config().setReportName("Functional Test Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "Jagari Patra");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getTestClass().getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getTestClass().getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getTestClass().getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getTestClass().getName(), ExtentColor.RED));

		String screenshotPath = "C:\\VisualStoryReport\\reports\\TestRunResults_" + timeStamp + "\\Screenshots\\"
				+ "screenshot.png";

		try {
			Field[] fields = tr.getTestClass().getRealClass().getFields();
			String name = fields[2].getName();
			 
			WebDriver driver = (WebDriver) fields[2].get(tr.getInstance());
			BaseTest.getScreenshot(driver, screenshotPath);

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.fail(tr.getThrowable());
		logger.addScreenCaptureFromPath(screenshotPath);
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getClass().getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getClass().getName(), ExtentColor.ORANGE));
	}
}
