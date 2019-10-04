package com.ei.pageObjects.alarms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.BasePage;

import io.qameta.allure.Step;

public class MarkAsPriorityPage extends BasePage {

	@FindBy(id = "dropdown-item-0-0-dropdown-command-0-0")
	WebElement priority1;

	@FindBy(id = "dropdown-item-0-1-dropdown-command-0-1")
	WebElement priority2;

	@FindBy(id = "dropdown-item-0-2-dropdown-command-0-2")
	WebElement priority3;

	@FindBy(id = "dropdown-item-1-0-dropdown-command-1-0")
	WebElement priority0;

	@Step
	public void setAsPriority1() {
		clickElement(priority1);
	}

	@Step
	public void setAsPriority2() {
		clickElement(priority2);
	}

	@Step
	public void setAsPriority3() {
		clickElement(priority3);
	}

	@Step
	public void setAsNoPriority() {
		clickElement(priority0);
	}
}
