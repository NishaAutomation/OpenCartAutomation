package com.qa.opencart.basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductDetailsPage;
import com.qa.opencart.pages.SearchPage;

public class BaseTest {

	private WebDriver driver;
	DriverFactory df;
	protected Properties prop;
	protected HomePage hp;
	protected LoginPage lp;
	protected AccountsPage AccPg;
	protected SearchPage search;
	protected ProductDetailsPage PDP;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		AccPg = new AccountsPage(driver);
		search = new SearchPage(driver);
		PDP = new ProductDetailsPage(driver);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
