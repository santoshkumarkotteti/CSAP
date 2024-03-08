package com.csp.qa.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.csp.qa.base.TestBase;
import com.csp.qa.pages.CustomerLoginPage;
import com.csp.qa.pages.WithdrawlPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class Withdrawl_TC extends TestBase{
	CustomerLoginPage loginPage;
	WithdrawlPage accountPage;
	String AccountexistUser = prop.getProperty("AccontExistUser");
	String AccountNot_existUser = prop.getProperty("AccontNot_ExistUser");
	int ValidAmount = Integer.valueOf(prop.getProperty("ValidAmount")) ;
	int InValidAmount = Integer.valueOf(prop.getProperty("InValidAmount")) ;
	String Successfull= prop.getProperty("Successfull");
	String inSufficient = prop.getProperty("inSufficient");
	int InSufficient_Amount = Integer.valueOf(prop.getProperty("InSufficient_Amount")) ;
	
	
	public Withdrawl_TC()
	{
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
		accountPage = loginPage.CustomerLogin(AccountexistUser);
	}
	
	

	
	@Test(priority=1)
	public void Verify_Withdraw_With_ValideAmmount() throws InterruptedException
	{
		accountPage.ValidWithdraw(Successfull,ValidAmount);
	}
	
	@Test(priority=2)
	public void Verify_Withdraw_With_InValideAmmount() throws InterruptedException
	{
		accountPage.InValidWithdraw(InValidAmount);
	}
	
	@Test(priority=3)
	public void Verify_Withdraw_With_InSufficient() throws InterruptedException
	{
		accountPage.ValidWithdraw(inSufficient,InSufficient_Amount);
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}