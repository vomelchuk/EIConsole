package com.ei.pageObjects.common.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.ei.pageObjects.BasePage;

public class AddFilterOrColumnPage extends BasePage {
	// locators
	@FindBy(xpath = "//label[text()='Enter quick search pattern.']/../..//input")
	WebElement txtQuickSearch;
	@FindBy(id = "eid-selector-button-select")
	WebElement btnSelect;
	@FindBy(id = "eid-selector-button-cancel")
	WebElement btnCancel;

	// methods
	protected void clickSelectButton() {
		clickElement(btnSelect);
	}

	protected void clickCancelButton() {
		clickElement(btnCancel);
	}

	protected void enterSearchFilter(String text) {
		writeText(txtQuickSearch, text);
	}

}
