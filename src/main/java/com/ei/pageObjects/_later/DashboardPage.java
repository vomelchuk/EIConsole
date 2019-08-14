package com.ei.pageObjects._later;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.HeaderSidebarPage;

public class DashboardPage extends HeaderSidebarPage {

	@FindBy(id = "eid-tab-console.dashboard.alarms")
	WebElement lnkAlarms;

	@FindBy(id = "eid-tab-console.dashboard.executables")
	WebElement lnkExecutables;

	@FindBy(id = "eid-tab-console.dashboard.computers")
	WebElement lnkComputers;

	@FindBy(id = "eid-tab-console.dashboard.more")
	WebElement lnkMore;

	@FindBy(id = "eid-tab-console.dashboard.server")
	WebElement lnkServerStatus;



	// methods


}
