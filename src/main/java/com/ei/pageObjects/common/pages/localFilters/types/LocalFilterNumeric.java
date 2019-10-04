package com.ei.pageObjects.common.pages.localFilters.types;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.BasePage;
import com.ei.pageObjects.common.pages.localFilters.FilterOption;
import com.ei.pageObjects.common.pages.localFilters.LocalFilter;

public class LocalFilterNumeric extends BaseLocalFilter  {
	@FindBy(xpath = "//input[@class='local-filter-input-number']")
	WebElement txtNumber;


	public void setValue(int value) {
		writeTextAndEnter(txtNumber, String.valueOf(value));
	}

	public void clearValue() {
		writeTextAndEnter(txtNumber, "");

	}
}
