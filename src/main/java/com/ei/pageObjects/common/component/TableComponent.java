package com.ei.pageObjects.common.component;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.ei.pageObjects.BasePage;
import com.ei.pageObjects.common.enumeration.ElementFindBy;
import com.ei.pageObjects.common.enumeration.SortingMode;
import com.ei.pageObjects.common.enumeration.implementation.AbstractEnum;

public class TableComponent extends BasePage {

	public WebElement getTableHeaderByColumnName(AbstractEnum myEnum) {
//		waitUntilTableLoaded();
		waitForUnusualElement(ElementFindBy.ID, myEnum.getColumnName());
		return driver.findElement(By.id(myEnum.getColumnName()));
	}

	public SortingMode getColumnSortingStatus(AbstractEnum myEnum) {
		waitUntilTableLoaded();
		String up = "//div[@id='" + myEnum.getColumnName() + "']/descendant::*[@class='sort-arrow-up']";
		String down = "//div[@id='" + myEnum.getColumnName() + "']/descendant::*[@class='sort-arrow-down']";
		if (isWebElementPresent(up, ElementFindBy.XPATH)) {
			return SortingMode.ASCEND;
		} else if (isWebElementPresent(down, ElementFindBy.XPATH)) {
			return SortingMode.DESCEND;
		}
		return SortingMode.UNSORTED;
	}

	public List<WebElement> getWebElementsByColumnName(AbstractEnum myEnum) {
		waitUntilTableLoaded();
		String xpathValue = "//div[contains(@id, 'c:" + myEnum.getColumnIndex() + "')]/descendant::span[last()]";
//		waitForUnusualElement(ElementFindBy.XPATH, xpathValue);
		return driver.findElements(By.xpath(xpathValue));
	}

	public WebElement getWebElementByColumnNameAndRowNumber(AbstractEnum myEnum, int rowNumber) {
//		waitUntilTableLoaded();
		WebElement element = null;
		String xpathValue = "//div[contains(@id, 'r:" + rowNumber + ", c:" + myEnum.getColumnIndex() + "')]";
		waitForUnusualElement(ElementFindBy.XPATH, xpathValue);
		element = driver.findElement(By.xpath(xpathValue));
		return element;
	}

	public int getCountOfReturnedRows() {
		waitUntilTableLoaded();
		String xpathValue = "//input[contains(@id,'checkbox_id:')]";
		List<WebElement> rows = driver.findElements(By.xpath(xpathValue));
		return rows.size() - 1;
	}

}
