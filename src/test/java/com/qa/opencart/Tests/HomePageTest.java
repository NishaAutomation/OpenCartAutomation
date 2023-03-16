package com.qa.opencart.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
 

import com.qa.opencart.basetest.BaseTest;

 

  public class HomePageTest extends BaseTest {
	  
	@Test
	public void homePageTitle() {
		
		String actualTitle= hp.getHomePageTitle();
		Assert.assertEquals(actualTitle, "Your Store");
	}
	  
	  
	@Test
	public void loginClickTest() {
		hp.clickMyAccount();
		hp.clicLogin();
	}
	
	@Test
	public void searchValTest() {
		hp.enterSearchValue("Macbook pro");
	}
	
}
