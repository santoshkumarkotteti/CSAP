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

// CustomersPage class represents the page where customer details are managed
public class CustomerPage extends TestBase {

	// Page Factory - Object Repository:
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[3]")
	public WebElement Customer_button;

	@FindBy(xpath = "//input[@placeholder='Search Customer']")
	WebElement SearchBox;

	@FindBy(xpath = "//button[@ng-click='deleteCust(cust)']")
	WebElement Delete;

	// Initializing the Page Objects:
	public CustomerPage() {
		PageFactory.initElements(driver, this);
	}

	// Delete a customer entry using the specified username
	public void DeleteEntry(String username) throws InterruptedException {
		Customer_button.click();
		SearchBox.sendKeys(username);
		Delete.click();
		System.out.println("Deleted customer details successfully");
	}
}
