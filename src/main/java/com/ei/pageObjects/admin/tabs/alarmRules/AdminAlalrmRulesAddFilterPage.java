package com.ei.pageObjects.admin.tabs.alarmRules;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.common.component.AddFilterOrColumnComponent;
import com.ei.pageObjects.common.enumeration.column.AdminRulesColumns;
import com.ei.pageObjects.common.enumeration.filter.AdminRulesFilters;
import com.ei.pageObjects.common.pages.AddFilterOrColumnPage;

public class AdminAlalrmRulesAddFilterPage extends AddFilterOrColumnPage {
	// locators
	AddFilterOrColumnComponent filters;

	// constructor
	public AdminAlalrmRulesAddFilterPage(WebDriver driver) {
		filters = new AddFilterOrColumnComponent();
	}

	// methods
	public AdminAlarmRulesPage applyAddingFilters() {
		super.clickSelectButton();
		return new AdminAlarmRulesPage();
	}

	public AdminAlarmRulesPage cancelAddingFilters() {
		super.clickCancelButton();
		return new AdminAlarmRulesPage();
	}

	public String getFilterName(String filterName) {
		return filters.getItemName(filterName);
	}

	public boolean isFilterChosen(String filterName) {
		return filters.isItemChosen(filterName);
	}
	
	public void checkFilter(String filterName) {
		clickElement(filters.getItemCheckBox(filterName));
	}

}
