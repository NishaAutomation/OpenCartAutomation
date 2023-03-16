package com.qa.opencart.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;

public class SearchPageTest extends BaseTest {
//	
//	@BeforeClass
//	public void searchPageSetup() {
//		
//	}

	@Test(priority = 1)
	public void searchBoxPresentText() {
		boolean box = hp.searchBoxPresent();
		Assert.assertTrue(box);

	}

	@Test(priority = 3)
	public void searchResultCountTest() {
		int ProductCount = search.searcProductResultsCount();
		System.out.println("Search Product count = " + ProductCount);
		Assert.assertEquals(ProductCount, 3);

	}

	@Test(priority = 2)
	public void enterSearchValueTest() {
		hp.enterSearchValue("Macbook");

	}

	@Test(priority = 4)
	public void searchProductTest() {
		
		if (search.searcProductResultsCount() > 0) {
			PDP = search.selectProductOnSearchPage("MacBook Pro");
		}
		String actualVal = PDP.getProductName();
		Assert.assertEquals(actualVal, "MacBook Pro");
	}
}
