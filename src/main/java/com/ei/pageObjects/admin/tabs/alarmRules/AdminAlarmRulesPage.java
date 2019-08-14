package com.ei.pageObjects.admin.tabs.alarmRules;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.admin.AdminPage;
import com.ei.pageObjects.common.component.TableComponent;
import com.ei.pageObjects.common.enumeration.column.AdminRulesColumns;
import com.ei.pageObjects.common.localFilter.LocalFiltersPanelWithSeverities;

public class AdminAlarmRulesPage extends AdminPage {

	LocalFiltersPanelWithSeverities localFilters;
	TableComponent tabledata;
	@FindBy(id = "commanding-toolbar-left-button-0")
	WebElement btnNewRule;
	@FindBy(id = "commanding-toolbar-left-button-1")
	WebElement btnEnable;
	@FindBy(id = "commanding-toolbar-left-button-2")
	WebElement btnDisable;
	@FindBy(id = "commanding-toolbar-left-button-3")
	WebElement btnDelete;
	@FindBy(id = "commanding-toolbar-left-button-4")
	WebElement btnSaveAs;
	@FindBy(id = "commanding-toolbar-right-button-0")
	WebElement btnCreateExclusion;
	@FindBy(id = "commanding-toolbar-right-button-1")
	WebElement btnRerunRules;
	@FindBy(id = "commanding-toolbar-right-button-2")
	WebElement btnExport;

	public AdminAlarmRulesPage() {
		localFilters = new LocalFiltersPanelWithSeverities();
		tabledata = new TableComponent(Arrays.asList(AdminRulesColumns.values()));
	}

	public AdminAlalrmRulesSelectColumnsPage getAddFilterPage() {
		localFilters.clickAddFilterButton();
		return new AdminAlalrmRulesSelectColumnsPage(driver);
	}

	public List<WebElement> getAllColumnValuesBy(String columnName) {
		return tabledata.getWebElementsByColumnName(columnName);
	}

	public void clickTableElement(String columnName, int row) {
		clickNotClickableElement(tabledata.getWebElementByColumnAndRow(columnName, row));
	}
	public void clickColumnByColumnName(String columnName) {
		clickNotClickableElement(tabledata.getColumnHeader(columnName));
	}
}
