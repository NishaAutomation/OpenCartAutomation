package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.util.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By LoginBtn= By.xpath("//input[@value='Login']");
	private By emailid= By.cssSelector("#input-email");
	private By password= By.cssSelector("#input-password");
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}

	
	public String loginPageTitle() {
		
		String LpTitle=driver.getTitle();
		System.out.println(LpTitle);
		return LpTitle;
	}
	
	public AccountsPage userLogin(String un, String pw) {
		
		System.out.println("Your user name and password:" + un + pw);
		
		eleUtil.waitForElementVisible(emailid, AppConstants.DEFAULT_MEDIUM_TIMEOUT).sendKeys(un);
		eleUtil.doSendKeys(password, pw);
		eleUtil.doClick(LoginBtn);
		System.out.println("Logged in successfully....");
		return new AccountsPage(driver);
		
	}
	
	
}
