package com.ei.pageObjects.alarms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.MainPage;

import io.qameta.allure.Step;

public class AlarmsPage extends MainPage {
	// fields
	@FindBy(id = "commanding-toolbar-left-button-0")
	WebElement btnMarkAsResolved;
	@FindBy(id = "commanding-toolbar-left-button-1")
	WebElement btnMarkAsUnresolved;
	@FindBy(id = "commanding-toolbar-left-button-2")
	WebElement btnMarkAsPriority;
	@FindBy(id = "commanding-toolbar-right-button-0")
	WebElement btnCreateExclusion;
	@FindBy(id = "commanding-toolbar-right-button-1")
	WebElement btnEditRule;
	
	@Step
	public AlarmsPage clickMarkAsResolvedButton() {
		clickElement(btnMarkAsResolved);
		return this;
	}
	@Step
	public AlarmsPage clickMarkAsUnesolvedButton() {
		clickElement(btnMarkAsUnresolved);
		return this;
	}
	@Step
	public MarkAsPriorityPage clickMarkAsPriorityButton() {
		clickElement(btnMarkAsPriority);
		return new MarkAsPriorityPage();
	}
	
	public boolean isMarkAsResolvedEnabled() {
		return false;
	}
}
