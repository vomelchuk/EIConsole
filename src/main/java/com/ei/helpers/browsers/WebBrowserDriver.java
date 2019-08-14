package com.ei.helpers.browsers;

import org.openqa.selenium.WebDriver;

import com.ei.helpers.browsers.implementations.ChromeBrowser;
import com.ei.helpers.browsers.implementations.FirefoxWebBrowser;
import com.ei.utils.Configuration;

public class WebBrowserDriver {

	private WebBrowser browser;

	public WebBrowserDriver() {
		
		String browserName = Configuration.get("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			this.browser = new ChromeBrowser();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			this.browser = new FirefoxWebBrowser();
		}

	}

	public WebDriver getBrowser() {
		return browser.getBrowserDriver();
	}

}
