
package com.csp.qa.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.csp.qa.base.TestBase;
import com.csp.qa.pages.WithdrawlPage;
import com.csp.qa.pages.AddCustomerPage;
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

// AddCustomerPage_Test class represents the test cases for AddCustomerPage functionality
public class AddCustomerPage_TC extends TestBase {
	CustomerLoginPage loginPage;
	WithdrawlPage accountPage;
	AddCustomerPage addCustomerPage;
	String AccountexistUser = prop.getProperty("AccontExistUser");
	String fname = prop.getProperty("fname");
	String lname = prop.getProperty("Lname");
	String postcode = prop.getProperty("postcode");
	String message_AddCustomer = prop.getProperty("message_AddCustomer");
	String message_AddCustomer_Exist = prop.getProperty("message_AddCustomer_Exist");

	public AddCustomerPage_TC() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		try {
			loginPage = new CustomerLoginPage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		addCustomerPage = loginPage.ManagerLogin();
	}

	// Test cases for AddCustomerPage functionality

	@Test(priority = 1)
	public void AddCustomer_NotExist() throws InterruptedException {
		// Add a customer and validate the alert message
		addCustomerPage.AddCustomer(fname, lname, postcode);
		String result = addCustomerPage.getAlertMessageText();
		String actualText = result;
		String expectedPartialText = message_AddCustomer;
		// Assertion using assertContains (custom assertion method)
		addCustomerPage.assertContains(actualText, expectedPartialText);
		addCustomerPage.getAlert();
	}

	@Test(priority = 2, dependsOnMethods = "AddCustomer_NotExist")
	public void AddCustomer_Exist() throws InterruptedException {
		// Add an existing customer and validate the alert message
		addCustomerPage.AddCustomer(fname, lname, postcode);
		addCustomerPage.getAlert();
		Thread.sleep(1000);
		addCustomerPage.AddCustomer(fname, lname, postcode);
		String result2 = addCustomerPage.getAlertMessageText();
		AssertJUnit.assertEquals(result2, message_AddCustomer_Exist);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
