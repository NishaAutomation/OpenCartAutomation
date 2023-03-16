package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.util.ElementUtil;

public class SearchPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

//	private By searchProduct = By.linkText("Mackbook pro");
	private By searchResults =By.cssSelector("div#content div.product-layout");

	public String searchPageTitle() {

		String title = driver.getTitle();
		return title;
	}

	public int searcProductResultsCount() {
		return eleUtil.waitForMultipleElementsVisble(AppConstants.DEFAULT_MEDIUM_TIMEOUT, searchResults).size();
		
	}
	
	public ProductDetailsPage selectProductOnSearchPage(String prodName) {
		By ProductLocator = By.linkText(prodName);
		eleUtil.waitForElementVisible(ProductLocator, AppConstants.DEFAULT_MEDIUM_TIMEOUT).click();
		System.out.println("Product on search page is clicked.." + prodName);
		
		return new ProductDetailsPage(driver);
	}
}
