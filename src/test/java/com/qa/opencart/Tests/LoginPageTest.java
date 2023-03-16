package com.qa.opencart.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.qa.opencart.basetest.BaseTest;

public class LoginPageTest extends BaseTest {

	@BeforeClass
	public void loginPageSetup() {
		hp.clickMyAccount();
		hp.clicLogin();
	}

	@Test
	public void loginPageTitleTest() {
		String actTitle = lp.loginPageTitle();
		Assert.assertEquals(actTitle, "Account Login");

	}
	
	@Test
	public void userLoginTest() {
		AccPg= lp.userLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(AccPg.accountsPageTitle(), "My Account");
	}
	

}
