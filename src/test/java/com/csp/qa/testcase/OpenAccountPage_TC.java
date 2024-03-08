package com.csp.qa.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.csp.qa.base.TestBase;
import com.csp.qa.pages.CustomerLoginPage;
import com.csp.qa.pages.OpenAccountPage;

import org.testng.annotations.BeforeMethod;
import java.io.IOException;

public class OpenAccountPage_TC extends TestBase {
	CustomerLoginPage loginPage;
	OpenAccountPage openAccountPage;
	String OpenAccount_username = prop.getProperty("OpenAccount_username");

	public OpenAccountPage_TC() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		try {
			loginPage = new CustomerLoginPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		openAccountPage = loginPage.ManagerLogin1();

	}

	@Test(priority = 1)
	public void OpenAccount() throws InterruptedException {
		openAccountPage.OpenAccount_button.click();
		openAccountPage.AddCustomer(OpenAccount_username);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
