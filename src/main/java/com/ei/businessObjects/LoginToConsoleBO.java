package com.ei.businessObjects;

import com.ei.pageObjects.LoginPage;
import com.ei.pageObjects.MainPage;

public class LoginToConsoleBO {

	private static LoginPage login = new LoginPage();
	private static MainPage main = new MainPage();

	public static void loginAsNativeUserWithValidCredentials(String user, String passw) {
		login.setUsername(user).setPassword(passw).clickLoginButton();
	}

	public static void loginAsDomainUserWithValidCredentials(String user, String passw) {
		login.setUsername(user).setPassword(passw).checkDomainUserCheckbox().clickLoginButton();
	}

	public static String getLoggedUser() {
		return main.getLoggedUsername();
	}

	public static void logout() {
		main.clickLogoutButton();
	}

	public static String loginAsNativeUserWithInvalidCredentials(String user, String passw) {
		login.setUsername(user).setPassword(passw).clickLoginButton();
		return login.getErrorMessage();
	}

	public static String loginAsDomainWithInvalidCredentials(String user, String passw) {
		login.setUsername(user).setPassword(passw).checkDomainUserCheckbox().clickLoginButton();
		return login.getErrorMessage();
	}

}
