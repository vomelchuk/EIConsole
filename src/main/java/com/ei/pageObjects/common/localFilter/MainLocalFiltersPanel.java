package com.ei.pageObjects.common.localFilter;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.BasePage;

public class MainLocalFiltersPanel extends BasePage {

	@FindBy(xpath = "//div[contains(@class,' ei-panel-header ')]//h3")
	WebElement viewName;

	@FindBy(id = "eid-local-filters-special-button")
	WebElement addFiltersButton;

	@FindBy(id = "local-filters-presets")
	WebElement presetsButton;

	@FindBy(id = "eid-download-button")
	WebElement downloadView;

	@FindBy(id = "eid-reload-button")
	WebElement refreshView;
	
	

	
	public String getPageName() {
		return getElementText(viewName);
	}
	
	public void clickAddFilterButton() {
		clickElement(addFiltersButton);
	}
	
	public void clickPresetButton() {
		clickElement(presetsButton);
	}
	
	public void clickDownloadViewButton() {
		clickElement(downloadView);
	}
	
	public void clickRefreshButton() {
		clickElement(refreshView);
	}
	
	// methods


}
