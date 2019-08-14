package com.ei.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects._later.ComputersPage;
import com.ei.pageObjects._later.DashboardPage;
import com.ei.pageObjects._later.ExecutablesPage;
import com.ei.pageObjects._later.ScriptsPage;
import com.ei.pageObjects._later.SearchPage;
import com.ei.pageObjects.admin.AdminPage;
import com.ei.pageObjects.admin.tabs.alarmRules.AdminAlarmRulesPage;
import com.ei.pageObjects.alarms.AlarmsPage;

public class HeaderSidebarPage extends BasePage {
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

	public LoginPage clickLogoutButton() {
		clickElement(lnkLogot);
		return new LoginPage();
	}

	public DashboardPage getDashboardPage() {
		clickElement(lnkDashboard);
		return new DashboardPage();

	}

	public ComputersPage getComputersPage() {
		clickElement(lnkComputers);
		return new ComputersPage();

	}

	public AlarmsPage getAlarmsPage() {
		clickElement(lnkAlarms);
		return new AlarmsPage();

	}

	public SearchPage getSearchPage() {
		clickElement(lnkSearch);
		return new SearchPage();

	}

	public ExecutablesPage getExecutablesPage() {
		clickElement(lnkExecutables);
		return new ExecutablesPage();

	}

	public ScriptsPage getScriptsPage() {
		clickElement(lnkScripts);
		return new ScriptsPage();

	}

	public AdminAlarmRulesPage getAdminAlarmsRulesPage() {
		clickElement(lnkAdmin);
		return new AdminAlarmRulesPage();

	}

}
