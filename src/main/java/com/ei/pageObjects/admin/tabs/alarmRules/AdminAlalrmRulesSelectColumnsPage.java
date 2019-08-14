package com.ei.pageObjects.admin.tabs.alarmRules;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.alarms.AlarmsPage;
import com.ei.pageObjects.common.component.AddFilterOrColumnComponent;
import com.ei.pageObjects.common.enumeration.column.AdminRulesColumns;
import com.ei.pageObjects.common.enumeration.column.AlarmsColumns;
import com.ei.pageObjects.common.enumeration.filter.AdminRulesFilters;
import com.ei.pageObjects.common.pages.AddFilterOrColumnPage;

public class AdminAlalrmRulesSelectColumnsPage extends AddFilterOrColumnPage {
	// locators
	AddFilterOrColumnComponent columns;

	// constructor
	public AdminAlalrmRulesSelectColumnsPage(WebDriver driver) {
		columns = new AddFilterOrColumnComponent();
	}

	// methods
	public AlarmsPage applyAddingFilters() {
		super.clickSelectButton();
		return new AlarmsPage();
	}

	public AlarmsPage cancelAddingFilters() {
		super.clickCancelButton();
		return new AlarmsPage();
	}

	public String getFilterName(String filterName) {
		return columns.getItemName(filterName);
	}

	public boolean isFilterChosen(String filterName) {
		return columns.isItemChosen(filterName);
	}
	
	public void checkFilter(String filterName) {
		clickElement(columns.getItemCheckBox(filterName));
	}

}
