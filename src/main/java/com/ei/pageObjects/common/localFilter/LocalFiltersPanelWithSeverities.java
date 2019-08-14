package com.ei.pageObjects.common.localFilter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocalFiltersPanelWithSeverities extends MainLocalFiltersPanel {
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
