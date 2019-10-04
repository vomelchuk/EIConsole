package com.ei.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ei.helpers.browsers.WebBrowserDriver;

public class DriverPool {

	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
//	protected static WebDriver driver;

	public static void createDriver() {
		WebBrowserDriver browser = new WebBrowserDriver();
		driver.set(browser.getBrowser());
//		driver = browser.getBrowser();
	}

	public static WebDriver getDriver() {
		return driver.get();
//		return driver;
	}

	public static void closeDriver() {
		getDriver().quit();
//		driver.close();
//		driver.quit();

	}

}
