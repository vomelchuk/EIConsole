package com.ei.pageObjects.common.pages;

import com.ei.pageObjects.common.enumeration.MyEnumType;
import com.ei.pageObjects.common.enumeration.implementation.AbstractEnum;

import io.qameta.allure.Step;

public class AddFilterPage extends AddFilterOrColumnPage {

	public AddFilterPage checkItem(AbstractEnum myEnum) {

		if (!isItemChecked(myEnum, MyEnumType.FILTER)) {
			clickItem(myEnum);
		}
		return this;

	}

	public AddFilterPage checkItems(AbstractEnum[] myEnum) {
		for (AbstractEnum item : myEnum) {
			checkItem(item);
		}
		return this;
	}

	@Step
	public AddFilterPage unCheckItem(AbstractEnum myEnum) {
		if (isItemChecked(myEnum, MyEnumType.FILTER)) {
			clickItem(myEnum);
		}
		return this;

	}

	@Step
	public AddFilterPage unCheckItems(AbstractEnum[] myEnum) {
		for (AbstractEnum item : myEnum) {
			System.out.println(item + " - will being unchecked");
			unCheckItem(item);
		}
		return this;
	}

	private void clickItem(AbstractEnum myEnum) {
		clickElement(getItemCheckBox(myEnum, MyEnumType.FILTER));
	}
}
