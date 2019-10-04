package com.ei.pageObjects.common.pages.localFilters.types;

import org.openqa.selenium.By;

import com.ei.pageObjects.BasePage;

import com.ei.pageObjects.common.enumeration.ElementFindBy;
import com.ei.pageObjects.common.enumeration.implementation.AbstractEnum;

public class BaseLocalFilter extends BasePage {
	
	private String prefixClose = "eid-local-filter-close-";
	//private String prefixLabel = "//label[@id='eid-local-filter-label-systemProcessId']";
	
	public void close(AbstractEnum myEnum) {
		waitUntilTableLoaded();
		String idValue = prefixClose + myEnum.getFilterName();
		clickElement(driver.findElement(By.id(idValue)));
	}
	
	public boolean isFilterPresent(AbstractEnum myEnum) {
		waitUntilTableLoaded();
		String idValue = prefixClose + myEnum.getFilterName();
		return isWebElementPresent(idValue, ElementFindBy.ID);
	}

}
