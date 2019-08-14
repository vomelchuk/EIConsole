package com.ei.testCases.LoginTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ei.businessObjects.LoginPageBO;
import com.ei.pageObjects._later.DashboardPage;
import com.ei.testCases.BaseTest;
import com.ei.utils.Configuration;

public class LoginPageTest extends BaseTest {
	DashboardPage dashboard;

	@Test(priority = 1)
	public void loginAsNativeUserTest() {
		
		String user = Configuration.get("username");
		String passw = Configuration.get("password");
		dashboard = login.loginAsNativeUser(user, passw);
		String loggedUser = dashboard.getLoggedUsername();
		Assert.assertEquals(loggedUser, user.toUpperCase());
		dashboard.clickLogoutButton();
	}

	@Test(priority = 2)
	public void loginAsDomainUserTest() {
		
		String user = Configuration.get("domain_username");
		String passw = Configuration.get("domain_password");
		dashboard = login.loginAsDomainUser(user, passw);
		String loggedUser = dashboard.getLoggedUsername();
		Assert.assertEquals(loggedUser, user.toUpperCase());
		dashboard.clickLogoutButton();
	}

}
