package com.ei.test_cases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.ei.businessObjects.LoginToConsoleBO;
import com.ei.utils.Configuration;

public class BaseTestLogged extends BaseTest {

	@BeforeMethod
	public void loginToEIConsole() {
		LoginToConsoleBO.loginAsNativeUserWithValidCredentials(Configuration.getNativeUsername(),
				Configuration.getNativePassword());
	}

	@AfterMethod
	public void logoutOfEIConsole() {
		LoginToConsoleBO.logout();
	}

}
