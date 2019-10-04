package com.ei.pageObjects.common.pages.localFilters.types;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocalFilterDropdown extends BaseLocalFilter {
	@FindBy(xpath = "//select[@class='local-filter-select']")
	WebElement select;
}
