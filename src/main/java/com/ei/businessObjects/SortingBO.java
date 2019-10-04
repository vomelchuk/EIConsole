package com.ei.businessObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.ei.pageObjects.common.enumeration.implementation.AbstractEnum;
import com.ei.pageObjects.common.pages.LocalFiltersPage;
import com.ei.pageObjects.common.pages.TablePage;

import io.qameta.allure.Step;

public class SortingBO {

	public static void sortTableByColumn(AbstractEnum myEnum, Enum<?> sortMode) {

		TablePage table = new TablePage();
		while (table.getColumnSortingStatus(myEnum) != sortMode) {
			table.clickTableHeaderByColumnName(myEnum);
		}

	}

	public static List<String> getColumnValues(AbstractEnum myEnum) {

		List<String> values = new ArrayList<>();
		TablePage table = new TablePage();
		List<WebElement> elems = table.getWebElementsByColumnName(myEnum);
		for (WebElement elem : elems) {
			values.add(elem.getText());
		}
		return values;
	}

	public static String getViewName() {
		LocalFiltersPage local = new LocalFiltersPage();
		return local.getPageName();
	}

}
