package com.csp.qa.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.csp.qa.base.TestBase;
import com.csp.qa.pages.AddCustomerPage;
import com.csp.qa.pages.BankManagerLoginPage;

public class BankManagerLogin_TC extends TestBase {
	BankManagerLoginPage bankManagerPage;

	public BankManagerLogin_TC() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		try {
			bankManagerPage = new BankManagerLoginPage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testBankManagerLogin() {
		// Perform Bank Manager Login
		AddCustomerPage accountPage = bankManagerPage.ManagerLogin();
		try {
			Thread.sleep(3000); // 3 seconds sleep
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Assertions
		Assert.assertNotNull(accountPage, "Bank Manager Login failed or did not navigate to the expected page.");
		// Add more assertions based on the expected behavior after Bank Manager Login
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
