package com.csp.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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

// OpenAccountPage class represents the page where new accounts can be opened for customers
public class OpenAccountPage extends TestBase {

	// Page Factory - Object Repository:
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[2]")
	public WebElement OpenAccount_button;

	@FindBy(xpath = "//select[@id='userSelect']")
	WebElement Customer_Name;

	@FindBy(xpath = "//select[@id='currency']")
	WebElement Currency;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement Submit;

	// Property to store the expected message for opening an account
	String openAccount_msg = prop.getProperty("openAccount_msg");

	// Initializing the Page Objects:
	public OpenAccountPage() {
		PageFactory.initElements(driver, this);
	}

	// Get the size of the currency dropdown
	public int currency_Size() {
		Select dropdown = new Select(Currency);
		int itemCount = dropdown.getOptions().size();
		return itemCount;
	}

	// Select an account from the currency dropdown by index
	public void SelectAccount(int index) {
		Select dropdown = new Select(Currency);
		dropdown.selectByIndex(index);
	}

	// Select a customer from the user dropdown by visible text
	public void SelectUser(String username) {
		Select dropdown = new Select(Customer_Name);
		dropdown.selectByVisibleText(username);
	}

	// Get the text from the alert message
	public String getAlertMessageText() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	// Accept the alert
	public void getAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// Add a customer and open an account for each available currency
	public OpenAccountPage AddCustomer(String name) throws InterruptedException {
		int count = currency_Size();
		for (int i = 1; i < count; i++) {
			OpenAccount_button.click();
			Thread.sleep(1000);
			SelectUser(name);
			Thread.sleep(1000);
			SelectAccount(i);
			Submit.click();
			Thread.sleep(1000);
			String message = getAlertMessageText();
			assertContains(message, openAccount_msg);
			getAlert();
		}
		return new OpenAccountPage();
	}

	// Custom assertion to check if the actual text contains the expected partial
	// text
	public static void assertContains(String actualText, String expectedPartialText) {
		Assert.assertTrue(actualText.contains(expectedPartialText),
				"Actual text does not contain expected partial text");
	}
}
