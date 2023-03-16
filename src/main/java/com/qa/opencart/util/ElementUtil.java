package com.qa.opencart.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.factory.DriverFactory;

public class ElementUtil {

	private WebDriver driver;
	private JavaScriptUtil jsUtil;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jsUtil = new JavaScriptUtil(driver);
	}

	public WebElement getElement(By Locator) {
		WebElement element = driver.findElement(Locator);
		
		if(Boolean.parseBoolean(DriverFactory.highlight)) {
		jsUtil.flash(element);
		}
		return element;
	}

	public WebElement getElement(By Locator, int timeout) {
		return waitForElementPresence(Locator, timeout);
	}

	public List<WebElement> getElements(By Locator) {
		return driver.findElements(Locator);
	}

	public void doSendKeys(By Locator, String value) {
		WebElement element=getElement(Locator);
		element.clear();
		element.sendKeys(value);
	}

	public void doClick(By Locator) {
		getElement(Locator).click();
	}

	public List<WebElement> getByTagName(By locator) {

		List<WebElement> TagName = driver.findElements(locator);
		return TagName;
	}

	public String getText(By locator) {
		return getElement(locator).getText();
	}

	public boolean isDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public void getElementAttribute(By Locator, String atr) {
		List<WebElement> ListsAttr = getElements(Locator);
		for (WebElement e : ListsAttr) {
			String AttrVal = e.getAttribute(atr);
			System.out.println(AttrVal);

		}
	}

	public List<String> GetETextFromPageSection(By Locator) {
		List<String> TextList = new ArrayList<String>();
		List<WebElement> LeftList = getElements(Locator);
		for (WebElement e : LeftList) {
			String Text = e.getText();
			TextList.add(Text);
			// System.out.println(Text);
		}
		return TextList;
	}

	// ******************Select Based Dropdown Util********************

	public void SelectByIndexFromDropDown(By Locator, int value) {

		Select select = new Select(getElement(Locator));
		select.selectByIndex(value);
	}

	public void SelectByValueFromDropDown(By Locator, String value) {

		Select select = new Select(getElement(Locator));
		select.selectByValue(value);
	}

	public void SelectByVisibleTextFromDropDown(By Locator, String value) {

		Select select = new Select(getElement(Locator));
		select.selectByVisibleText(value);
	}

	public List<WebElement> GetDropDownOptionsList(By Locator) {

		Select select = new Select(getElement(Locator));
		return select.getOptions();
	}

	public int GetOptionListCount(By Locator) {

		return GetDropDownOptionsList(Locator).size();
	}

	public List<String> GetDropDownOptionsText(By Locator) {
		List<String> optionsTextList = new ArrayList<String>();
		List<WebElement> optionsList = GetDropDownOptionsList(Locator);
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			optionsTextList.add(text);
		}
		return optionsTextList;
	}

	public void SelectDropdownValue(By Locator, String Value) {
		List<WebElement> optionslist = GetDropDownOptionsList(Locator);
		for (WebElement e : optionslist) {
			String text = e.getText();
			if (text.contains(Value)) {
				e.click();
				System.out.println("Selected the value " + Value);
				break;
			}
		}

	}

	// **********************Wait Utils***************************

	public WebElement waitForElementPresence(By Locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(Locator));

	}

	public WebElement waitForElementVisible(By Locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));

	}

	public Alert waitForJSAlertPresnence(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());

	}

	public String getAlertText(int timeout) {
		return waitForJSAlertPresnence(timeout).getText();
	}

	public void accpetAlert(int timeout) {
		waitForJSAlertPresnence(timeout).accept();
	}

	public void dimissAlert(int timeout) {
		waitForJSAlertPresnence(timeout).dismiss();
	}

	public void alertSendkeys(int timeout, String value) {
		waitForJSAlertPresnence(timeout).sendKeys(value);
	}

	public boolean waitForURLContains(int timeout, String FractionVal) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		System.out.println(driver.getCurrentUrl());
		return wait.until(ExpectedConditions.urlContains(FractionVal));

	}

	public boolean waitForTitleContains(int timeout, String FractionVal) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		System.out.println(driver.getTitle());
		return wait.until(ExpectedConditions.titleContains(FractionVal));

	}

	public List<WebElement> waitForMultipleElementsPresence(int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

	}

	public List<WebElement> waitForMultipleElementsVisble(int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}

	public void waitForframesAndSwitchToItByIDorName(int timeout, String IdorName) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IdorName));
	}

	public void waitForframesAndSwitchToItByIndex(int timeout, int frameindex) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameindex));
	}

	public void WaitAndclick(int timeout, By Locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Locator));
	}
}
