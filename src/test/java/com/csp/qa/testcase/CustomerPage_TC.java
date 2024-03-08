package com.csp.qa.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.csp.qa.base.TestBase;
import com.csp.qa.pages.CustomerLoginPage;
import com.csp.qa.pages.CustomerPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// CustomersPage_Test class represents the test cases for CustomersPage functionality
public class CustomerPage_TC extends TestBase {
	CustomerLoginPage loginPage;
	CustomerPage customersPage;
	String Customers_username = prop.getProperty("Customers_username");

	public CustomerPage_TC() {
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
		customersPage = loginPage.ManagerLogin2();
	}

	// Test case for deleting a customer entry
	@Test(priority = 1)
	public void DeleteCustomerEntry() throws InterruptedException {
		// Call the DeleteEntry method from CustomersPage to delete a customer
		customersPage.DeleteEntry(Customers_username);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
