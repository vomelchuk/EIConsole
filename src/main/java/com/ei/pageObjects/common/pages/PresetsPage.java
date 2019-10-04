package com.ei.pageObjects.common.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.BasePage;

import io.qameta.allure.Step;

public class PresetsPage extends BasePage {
	@FindBy(xpath = "//div[@id='dropdown-item-0-1-presets-action-1']//div[position()=2]")
	WebElement reset;
	@Step
	public void clickResetFilters() {
		clickElement(reset);
	}

}
