package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.democart.utilis.Constants;

import open.qa.opencart.base.BaseTest;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accountsPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void accountsPageTitleTest() {
		String title = accountPage.getAccountPageTitle();
		System.out.println("acc page title is : " + title);
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Test(priority = 3)
	public void verifyAccSectionsCountTest() {
		Assert.assertTrue(accountPage.getAccountSectionsCount() == Constants.ACCOUNT_SECTIONS_COUNT);
	}

	
	
}
