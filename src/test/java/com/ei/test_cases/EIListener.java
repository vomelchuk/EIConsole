package com.ei.test_cases;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.ei.helpers.DriverPool;
import io.qameta.allure.Attachment;

public class EIListener implements ITestListener {

	Logger log = Logger.getLogger(EIListener.class.getName());

	@Override
	public void onTestStart(ITestResult result) {
		log.info(result.getName() + ": has started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info(result.getName() + ": PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.error(result.getName() + ": FAILED");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}
//
//	public void takeScreenShot(String methodName, WebDriver drv) {
//		Calendar cal = new GregorianCalendar();
//		String timestamp = cal.get(Calendar.YEAR) + "_" + cal.get(Calendar.DATE) + "_" + (cal.get(Calendar.MONTH) + 1)
//				+ "_" + cal.get(Calendar.HOUR_OF_DAY) + "_" + cal.get(Calendar.MINUTE) + "_" + cal.get(Calendar.SECOND);
////		System.out.println("takeScreenshot Driver: " + driver);
//		File srcFile = null;
//		try {
//			srcFile = ((TakesScreenshot) drv).getScreenshotAs(OutputType.FILE);
//		} catch (NullPointerException e) {
//			e.printStackTrace();
//		}
//
//		try {
//			String destination = "screenshots/" + methodName + "_" + timestamp + ".jpeg";
//			File destFile = new File(destination);
//			FileUtils.copyFile(srcFile, destFile);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}

	@Attachment(value = "EI console screenshot", type = "image/png")
	public byte[] takeScreenshotPNG(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

}
