package com.ei.pageObjects.common.pages.localFilters;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.common.pages.LocalFiltersPage;

public class AlarmRulesLocalFiltersPage extends LocalFiltersPage {
	@FindBy(id = "eid-severity:threat")
	WebElement severityThreat;
	@FindBy(id = "eid-severity:warning")
	WebElement severityWarning;
	@FindBy(id = "eid-severity:info")
	WebElement severityInformation;

	public void clickThreat() {
		clickElement(severityThreat);
	}

	public void clickWarning() {
		clickElement(severityWarning);
	}

	public void clickInformation() {
		clickElement(severityInformation);
	}

}
