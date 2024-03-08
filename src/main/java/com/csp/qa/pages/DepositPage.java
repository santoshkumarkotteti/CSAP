package com.csp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.csp.qa.base.TestBase;

public class DepositPage extends TestBase {

	@FindBy(xpath = "//button[@ng-click='deposit()']")
	private WebElement depositButton;

	@FindBy(xpath = "//input[@placeholder='amount']")
	private WebElement amountField;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//span[@class='error ng-binding']")
	private WebElement message;

	public DepositPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterDepositAmount(int amount) {
		amountField.clear();
		amountField.sendKeys(String.valueOf(amount));
	}

	public void submitDeposit() {
		submitButton.click();
	}

	public void depositAmount(int amount) {
		depositButton.click();
		amountField.clear();
		amountField.sendKeys(String.valueOf(amount));
		submitButton.click();
	}

	public String getMessage() {
		return message.getText();

	}

}
