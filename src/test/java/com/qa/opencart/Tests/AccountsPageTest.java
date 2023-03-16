package com.qa.opencart.Tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.util.ElementUtil;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void userLogin() {
		hp.clickMyAccount();
		hp.clicLogin();
		AccPg= lp.userLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

	}
	
	@Test
	public void accountHeadersTitle() {
		String title = AccPg.accountsPageTitle();
		Assert.assertEquals(title,"My Account");

	}

	@Test
	public void accountHeadersListTest() {
		List<String> AccountPageHd = AccPg.getAccountHeaders();
		Assert.assertEquals(AccountPageHd.size(), 4);

	}

}
