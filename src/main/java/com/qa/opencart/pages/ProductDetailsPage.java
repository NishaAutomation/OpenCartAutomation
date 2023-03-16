package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.ElementUtil;

public class ProductDetailsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private By ProductName = By.tagName("h1");

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getProductName() {

		String productNameValue = eleUtil.getText(ProductName);
		System.out.println("Product name is: " + productNameValue);
		return productNameValue;
	}

}