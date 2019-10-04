package com.ei.pageObjects.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.MainPage;
import com.ei.pageObjects.admin.hashes.AdminBlockedHashesPage;
import com.ei.pageObjects.admin.rules.AdminAlarmRulesPage;
import com.ei.pageObjects.admin.tabs.AdminAuditPage;
import com.ei.pageObjects.admin.tabs.AdminExclusionsPage;
import com.ei.pageObjects.admin.tabs.AdminServerSettingsPage;
import com.ei.pageObjects.admin.tabs.AdminTasksPage;

import io.qameta.allure.Step;

public class AdminPage extends MainPage {

	@FindBy(id = "eid-tab-console.admin.rules")
	WebElement lnkRules;
	@FindBy(id = "eid-tab-console.admin.exclusions")
	WebElement lnkExclusions;
	@FindBy(id = "eid-tab-console.admin.tasks")
	WebElement lnkTasks;
	@FindBy(id = "eid-tab-console.admin.hashes")
	WebElement lnkHashes;
	@FindBy(id = "eid-tab-console.admin.server-settings")
	WebElement lnkServerSettings;
	@FindBy(id = "eid-tab-console.admin.audit")
	WebElement lnkAudit;

	@Step
	public AdminAlarmRulesPage chooseAlarmsRulesTab() {
		clickNotClickableElement(lnkRules);
		return new AdminAlarmRulesPage();
	}
	@Step
	public AdminExclusionsPage chooseExclusionsTab() {
		clickNotClickableElement(lnkExclusions);
		return new AdminExclusionsPage();
	}
	@Step
	public AdminTasksPage chooseTasksTab() {
		clickNotClickableElement(lnkTasks);
		return new AdminTasksPage();
	}
	@Step
	public AdminBlockedHashesPage chooseBlockedHashesTab() {
		clickNotClickableElement(lnkHashes);
		return new AdminBlockedHashesPage();
	}
	@Step
	public AdminServerSettingsPage chooseServerSettingsTab() {
		clickNotClickableElement(lnkServerSettings);
		return new AdminServerSettingsPage();
	}
	@Step
	public AdminAuditPage chooseAuditTab() {
		clickNotClickableElement(lnkAudit);
		return new AdminAuditPage();
	}


}
