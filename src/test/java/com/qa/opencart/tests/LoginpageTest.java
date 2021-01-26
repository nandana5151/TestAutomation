package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.democart.utilis.Constants;

import open.qa.opencart.base.BaseTest;

public class LoginpageTest extends BaseTest {
	
	@Test(priority =1)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginpageTitle();
		System.out.println("the title of the page is " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void verifyForgotPwdlinkTest() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}
	
	@Test(priority = 3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"
				+ ""));
	}
	
}
