package com.ei.pageObjects.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.HeaderSidebarPage;
import com.ei.pageObjects.admin.tabs.AdminAuditPage;
import com.ei.pageObjects.admin.tabs.AdminBlockedHashesPage;
import com.ei.pageObjects.admin.tabs.AdminExclusionsPage;
import com.ei.pageObjects.admin.tabs.AdminServerSettingsPage;
import com.ei.pageObjects.admin.tabs.AdminTasksPage;
import com.ei.pageObjects.admin.tabs.alarmRules.AdminAlarmRulesPage;

public class AdminPage extends HeaderSidebarPage {

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


	public AdminAlarmRulesPage chooseAlarmsRulesTab() {
		clickNotClickableElement(lnkRules);
		return new AdminAlarmRulesPage();
	}

	public AdminExclusionsPage chooseExclusionsTab() {
		clickNotClickableElement(lnkExclusions);
		return new AdminExclusionsPage();
	}

	public AdminTasksPage chooseTasksTab() {
		clickNotClickableElement(lnkTasks);
		return new AdminTasksPage();
	}

	public AdminBlockedHashesPage chooseBlockedHashesTab() {
		clickNotClickableElement(lnkHashes);
		return new AdminBlockedHashesPage();
	}

	public AdminServerSettingsPage chooseServerSettingsTab() {
		clickNotClickableElement(lnkServerSettings);
		return new AdminServerSettingsPage();
	}

	public AdminAuditPage chooseAuditTab() {
		clickNotClickableElement(lnkAudit);
		return new AdminAuditPage();
	}


}
