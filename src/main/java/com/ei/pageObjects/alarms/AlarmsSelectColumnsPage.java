package com.ei.pageObjects.alarms;

import org.openqa.selenium.WebDriver;

import com.ei.pageObjects.common.component.AddFilterOrColumnComponent;
import com.ei.pageObjects.common.pages.AddFilterOrColumnPage;

public class AlarmsSelectColumnsPage extends AddFilterOrColumnPage {
	// locators
	AddFilterOrColumnComponent filters;

	// constructor
	/*
	 * public AlarmsSelectColumnsPage(WebDriver driver) { super(driver); filters =
	 * new AddFilterOrColumnComponent(driver,
	 * Arrays.asList(AlarmsColumns.values())); }
	 */

	public AlarmsSelectColumnsPage() {

		filters = new AddFilterOrColumnComponent();
	}

	// methods
	public AlarmsPage applyAddingColumns() {
		super.clickSelectButton();
		return new AlarmsPage();
	}

	public AlarmsPage cancelAddingColumns() {
		super.clickCancelButton();
		return new AlarmsPage();
	}

	public String getColumnName(String filterName) {
		return filters.getItemName(filterName);
	}

	public boolean isFilterChosen(String filterName) {
		return filters.isItemChosen(filterName);
	}

	public void checkFilter(String filterName) {
		clickElement(filters.getItemCheckBox(filterName));
	}

}
