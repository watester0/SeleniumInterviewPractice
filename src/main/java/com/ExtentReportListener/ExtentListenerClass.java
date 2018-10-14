package com.ExtentReportListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentListenerClass implements ITestListener {

	public static String filepath = "D:\\Automation\\Practice\\Soltex\\Practice\\test-output\\";

	public static ExtentTest test;
	public static ExtentReports reports;
	public static WebDriver driver;
	public static Actions action;
	public static Select select;
	public static WebDriverWait wait;

	public void onTestStart(ITestResult result) {
		System.out.println("***On test START***");
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + "***test is STARTED***");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("****On Test Success****");
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + "***Test is PASSED***");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("***on Test Failure***");
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "***Test is FAILED***");
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("D:\\Automation\\Practice\\Soltex\\Practice\\screenshots0\\"
					+ result.getMethod().getMethodName() + ".png"));
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "***Test is FAILED***");
			test.log(LogStatus.FAIL, result.getThrowable().getMessage() + "***Test is FAILED***");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("***on Test Skipped***");
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "***Test is SKIPPED***");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("on test sucess within percentage");
	}

	public void onFinish(ITestContext result) {
		System.out.println("On FINISH");
		driver.close();
		reports.endTest(test);
		reports.flush();
	}

	public void onStart(ITestContext result) {
		System.out.println("On Start");

		//reports = new ExtentReports(filepath + "reports.html");
		reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Practice\\jars\\chromedriver.exe");
		driver = new ChromeDriver();
		/*
		 * driver.get("https://www.google.com"); driver.manage().window().maximize(); //
		 * driver.manage().window().fullscreen();
		 * 
		 * action = new Actions(driver); }
		 */

	}
}