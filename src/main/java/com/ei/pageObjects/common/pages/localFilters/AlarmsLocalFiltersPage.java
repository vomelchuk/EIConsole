package com.ei.pageObjects.common.pages.localFilters;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlarmsLocalFiltersPage extends AlarmRulesLocalFiltersPage {
	@FindBy(id = "eid-priority:0")
	WebElement priority0;
	@FindBy(id = "eid-priority:1")
	WebElement priority1;
	@FindBy(id = "eid-priority:2")
	WebElement priority2;
	@FindBy(id = "eid-priority:3")
	WebElement priority3;

	public void clickPriority0() {
		clickElement(priority0);
	}

	public void clickPriority1() {
		clickElement(priority1);
	}

	public void clickPriority2() {
		clickElement(priority2);
	}

	public void clickPriority3() {
		clickElement(priority3);
	}
}
