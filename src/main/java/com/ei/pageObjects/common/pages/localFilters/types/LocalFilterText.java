package com.ei.pageObjects.common.pages.localFilters.types;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.common.pages.localFilters.FilterOption;
import com.ei.pageObjects.common.pages.localFilters.LocalFilter;

public class LocalFilterText extends BaseLocalFilter {
	@FindBy(xpath = "//input[@class='local-filter-input-text']")
	WebElement txtText;

	public void setValue(String value) {
		writeTextAndEnter(txtText, value);
	}

	public void clearValue() {
		writeTextAndEnter(txtText, "");

	}

}
