package com.ei.pageObjects.common.pages;

import com.ei.pageObjects.common.component.AddFilterOrColumnComponent;
import com.ei.pageObjects.common.enumeration.implementation.AbstractEnum;

import io.qameta.allure.Step;

public class AddFilterOrColumnPage extends AddFilterOrColumnComponent {

	// methods
	@Step
	public void clickSelectButton() {
		// waitForWebElementDisplayed(btnSelect);
		clickElement(btnSelect);

	}

	@Step
	public void clickCancelButton() {
		clickElement(btnCancel);
	}

	@Step
	public void enterSearchFilter(String text) {
		writeText(txtQuickSearch, text);
	}

}
