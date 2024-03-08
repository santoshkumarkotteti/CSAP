package com.csp.qa.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.csp.qa.base.TestBase;
import com.csp.qa.pages.WithdrawlPage;
import com.csp.qa.pages.CustomerLoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// CustomerLogin_Test class represents the test cases for customer login functionality
public class CustomerLoginPage_TC extends TestBase {
	CustomerLoginPage loginPage;
	WithdrawlPage accountPage;
	String AccountexistUser = prop.getProperty("AccontExistUser");
	String AccountNot_existUser = prop.getProperty("AccontNot_ExistUser");

	public CustomerLoginPage_TC() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new CustomerLoginPage();
		accountPage = new WithdrawlPage();
	}

	// Test case for customer login with existing user
	@Test(priority = 1)
	public void customerlogin() {
		loginPage.CustomerLogin(AccountexistUser);
		// Verify that the logged-in customer name matches the expected user
		String name = accountPage.verifyCustomerName();
		AssertJUnit.assertEquals(AccountexistUser, name);
	}

	// Uncomment the following test case if needed for handling non-existing user
	// login
	/*
	 * @Test(priority=2) public void customerlogin_Not_Exist() {
	 * loginPage.CustomerLogin(AccountNot_existUser); }
	 */

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
