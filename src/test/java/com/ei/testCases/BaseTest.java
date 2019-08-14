package com.ei.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.ei.businessObjects.LoginPageBO;
import com.ei.helpers.DriverPool;
import com.ei.utils.Configuration;

public class BaseTest {

	protected WebDriver driver;
	protected LoginPageBO login;

	@BeforeSuite
	public void beforeSuite() {
		DriverPool.createDriver();
		driver = DriverPool.getDriver();
		// driver.manage().window().maximize();
	}

	@AfterSuite
	public void afterSuite() {
		DriverPool.closeDriver();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to(Configuration.get("baseUrl"));
		login = new LoginPageBO(driver);
	}

	@AfterMethod
	public void afterMethod() {
		if (login != null)
			login = null;
	}

	
	
	
	
	
	// will be deleted after project finished
	public void testWait(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
