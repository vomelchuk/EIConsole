package com.ei.pageObjects._later;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.ei.pageObjects.BasePage;
import com.ei.pageObjects.HeaderSidebarPage;

public class ExecutablesPage extends HeaderSidebarPage {

	@FindAll(@FindBy(xpath = "//div[contains(@id, 'c:0')]/descendant::span"))
	private List<WebElement> names;

	
	public List<WebElement> getExecutablesNames(){
		return names;
	}

}
