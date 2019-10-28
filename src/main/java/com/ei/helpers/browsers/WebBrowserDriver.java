package com.ei.helpers.browsers;

import org.openqa.selenium.WebDriver;

import com.ei.helpers.browsers.implementations.Browser;
import com.ei.helpers.browsers.implementations.ChromeBrowser;
import com.ei.helpers.browsers.implementations.FirefoxBrowser;
import com.ei.utils.Configuration;

public class WebBrowserDriver {

	private WebBrowser browser;

	public WebBrowserDriver() {

		String browserName = Configuration.get("browser").toUpperCase();

		switch (Browser.valueOf(browserName)) {
		case CHROME:
			this.browser = new ChromeBrowser();
			break;
		case FIREFOX:
			this.browser = new FirefoxBrowser();
			break;
		}

	}

	public WebDriver getBrowser() {
		return browser.getBrowserDriver();
	}

}
