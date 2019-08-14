package com.ei.pageObjects.alarms;

import org.openqa.selenium.WebDriver;

import com.ei.pageObjects.common.component.AddFilterOrColumnComponent;
import com.ei.pageObjects.common.pages.AddFilterOrColumnPage;

public class AlarmsAddFiltersPage extends AddFilterOrColumnPage {
	// locators
	AddFilterOrColumnComponent filters;

	// constructor
	/*
	 * public AlarmsAddFiltersPage(WebDriver driver) { super(driver); filters = new
	 * AddFilterOrColumnComponent(driver, Arrays.asList(AlarmsFilters.values())); }
	 */
	public AlarmsAddFiltersPage(WebDriver driver) {

		filters = new AddFilterOrColumnComponent();
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
		return filters.getItemName(filterName);
	}

	public boolean isFilterChosen(String filterName) {
		return filters.isItemChosen(filterName);
	}

	public void checkFilter(String filterName) {
		clickElement(filters.getItemCheckBox(filterName));
	}

}
