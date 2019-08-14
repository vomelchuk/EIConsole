package com.ei.pageObjects.common.localFilter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.BasePage;

public class TextLocalFilter extends BasePage {
	@FindBy(xpath = "//input[@class='local-filter-input-text']")
	WebElement txtText;
}
