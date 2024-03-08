package com.csp.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.csp.qa.base.TestBase;





public class WithdrawlPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//span[@class='fontBig ng-binding']")
	WebElement Customer_Name;
	
	@FindBy(xpath="//button[@ng-click='deposit()']")
	WebElement Deposit_button;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Submit;
	
	@FindBy(xpath="//button[normalize-space()='Withdrawl']")
	WebElement Withdraw_button;
	
	@FindBy(xpath="//div[2]/strong[1]")
	WebElement Account_number;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[2]/strong[2]") ////div[2]/strong[2]
	WebElement Balance;

	@FindBy(xpath="//div[2]/strong[3]")
	WebElement Currency;
	
	@FindBy(xpath="//select[@id='accountSelect']")
	WebElement AccountNumberList;
	
	@FindBy(xpath="//input[@placeholder='amount']")
	WebElement Amount_Filed;
	
	@FindBy(xpath="//span[@class='error ng-binding']")
	WebElement Message;
	
	
	
	//Initializing the Page Objects:
	public WithdrawlPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	public String verifyCustomerName(){
		return Customer_Name.getText();
	}
	
	public String GetBalance()
	{
		return Balance.getText();
	}
	
	
	public int acno()
	{
	 Select dropdown = new Select(AccountNumberList);
	  int itemCount = dropdown.getOptions().size();
	  return itemCount; 
	}
	
	public void SelectAccount(int index)
	{
		 Select dropdown = new Select(AccountNumberList);
		 dropdown.selectByIndex(index);
	}
	
	public WithdrawlPage Deposit(int amount)
	{
		Deposit_button.click();
		 Amount_Filed.clear();
		 Amount_Filed.sendKeys(String.valueOf(amount));
		Submit.click();  	
		return new WithdrawlPage();
	}
	
	public WithdrawlPage Withdraw(int amount) throws InterruptedException
	{
		
		Withdraw_button.click();
		Wait();
		Amount_Filed.clear();
		Wait();
		Amount_Filed.sendKeys(String.valueOf(amount));
		Wait();
		Submit.click();  

		return new WithdrawlPage();
	}
	
	
	public String message()
	{
		return Message.getText();
	}
	
	//for Deposit
	public int Deposit_CurrentBalance(int Amount_To_Deposit,int oldBalance)
	{
		int currentBalance = 0;
		if(Amount_To_Deposit < 0)
		{
			currentBalance = oldBalance;
		}
		else
		{
			currentBalance = oldBalance + Amount_To_Deposit;
		}
		return currentBalance;
		
	}
	
	//for withdraw
	public int Withdraw_CurrentBalance(int Amount_To_Withdraw,int oldBalance)
	{
		int currentBalance = 0;
		if(Amount_To_Withdraw < 0 || Amount_To_Withdraw > oldBalance)
		{
			currentBalance = oldBalance;
		}
		else
		{
			currentBalance = oldBalance - Amount_To_Withdraw;
		}
		return currentBalance;
		
	}
	
	public void ValidDeposit(String message,int Amount)
	{
		int count = acno();
		for(int i=0;i<count;i++)
		{
			 SelectAccount(i);
			 int oldBal= Integer.valueOf(GetBalance());
			 Deposit(Amount);
			 int newBal = Integer.valueOf(GetBalance());
			 int currentBal = Deposit_CurrentBalance(Amount,oldBal) ;
			 Assert.assertEquals(currentBal, newBal);
			 String msg = message();
			 Assert.assertEquals(msg , message );
			 
		}
	}
	public void InValidDeposit(int Amount)
	{
		int count = acno();
		for(int i=0;i<count;i++)
		{
			 SelectAccount(i);
			 int oldBal= Integer.valueOf(GetBalance());
			 Deposit(Amount);
			 int newBal = Integer.valueOf(GetBalance());
			 int currentBal = Deposit_CurrentBalance(Amount,oldBal) ;
			 Assert.assertEquals(currentBal, newBal);
			 
			 //invalid case doesn't raise error msg
			// String msg = message();
			// Assert.assertEquals(msg , message );
			 
		}
	}
	
	public void ValidWithdraw(String message,int Amount) throws InterruptedException
	{
		int count = acno();
		for(int i=0;i<count;i++)
		{
			 SelectAccount(i);
			 Deposit(20000);
			 int oldBal= Integer.valueOf(GetBalance());
			 Withdraw(Amount);
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 int newBal = Integer.valueOf(GetBalance());
			 int currentBal = Withdraw_CurrentBalance(Amount,oldBal) ;
			 Assert.assertEquals(currentBal, newBal);
			 String msg = message();
			 Assert.assertEquals(msg , message );
			 
		}
	}
	
	public void Wait() throws InterruptedException {Thread.sleep(1000);}
	public void InValidWithdraw(int Amount) throws InterruptedException
	{
		int count = acno();
		for(int i=0;i<count;i++)
		{
			 SelectAccount(i);
			 int oldBal= Integer.valueOf(GetBalance());
			 Withdraw(Amount);
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 int newBal = Integer.valueOf(GetBalance());
			 int currentBal = Withdraw_CurrentBalance(Amount,oldBal) ;
			 Assert.assertEquals(newBal,currentBal);
			 
			 
		}
	}

	public WithdrawlPage navigateToWithdrawalPage1() {
		// TODO Auto-generated method stub
		return null;
	}

	public void clickWithdrawlTab() {
		// TODO Auto-generated method stub
		
	}

	public void enterWithdrawlAmount(String string) {
		// TODO Auto-generated method stub
		
	}

	public void clickWithdrawlButton() {
		// TODO Auto-generated method stub
		
	}

	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWithdarwlSuccessMSG() {
		// TODO Auto-generated method stub
		return null;
	}}