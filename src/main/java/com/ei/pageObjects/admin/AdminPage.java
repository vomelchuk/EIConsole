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
	public AdminAlarmRulesPage getAlarmsRulesTab() {
		clickNotClickableElement(lnkRules);
		return new AdminAlarmRulesPage();
	}
	@Step
	public AdminExclusionsPage getExclusionsTab() {
		clickNotClickableElement(lnkExclusions);
		return new AdminExclusionsPage();
	}
	@Step
	public AdminTasksPage getTasksTab() {
		clickNotClickableElement(lnkTasks);
		return new AdminTasksPage();
	}
	@Step
	public AdminBlockedHashesPage getBlockedHashesTab() {
		clickNotClickableElement(lnkHashes);
		return new AdminBlockedHashesPage();
	}
	@Step
	public AdminServerSettingsPage getServerSettingsTab() {
		clickNotClickableElement(lnkServerSettings);
		return new AdminServerSettingsPage();
	}
	@Step
	public AdminAuditPage getAuditTab() {
		clickNotClickableElement(lnkAudit);
		return new AdminAuditPage();
	}


}
