package com.ei.pageObjects.common.pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.common.component.TableComponent;
import com.ei.pageObjects.common.enumeration.implementation.AbstractEnum;

import io.qameta.allure.Step;

public class TablePage extends TableComponent {

	// @FindBy(xpath =
	// "//span[@id='ei-complex-table-TableHeaderDropdown']/preceding-sibling::*")
	@FindBy(xpath = "//span[@id='ei-complex-table-TableHeaderDropdown']/..")
	WebElement tableGear;

	private TableOptionsPage tableOptions;

	@Step
	public void clickTableOptionsGearIcon() {
		clickElement(tableGear);
		tableOptions = new TableOptionsPage();
		tableOptions.clickResetColumns();
	}

	public void selectColumns() {
		clickElement(tableGear);
		tableOptions = new TableOptionsPage();
		tableOptions.clickSelectColumns();
	}

	@Step
	public void clickTableHeaderByColumnName(AbstractEnum myEnum) {
		waitUntilTableLoaded();
		WebElement header = getTableHeaderByColumnName(myEnum);

		int attempts = 10;
		while (attempts != 0) {
			try {
				header.click();
				break;
			} catch (StaleElementReferenceException e) {
				header = getTableHeaderByColumnName(myEnum);
				attempts--;
			} catch (ElementClickInterceptedException e) {
				attempts--;
			}
		}
		// clickElement(header);
	}

	/*
	 * public void scrollToLastElement(WebElement el) { JavascriptExecutor js =
	 * (JavascriptExecutor) driver;
	 * js.executeScript("arguments[0].scrollIntoView();", el); }
	 * 
	 */
}
