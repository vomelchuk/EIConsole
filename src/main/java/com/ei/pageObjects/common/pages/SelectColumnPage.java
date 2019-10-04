package com.ei.pageObjects.common.pages;

import com.ei.pageObjects.common.enumeration.MyEnumType;
import com.ei.pageObjects.common.enumeration.implementation.AbstractEnum;

import io.qameta.allure.Step;

public class SelectColumnPage extends AddFilterOrColumnPage {
	@Step
	public SelectColumnPage checkItem(AbstractEnum myEnum) {

		if (!isItemChecked(myEnum, MyEnumType.COLUMN)) {
			clickItem(myEnum);
		}
		return this;

	}

	@Step
	public SelectColumnPage checkItems(AbstractEnum[] myEnum) {
		for (AbstractEnum item : myEnum) {
			checkItem(item);
		}
		return this;
	}

	@Step
	public SelectColumnPage unCheckItem(AbstractEnum myEnum) {
		if (isItemChecked(myEnum, MyEnumType.COLUMN)) {
			clickItem(myEnum);
		}
		return this;

	}

	@Step
	public SelectColumnPage unCheckItems(AbstractEnum[] myEnum) {
		for (AbstractEnum item : myEnum) {
			System.out.println(item + " - will being unchecked");
			unCheckItem(item);
		}
		return this;
	}

	private void clickItem(AbstractEnum myEnum) {
		clickElement(getItemCheckBox(myEnum, MyEnumType.COLUMN));
	}
}
