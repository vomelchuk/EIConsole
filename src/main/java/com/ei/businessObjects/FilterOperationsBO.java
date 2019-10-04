package com.ei.businessObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import com.ei.pageObjects.common.enumeration.implementation.AbstractEnum;
import com.ei.pageObjects.common.pages.TablePage;
import com.ei.pageObjects.common.pages.localFilters.types.LocalFilterNumeric;
import com.ei.pageObjects.common.pages.localFilters.types.LocalFilterText;

import io.qameta.allure.Step;

public class FilterOperationsBO {
	@Step
	public static void setTextValue(String value) {
		LocalFilterText filter = new LocalFilterText();
		filter.setValue(value);
	}
	@Step
	public static void clearTextValue() {
		LocalFilterText filter = new LocalFilterText();
		filter.clearValue();
	}
	
	@Step
	public static void setNumberValue(Integer value) {
		LocalFilterNumeric filter = new LocalFilterNumeric();
		filter.setValue(value);
	}
	@Step
	public static void clearNumberValue() {
		LocalFilterNumeric textFilter = new LocalFilterNumeric();
		textFilter.clearValue();
	}

	public static List<String> getFilteredValuesByColumn(AbstractEnum myEnum) {
		List<String> values = new ArrayList<>();
		TablePage table = new TablePage();
		for (WebElement element : table.getWebElementsByColumnName(myEnum)) {
			values.add(element.getText());
		}
		return values;
	}

	public static String getRandomValue(AbstractEnum myEnum) {
		TablePage table = new TablePage();
		int valuesCount = table.getWebElementsByColumnName(myEnum).size();
		int row = (int) (Math.random() * valuesCount);
		String value = table.getWebElementByColumnNameAndRowNumber(myEnum, row).getText();
		return value;
	}

}
