package com.ei.test_cases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.ei.helpers.DriverPool;
import com.ei.util.EISoftAssert;
import com.ei.utils.Configuration;

public class BaseTest {
	
	protected WebDriver driver;
	protected static EISoftAssert sa = new EISoftAssert();

	@BeforeSuite
	public void beforeSuite() {
		DOMConfigurator.configure("log4j.xml");
		DriverPool.createDriver();
		driver = DriverPool.getDriver();
		driver.navigate().to(Configuration.get("baseUrl"));
//		driver.manage().window().maximize();
	}

	@AfterSuite
	public void afterSuite() {
		DriverPool.closeDriver();
	}

}
