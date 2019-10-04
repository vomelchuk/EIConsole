package com.ei.pageObjects.admin.hashes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.admin.AdminPage;

public class AdminBlockedHashesPage extends AdminPage {
	@FindBy(id = "commanding-toolbar-left-button-0")
	WebElement btnAddHashes;
	@FindBy(id = "commanding-toolbar-left-button-1")
	WebElement btnUnblock;
	@FindBy(id = "commanding-toolbar-left-button-2")
	WebElement btnCleanAndQuarantine;


}
