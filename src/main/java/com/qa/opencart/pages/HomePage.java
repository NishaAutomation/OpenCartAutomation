package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.util.ElementUtil;

public class HomePage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By MyAccount = By.linkText("My Account");
	private By Login = By.linkText("Login");
	private By searchTextbox = By.xpath("//input[@name='search']");
	private By searchIcon = By.cssSelector(".fa.fa-search");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getHomePageTitle() {
		String hometitle = driver.getTitle();
		System.out.println(hometitle);
		return hometitle;
	}

	public void clickMyAccount() {
		eleUtil.doClick(MyAccount);
	}

	public LoginPage clicLogin() {
		eleUtil.doClick(Login);

		return new LoginPage(driver);
	}

	public boolean searchBoxPresent() {
		boolean SearchPresent = eleUtil.waitForElementVisible(searchTextbox, AppConstants.DEFAULT_MEDIUM_TIMEOUT).isDisplayed();
		System.out.println("Search Box available:-" + SearchPresent);
		return SearchPresent;

	}

	public SearchPage enterSearchValue(String SearchVal) {
		eleUtil.doSendKeys(searchTextbox, SearchVal);
		eleUtil.doClick(searchIcon);
		System.out.println("Entering the search key..." + SearchVal);
		return new SearchPage(driver);

	}

}
