package com.ei.pageObjects.common.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.BasePage;
import com.ei.pageObjects.common.enumeration.ElementFindBy;
import com.ei.pageObjects.common.enumeration.MyEnumType;
import com.ei.pageObjects.common.enumeration.implementation.AbstractEnum;

public class AddFilterOrColumnComponent extends BasePage {

	// locators
	@FindBy(xpath = "//label[text()='Enter quick search pattern.']/../..//input")
	protected WebElement txtQuickSearch;
	@FindBy(id = "eid-selector-button-select")
	protected WebElement btnSelect;
	@FindBy(id = "eid-selector-button-cancel")
	protected WebElement btnCancel;

	public String getItemName(AbstractEnum myEnum, MyEnumType enumType) {
		waitForWebElementDisplayed(btnSelect);

		String suffixName = enumType == MyEnumType.COLUMN ? myEnum.getColumnName() : myEnum.getFilterName();
		String xpathValue = "//label[@for='eid-selector-checkbox-" + suffixName
				+ "']/../../div[last()]/descendant::span[last()]";
		return getElementText(driver.findElement(By.xpath(xpathValue)));
	}

	public WebElement getItemCheckBox(AbstractEnum myEnum, MyEnumType enumType) {
		waitForWebElementDisplayed(btnSelect);
		String suffixName = enumType == MyEnumType.COLUMN ? myEnum.getColumnName() : myEnum.getFilterName();
		String xpathValue = "//label[@for='eid-selector-checkbox-" + suffixName + "']/../../div[last()]//label/span";

		return driver.findElement(By.xpath(xpathValue));
	}

	public boolean isItemChecked(AbstractEnum myEnum, MyEnumType enumType) {
		waitForWebElementDisplayed(btnSelect);
		String suffixName = enumType == MyEnumType.COLUMN ? myEnum.getColumnName() : myEnum.getFilterName();
		String xpathValue = "//label[@for='eid-selector-checkbox-" + suffixName
				+ "']/../../div[last()]/div[contains(@class,'checked')]";
		return isWebElementPresent(xpathValue, ElementFindBy.XPATH);
	}

}
