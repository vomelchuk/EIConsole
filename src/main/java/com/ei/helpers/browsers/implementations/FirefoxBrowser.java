package com.ei.helpers.browsers.implementations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ei.helpers.browsers.WebBrowser;

public class FirefoxBrowser implements WebBrowser {

	public WebDriver getBrowserDriver() {
		System.setProperty("webdriver.gecko.driver", "." + "\\drivers\\geckodriver.exe");
		return new FirefoxDriver();
	}

}
