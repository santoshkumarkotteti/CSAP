package com.csp.qa.testcase;




	import java.io.IOException;

	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

import com.csp.qa.base.TestBase;
import com.csp.qa.pages.WithdrawlPage;
import com.csp.qa.pages.CustomerLoginPage;

	
	public class DepositePage_TC extends TestBase {
	    CustomerLoginPage loginPage;
	    WithdrawlPage accountPage;
	    String AccountexistUser = prop.getProperty("AccontExistUser");
	    int ValidAmount = Integer.valueOf(prop.getProperty("ValidAmount"));
	    int InValidAmount = Integer.valueOf(prop.getProperty("InValidAmount")); // Define InValidAmount

	    public DepositePage_TC() {
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
	        accountPage = loginPage.CustomerLogin(AccountexistUser);
	    }

	    @Test(priority = 1)
	    public void VerifyDepositWithValidAmount() {
	        // Verify the deposit with a valid amount
	        accountPage.ValidDeposit("Deposit Successful", ValidAmount);
	    }

	    @Test(priority = 2)
	    public void VerifyDepositWithInvalidAmount() {
	        // Verify the deposit with an invalid amount
	        accountPage.InValidDeposit(InValidAmount);
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }

	
	
	}

