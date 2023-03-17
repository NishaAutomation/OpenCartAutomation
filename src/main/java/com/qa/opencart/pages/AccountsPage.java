package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By accountHeaders = By.xpath("//div[@id='content']//h2");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String accountsPageTitle() {

		String accTitle = driver.getTitle();
		System.out.println("Accounts page title is: " + accTitle);
		return accTitle;
	}

	public List<String> getAccountHeaders() {
		List<WebElement> accountHeadersList = eleUtil.waitForMultipleElementsVisble(10, accountHeaders);
		List<String> actualHeaders = new ArrayList<String>();

		for (WebElement e : accountHeadersList) {
			String text = e.getText();
			actualHeaders.add(text);
			System.out.println("actualHeaders are:" + actualHeaders);
		}
		return actualHeaders;

	}
}
