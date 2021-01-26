package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.democart.utilis.Constants;
import com.qa.democart.utilis.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
		
	//page by locators or Page Object Repoistory
	private By emailid =By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.cssSelector("input[value='Login']");
	private By forgotPwdLinks = By.linkText("Forgotten Password");
	

	
	
	//page class constructors
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	  elementUtil = new ElementUtil(driver);
	}
	
	
	//page actions or methods
	public String getLoginpageTitle() {
		return elementUtil.waitForTitleToBe(Constants.LOGIN_PAGE_TITLE, 5);
	}
	
	public boolean isForgotPasswordLinkExist() {
		if (elementUtil.getElements(forgotPwdLinks).size()== Constants.FORGOTTEN_PWD_LINK_COUNT)
			return true;
		return false;
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with username " +un + "and password "+ pwd);
		
		elementUtil.doSendKeys(emailid, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		
		return new AccountsPage(driver);
	}
	
}