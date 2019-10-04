package com.ei.pageObjects.common.pages;

import com.ei.pageObjects.common.enumeration.MyEnumType;
import com.ei.pageObjects.common.enumeration.implementation.AbstractEnum;

import io.qameta.allure.Step;

public class AddFilterPage extends AddFilterOrColumnPage {

	public AddFilterOrColumnPage checkItem(AbstractEnum myEnum) {

		if (!isItemChecked(myEnum, MyEnumType.FILTER)) {
			clickItem(myEnum);
		}
		return this;

	}

	public AddFilterOrColumnPage checkItems(AbstractEnum[] myEnum) {
		for (AbstractEnum item : myEnum) {
			checkItem(item);
		}
		return this;
	}

	@Step
	public AddFilterOrColumnPage unCheckItem(AbstractEnum myEnum) {
		if (isItemChecked(myEnum, MyEnumType.FILTER)) {
			clickItem(myEnum);
		}
		return this;

	}

	@Step
	public AddFilterOrColumnPage unCheckItems(AbstractEnum[] myEnum) {
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
