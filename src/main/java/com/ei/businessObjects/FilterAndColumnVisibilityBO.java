package com.ei.businessObjects;

import com.ei.pageObjects.common.enumeration.implementation.AbstractEnum;
import com.ei.pageObjects.common.pages.AddFilterPage;
import com.ei.pageObjects.common.pages.LocalFiltersPage;
import com.ei.pageObjects.common.pages.PresetsPage;
import com.ei.pageObjects.common.pages.SelectColumnPage;
import com.ei.pageObjects.common.pages.TablePage;

import io.qameta.allure.Step;

public class FilterAndColumnVisibilityBO {

	// FILTERS
	public static void addFilter(AbstractEnum myEnum) {
		invokeAddFiltersDialogue();
		new AddFilterPage().checkItem(myEnum).clickSelectButton();
	}

	public static void addFilters(AbstractEnum[] myEnum) {
		invokeAddFiltersDialogue();
		new AddFilterPage().checkItems(myEnum).clickSelectButton();
	}

	public static void removeFilter(AbstractEnum myEnum) {
		invokeAddFiltersDialogue();
		new AddFilterPage().unCheckItem(myEnum).clickSelectButton();
	}

	public static void removeFilters(AbstractEnum[] myEnum) {
		invokeAddFiltersDialogue();
		new AddFilterPage().unCheckItems(myEnum).clickSelectButton();
	}

	public static void resetFilters() {
		new LocalFiltersPage().clickPresetButton();
		new PresetsPage().clickResetFilters();
	}

	public static void resetColumns() {
		TablePage table = new TablePage();
		table.clickTableOptionsGearIcon();
	}

	public static void resetFiltersAndColumns() {
		resetFilters();
		resetColumns();
	}

	public static void addColumn(AbstractEnum myEnum) {
		invokeSelectColumnsDialogue();
		new SelectColumnPage().checkItem(myEnum).clickSelectButton();
	}

	public static void addColumns(AbstractEnum[] myEnum) {
		invokeSelectColumnsDialogue();
		new SelectColumnPage().checkItems(myEnum).clickSelectButton();
	}

	public static void removeColumn(AbstractEnum myEnum) {
		invokeSelectColumnsDialogue();
		new SelectColumnPage().unCheckItem(myEnum).clickSelectButton();
	}

	public static void removeColumns(AbstractEnum[] myEnum) {
		invokeSelectColumnsDialogue();
		new SelectColumnPage().unCheckItems(myEnum).clickSelectButton();
	}

	// PRIVATE methods
	private static void invokeAddFiltersDialogue() {
		LocalFiltersPage filterPage = new LocalFiltersPage();
		filterPage.clickAddFilterButton();
	}

	private static void invokeSelectColumnsDialogue() {
		TablePage table = new TablePage();
		table.selectColumns();
	}

}
