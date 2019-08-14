package com.ei.pageObjects.common.component;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ei.pageObjects.common.pages.AddFilterOrColumnPage;

public class AddFilterOrColumnComponent extends AddFilterOrColumnPage {

	// private List<? extends Enum<?>> filters;
	// private String[] filterLabels;
	// Map<>
	/*
	 * public AddFilterOrColumnComponent(WebDriver driver, List<? extends Enum<?>>
	 * filters) { super(driver); //this.filters = filters; }
	 */
	// methods

	public String getItemName(String filterName) {
		String xpathValue = "//label[@for='eid-selector-checkbox-" + filterName
				+ "']/../../div[last()]/descendant::span[last()]";
		return getElementText(driver.findElement(By.xpath(xpathValue)));
	}

	public WebElement getItemCheckBox(String filterName) {
		String xpathValue = "//label[@for='eid-selector-checkbox-" + filterName + "']/../../div[last()]//label/span";
		return driver.findElement(By.xpath(xpathValue));
	}

	public boolean isItemChosen(String filterName) {

		String xpathValue = "//label[@for='eid-selector-checkbox-" + filterName
				+ "']/../../div[last()]/div[contains(@class,'checked')]";

		try {
			driver.findElement(By.xpath(xpathValue));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

}
