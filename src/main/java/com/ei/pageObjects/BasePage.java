package com.ei.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import com.ei.helpers.DriverPool;
import com.ei.pageObjects.common.enumeration.ElementFindBy;
import com.google.common.base.Function;

public class BasePage {
	/*
	 * @FindBy(xpath = "//div[contains(@class,'ei-progress')]") WebElement progress;
	 */

	@FindBy(xpath = "//div[contains(@class,'Table__dataLoadingBackground')]")
	WebElement loadingBackground;

	public WebDriver driver;

	public BasePage() {
		this.driver = DriverPool.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void waitForWebElementDisplayed(WebElement locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofMillis(200));

		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver drv) {
				try {
					return locator.isDisplayed();
				} catch (NoSuchElementException e) {
					return false;
				}

			}
		});
	}

	public void waitUntilTableLoaded() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofMillis(200));

		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver drv) {
				try {
					return loadingBackground.isDisplayed();
				} catch (StaleElementReferenceException e) {
					return false;
				} catch (NoSuchElementException e) {
					return true;
				}

			}
		});

	}

	public void waitForUnusualElement(ElementFindBy locatorType, String value) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofMillis(200));

		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver drv) {
				if (locatorType == ElementFindBy.ID) {
					return driver.findElement(By.id(value));
				} else if (locatorType == ElementFindBy.XPATH) {
					return driver.findElement(By.xpath(value));
				}
				;
				return null;
			}
		});

	}

	public void clickElement(WebElement elem) {
		waitForWebElementDisplayed(elem);

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofMillis(200));

		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver drv) {
				try {
					elem.click();
					return true;
				} catch (ElementClickInterceptedException e) {
					return false;

				} catch (StaleElementReferenceException e) {
					return false;
				}

			}
		});
		// elem.click();
	}

	public void clickNotClickableElement(WebElement elem) {
		waitForWebElementDisplayed(elem);
		Actions a = new Actions(driver);
		a.moveToElement(elem).click().build().perform();
	}

	public void writeText(WebElement elem, String value) {
		waitForWebElementDisplayed(elem);
		elem.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		elem.sendKeys(value);
	}

	public void writeTextAndHitEnter(WebElement elem, String value) {
		waitForWebElementDisplayed(elem);
		elem.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		elem.sendKeys(value);
		elem.sendKeys(Keys.chord(Keys.RETURN));
	}

	public String getElementText(WebElement elem) {
		waitForWebElementDisplayed(elem);
		return elem.getText();
	}

	public boolean isElementDispayed(WebElement elem) {
		waitForWebElementDisplayed(elem);
		return elem.isDisplayed();
	}

	public boolean isElementChecked(WebElement elem) {
		waitForWebElementDisplayed(elem);
		return elem.isSelected();
	}

	public boolean isElementEnabled(WebElement elem) {
		waitForWebElementDisplayed(elem);
		return elem.isEnabled();
	}

	public boolean isElementPresent(WebElement elem) {
		waitUntilTableLoaded();
		try {
			return elem.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public boolean isWebElementPresent(String locator, Enum<?> mode) {
		// waitUntilTableLoaded();
		try {
			if (mode == ElementFindBy.XPATH) {
				driver.findElement(By.xpath(locator));
			} else if (mode == ElementFindBy.ID) {
				driver.findElement(By.id(locator));
			}
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
