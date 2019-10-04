package com.ei.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.admin.AdminPage;
import com.ei.pageObjects.admin.rules.AdminAlarmRulesPage;
import com.ei.pageObjects.alarms.AlarmsPage;

import io.qameta.allure.Step;

public class MainPage extends BasePage {
	// locators
	@FindBy(xpath = "//div[@class='ei-group-filter']/following-sibling::div[last()]//div[last()]")
	WebElement lblUsername;

	@FindBy(id = "logoutBtnId")
	WebElement lnkLogot;

	@FindBy(id = "console.dashboard.alarms")
	WebElement lnkDashboard;

	@FindBy(id = "console.machines")
	WebElement lnkComputers;

	@FindBy(id = "console.alarms")
	WebElement lnkAlarms;

	@FindBy(id = "console.search")
	WebElement lnkSearch;

	@FindBy(id = "console.executables")
	WebElement lnkExecutables;

	@FindBy(id = "console.scripts")
	WebElement lnkScripts;

	@FindBy(id = "console.admin.rules")
	WebElement lnkAdmin;

	// methods
	public String getLoggedUsername() {
		return getElementText(lblUsername);
	}

	@Step
	public LoginPage clickLogoutButton() {
		clickElement(lnkLogot);
		return new LoginPage();
	}

	@Step
	public AlarmsPage navigateToAlarmsPage() {
		clickElement(lnkAlarms);
		return new AlarmsPage();

	}

	@Step
	public AdminAlarmRulesPage navigateToAdminAlarmsRulesPage() {
		clickElement(lnkAdmin);
		return new AdminAlarmRulesPage();

	}

}
