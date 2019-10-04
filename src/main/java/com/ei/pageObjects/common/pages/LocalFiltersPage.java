package com.ei.pageObjects.common.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.ei.pageObjects.BasePage;

import io.qameta.allure.Step;

public class LocalFiltersPage extends BasePage {

	// @FindBy(xpath = "//div[contains(@class,' ei-panel-header ')]//h3")
	@FindBy(xpath = "(//div[contains(@class,' ei-panel-header ')])[1]//h3")
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
	@Step
	public void clickAddFilterButton() {
		clickElement(addFiltersButton);
	}
	@Step
	public void clickPresetButton() {
		clickElement(presetsButton);
	}
	@Step
	public void clickDownloadViewButton() {
		clickElement(downloadView);
	}
	@Step
	public void clickRefreshButton() {
		clickElement(refreshView);
	}

}
