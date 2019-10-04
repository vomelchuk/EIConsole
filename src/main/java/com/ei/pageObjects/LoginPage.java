package com.ei.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

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

	@FindBy(xpath = "//span[contains(text(), 'Login failed:')]")
	WebElement errNotification;

	// methods
	@Step
	public LoginPage setUsername(String user) {
		writeText(txtUsername, user);
		return this;
	}

	@Step
	public LoginPage setPassword(String passw) {
		writeText(txtPassword, passw);
		return this;
	}

	@Step
	public LoginPage checkDomainUserCheckbox() {
		clickElement(chkDomainUser);
		return this;
	}

	@Step
	public void clickLoginButton() {
		clickElement(btnLogin);
	}

	public String getErrorMessage() {
		return getElementText(errNotification);
	}

}
