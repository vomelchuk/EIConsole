package com.ei.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects._later.DashboardPage;

public class LoginPage extends BasePage {

	// locators
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement txtUsername;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement txtPassword;

	@FindBy(xpath = "//button")
	WebElement btnLogin;

	@FindBy(xpath = "//span[text()='Log into Domain']/ancestor::label/span")
	WebElement chkDomainUser;

	@FindBy(xpath = "//span[contains(text(), 'Login failed:') and @xpath='1']")
	WebElement errNotification;

	// methods
	public LoginPage setUsername(String user) {
		writeText(txtUsername, user);
		return this;
	}

	public LoginPage setPassw0rd(String passw) {
		writeText(txtPassword, passw);
		return this;
	}

	public LoginPage clickDomainUserCheckBox() {
		clickElement(chkDomainUser);
		return this;
	}

	public DashboardPage clickLoginButton() {
		clickElement(btnLogin);
		return new DashboardPage();
	}

}
