package com.ei.pageObjects.alarms;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.HeaderSidebarPage;
import com.ei.pageObjects.common.component.TableComponent;
import com.ei.pageObjects.common.enumeration.CustomItems;
import com.ei.pageObjects.common.enumeration.column.AlarmsColumns;
import com.ei.pageObjects.common.localFilter.LocalFiltersPanelWithSeveritiesPriorities;

public class AlarmsPage extends HeaderSidebarPage {
	// fields
	@FindBy(id = "commanding-toolbar-left-button-0")
	WebElement btnMarkAsResolved;
	@FindBy(id = "commanding-toolbar-left-button-1")
	WebElement btnMarkAsUnresolved;
	@FindBy(id = "commanding-toolbar-left-button-2")
	WebElement btnMarkAsPriority;
	@FindBy(id = "commanding-toolbar-right-button-0")
	WebElement btnCreateExclusion;
	@FindBy(id = "commanding-toolbar-right-button-1")
	WebElement btnEditRule;
	
	CustomItems columns;
	LocalFiltersPanelWithSeveritiesPriorities localFilters;
	TableComponent tableView;

	// constructors
	public AlarmsPage() {
		localFilters = new LocalFiltersPanelWithSeveritiesPriorities();
		tableView = new TableComponent(Arrays.asList(AlarmsColumns.values()));
	}

	// methods returning other object
	public AlarmsAddFiltersPage getAddFilterPage() {
		localFilters.clickAddFilterButton();
		return new AlarmsAddFiltersPage(driver);
	}

	public AlarmsPage refreshView() {
		localFilters.clickRefreshButton();
		return this;
	}

	public AlarmsSelectColumnsPage getSelectColumnsPage() {
		tableView.selectColumns();
		return new AlarmsSelectColumnsPage();
	}

	// other methods
	public List<WebElement> getAllColumnValuesByColumnName(String columnName) {
		return tableView.getWebElementsByColumnName(columnName);
	}

	// invoke context menu of particular element in the table
	public void clickTableElement(String columnName, int ind) {
		clickNotClickableElement(tableView.getWebElementByColumnAndRow(columnName, ind));
	}

	// sorting view by particular column
	public void clickColumnByColumnName(String columnName) {
		clickNotClickableElement(tableView.getColumnHeader(columnName));
	}

}
