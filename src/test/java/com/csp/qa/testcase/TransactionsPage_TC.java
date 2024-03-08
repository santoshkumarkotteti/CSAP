package com.csp.qa.testcase;


	

	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.Test;

import com.csp.qa.base.TestBase;
import com.csp.qa.pages.CustomerLoginPage;
import com.csp.qa.pages.TransactionsPage;

import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.Test;
	import org.testng.annotations.BeforeMethod;
	import java.io.IOException;

	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	
	// CustomerTransactionPage_Test class represents the test cases for CustomerTransactionPage functionality
	public class TransactionsPage_TC extends TestBase {
	    CustomerLoginPage loginPage;
	    TransactionsPage customerTransactionPage;

	    // Test data from configuration file
	    String date = prop.getProperty("ValidationDate");
	    String Startdate = prop.getProperty("StartDate");
	    String Enddate = prop.getProperty("EndDate");
	    String AccountexistUser = prop.getProperty("AccontExistUser");

	    public TransactionsPage_TC() {
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
	        customerTransactionPage = loginPage.CustomerLogin1(AccountexistUser);
	    }

	    // Test case for verifying deposit with a valid amount
	    @Test(priority = 1)
	    public void Verify_Deposit_With_ValidAmount() {
	        // Call the Filter method from CustomerTransactionPage to apply date filters
	        customerTransactionPage.Filter(Startdate, Enddate);
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}
	

