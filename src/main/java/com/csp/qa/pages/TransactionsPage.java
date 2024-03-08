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

	// CustomerTransactionPage class represents the page where customer transactions can be viewed and filtered
	public class TransactionsPage extends TestBase {

		// Page Factory - Object Repository:
		@FindBy(xpath = "//button[normalize-space()='Transactions']")
		WebElement Transaction_button;

		@FindBy(xpath = "//input[@id='start']")
		WebElement StartDate;

		@FindBy(xpath = "//input[@id='end']")
		WebElement EndDate;

		@FindBy(xpath = "//*[@id=\"anchor0\"]/td[1]")
		WebElement Validation;

		@FindBy(xpath = "//body//div[@class='ng-scope']//div[@class='ng-scope']//div[2]")
		WebElement pageclick;

		// Initializing the Page Objects:
		public TransactionsPage() {
			PageFactory.initElements(driver, this);
		}

		// Actions:

		// Validate the title of the login page
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}

		// Filter transactions based on start and end dates
		public void Filter(String startDate, String endDate) {
			Transaction_button.click();
			StartDate.sendKeys(startDate);
			EndDate.sendKeys(endDate);
			pageclick.click();
		}
	}

	

