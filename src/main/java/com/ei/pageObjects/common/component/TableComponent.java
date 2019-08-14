package com.ei.pageObjects.common.component;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.BasePage;
import com.ei.pageObjects.common.enumeration.CustomItems;
import com.ei.pageObjects.common.pages.TableOptionsPage;

public class TableComponent extends BasePage {
	
	//div[@id='severity']/descendant::*[@class='sort-arrow-up']
	//div[@id='severity']/descendant::*[@class='sort-arrow-down']
	//input9@id='react-select-2-input'] 	Alarms groupping
	//input9@id='react-select-3-input'] 	Scripts groupping 

	private List<? extends CustomItems> columnNames;
	TableOptionsPage tableOptions;
	@FindBy(xpath = "//span[@id='ei-complex-table-TableHeaderDropdown']/preceding-sibling::*")
	WebElement tableGear;

	public TableComponent(List<? extends CustomItems> columns) {
		this.columnNames = columns;
	}

	public void resetColumns() {
		clickNotClickableElement(tableGear);
		tableOptions = new TableOptionsPage();
		tableOptions.clickResetColumns();
	}

	public void selectColumns() {
		clickNotClickableElement(tableGear);
		tableOptions = new TableOptionsPage();
		tableOptions.clickSelectColumns();
	}

	public List<WebElement> getWebElementsByColumnName(String columnName) {
		List<WebElement> columnValues = new ArrayList<WebElement>();
		waitUntilTableLoaded();
		for (CustomItems item : columnNames) {
			if (columnName.equalsIgnoreCase(item.toString())) {
				String xpathValue = "//div[contains(@id, 'c:" + item.getIndex() + "')]/descendant::span[last()]";
				columnValues = driver.findElements(By.xpath(xpathValue));
			}
		}
		return columnValues;
	}

	public WebElement getWebElementByColumnAndRow(String columnName, int row) {
		waitUntilTableLoaded();
		WebElement element = null;
		for (CustomItems item : columnNames) {
			if (columnName.equalsIgnoreCase(item.toString())) {
				String xpathValue = "//div[contains(@id, 'r:" + row + ", c:" + item.getIndex() + "')]";
				element = driver.findElement(By.xpath(xpathValue));
			}
		}
		return element;
	}

	public WebElement getColumnHeader(String columnName) {
		waitUntilTableLoaded();
		return driver.findElement(By.id(columnName));
	}

}
