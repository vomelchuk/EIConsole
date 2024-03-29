package com.ei.pageObjects.common.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.ei.pageObjects.BasePage;

import io.qameta.allure.Step;

public class TableOptionsPage extends BasePage {

	@FindBy(xpath = "//div[@id='dropdown-item-0-0-table-menu-item-select']//descendant::div[position()=2]")
	WebElement select;
	@FindBy(xpath = "//div[@id='dropdown-item-0-1-table-menu-item-reset']//descendant::div[position()=2]")
	WebElement reset;

	@Step
	public void clickSelectColumns() {
		clickElement(select);
	}

	@Step
	public void clickResetColumns() {
		clickElement(reset);
	}
}
