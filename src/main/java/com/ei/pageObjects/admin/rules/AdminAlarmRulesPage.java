package com.ei.pageObjects.admin.rules;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.admin.AdminPage;
import com.ei.pageObjects.common.component.TableComponent;

import com.ei.pageObjects.common.pages.localFilters.AlarmRulesLocalFiltersPage;

public class AdminAlarmRulesPage extends AdminPage {

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
	
	

}
