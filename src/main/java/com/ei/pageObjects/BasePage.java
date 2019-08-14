package com.ei.pageObjects;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.ei.helpers.DriverPool;
import com.google.common.base.Function;

public class BasePage {

	@FindBy(xpath = "//div[contains(@class,'ei-progress')]")
	WebElement progress;

	public WebDriver driver;

	public BasePage() {
		this.driver = DriverPool.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void waitForWebElementDisplayed(WebElement locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver drv) {
				return locator.isDisplayed();
			}
		});
	}

	// ---------------------
	public void waitUntilTableLoaded() {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofMillis(100));

		// long startTime = System.currentTimeMillis();
		// wait.until(ExpectedConditions.invisibilityOf(progress));

		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver drv) {

				try {
					 //System.out.println("Try: " + progress);
					return progress.isDisplayed();
				} catch (StaleElementReferenceException e) {
					 //System.out.println("Catch StaleElement: " + progress);
					return false;
				} catch (NoSuchElementException e) {
					 //System.out.println("Catch NoSuchElement: " + progress);
					return true;
				}

			}
		});

		/*
		 * wait.until(new Function<WebDriver, Boolean>() { public Boolean
		 * apply(WebDriver drv) { // return !progress.isDisplayed(); //
		 * System.out.println(progress); long currentTime = System.currentTimeMillis();
		 * 
		 * if (currentTime < (startTime + 400)) { return !progress.isDisplayed(); } else
		 * { return true; }
		 * 
		 * } });
		 */
	}

	public void clickElement(WebElement elem) {
		waitForWebElementDisplayed(elem);

		/*
		 * while (true) { try { elem.click(); break; } catch
		 * (ElementClickInterceptedException e) {
		 * System.out.println("Element click EXCPTION intercepted");
		 * 
		 * } catch (StaleElementReferenceException e) {
		 * System.out.println("Element click EXCPTION stale"); } }
		 */
		elem.click();
	}

	public void clickNotClickableElement(WebElement elem) {
		waitForWebElementDisplayed(elem);
		/*
		 * JavascriptExecutor jse = (JavascriptExecutor)driver;
		 * 
		 * jse.executeScript("arguments[0].scrollIntoView()", elem);
		 */
		Actions a = new Actions(driver);
		a.moveToElement(elem).click().build().perform();
	}

	public void writeText(WebElement elem, String text) {
		waitForWebElementDisplayed(elem);
		elem.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		elem.sendKeys(text);
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
		// waitForWebElementDisplayed(elem);
		try {
			return elem.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public String getTitle() {
		return driver.getTitle();
	}

}
