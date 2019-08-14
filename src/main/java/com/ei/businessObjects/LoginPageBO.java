package com.ei.businessObjects;

import org.openqa.selenium.WebDriver;
import com.ei.pageObjects.LoginPage;
import com.ei.pageObjects._later.DashboardPage;

public class LoginPageBO {

	private LoginPage loginPage;

	public LoginPageBO(WebDriver driver) {
		loginPage = new LoginPage();
	}

	public DashboardPage loginAsNativeUser(String user, String passw) {
		return loginPage.setUsername(user).setPassw0rd(passw).clickLoginButton();
	}

	public DashboardPage loginAsDomainUser(String user, String passw) {
		return loginPage.setUsername(user).setPassw0rd(passw).clickDomainUserCheckBox().clickLoginButton();
	}

}
