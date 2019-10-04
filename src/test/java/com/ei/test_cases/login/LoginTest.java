package com.ei.test_cases.login;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ei.businessObjects.LoginToConsoleBO;
import com.ei.test_cases.BaseTest;
import com.ei.test_cases.BaseTestLogged;
import com.ei.test_cases.EIListener;
import com.ei.util.EILogger;
import com.ei.utils.Configuration;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginTest extends BaseTest {

	Logger log = Logger.getLogger(LoginTest.class.getName());

	@Test
	@Description("Login to EI console as native user with valid credentials")
	@Story("Valid username and password login test")
	@Severity(SeverityLevel.BLOCKER)
	public void loginAsValidNativeUserTest() {

		String user = Configuration.get("username");
		String passw = Configuration.get("password");
		log.debug("Login as native user [" + user + "," + passw + "] ...");
		LoginToConsoleBO.loginAsNativeUserWithValidCredentials(user, passw);
		log.debug("Native user has logged successsfully");
		String loggedUser = LoginToConsoleBO.getLoggedUser();
		sa.assertEquals(loggedUser, user.toUpperCase(), "Actual: " + loggedUser + ", expected: " + user);
		sa.assertAll();
		log.debug("User is leaving EI console");
		LoginToConsoleBO.logout();

	}

	@Test(enabled=false)
	@Description("Login to EI console as domain user with valid credentials")
	@Story("Valid username and password login test")
	@Severity(SeverityLevel.BLOCKER)
	public void loginAsValidDomainUserTest() {

		String user = Configuration.get("domain_username");
		String passw = Configuration.get("domain_password");
		log.debug("Login as domain user [" + user + "," + passw + "] ...");
		LoginToConsoleBO.loginAsDomainUserWithValidCredentials(user, passw);
		log.debug("Domain user has logged successsfully");
		String loggedUser = LoginToConsoleBO.getLoggedUser();
		sa.assertEquals(loggedUser, user.toUpperCase(), "Actual: " + loggedUser + ", expected: " + user);
		sa.assertAll();
		LoginToConsoleBO.logout();

	}

	@Test
	@Description("Login to EI console as native user with invalid credentials")
	@Story("Invalid username and password login test")
	@Severity(SeverityLevel.BLOCKER)
	public void loginAsInvalidNativeUserTest() {
		log.debug("Login as native user with invalid credentials");
		String errorMessage = LoginToConsoleBO.loginAsNativeUserWithInvalidCredentials("unknow_user", "password_here");
		log.debug("Received error message: " + errorMessage);
		String expectedMessage = "Login failed:";
		String assertMessage = "Expected message `" + expectedMessage + "` is not contained in " + errorMessage;
		sa.assertTrue(expectedMessage.contains(expectedMessage), assertMessage);
		sa.assertAll();
	}

	@Test(enabled = false)
	@Description("Login to EI console as domain user with invalid credentials")
	@Story("Invalid username and password login test")
	@Severity(SeverityLevel.BLOCKER)
	public void loginAsInvalidDomainUserTest() {
		log.debug("Login as domain user with invalid credentials");
		String errorMessage = LoginToConsoleBO.loginAsDomainWithInvalidCredentials("domain\\unknown_user",
				"password_here");
		String expectedMessage = "Login failed:";
		String assertMessage = "Expected message `" + expectedMessage + "` is not contained in " + errorMessage;
		sa.assertTrue(errorMessage.contains(expectedMessage), assertMessage);
		sa.assertAll();
	}

}
