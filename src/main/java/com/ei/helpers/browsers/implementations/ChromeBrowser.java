package com.ei.helpers.browsers.implementations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ei.helpers.browsers.WebBrowser;

public class ChromeBrowser implements WebBrowser{
	public WebDriver getBrowserDriver() {
		System.setProperty("webdriver.chrome.driver", "." + "\\drivers\\chromedriver.exe");
		return new ChromeDriver();
	}

}
