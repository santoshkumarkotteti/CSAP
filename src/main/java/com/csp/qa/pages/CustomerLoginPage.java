package com.csp.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.csp.qa.base.TestBase;



// LoginPage class represents the page where users can log in
public class CustomerLoginPage extends TestBase {

    // Page Factory - Object Repository:
    @FindBy(xpath="//button[normalize-space()='Customer Login']")
    WebElement Customer_Login;

    @FindBy(xpath="//button[normalize-space()='Bank Manager Login']")
    WebElement Manager_Login;

    // Initializing the Page Objects:
    public CustomerLoginPage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    // Actions:

    // Validate the title of the login page
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    // Customer login action with username selection
    public WithdrawlPage CustomerLogin(String username) {
        Customer_Login.click();
        WebElement dropdownElement = driver.findElement(By.xpath(prop.getProperty("dropdown")));

        // Create a Select object
        Select dropdown = new Select(dropdownElement);

        // Select an option by visible text
        dropdown.selectByVisibleText(username);
        String path=prop.getProperty("Login");

        // Click the login button
        driver.findElement(By.xpath(path)).click();

        return new WithdrawlPage();
    }

    // Overloaded method for Customer login, returning CustomerTransactionPage
    public TransactionsPage CustomerLogin1(String username) {
        Customer_Login.click();
        WebElement dropdownElement = driver.findElement(By.xpath(prop.getProperty("dropdown")));

        // Create a Select object
        Select dropdown = new Select(dropdownElement);

        // Select an option by visible text
        dropdown.selectByVisibleText(username);
        String path=prop.getProperty("Login");

        // Click the login button
        driver.findElement(By.xpath(path)).click();

        return new TransactionsPage();
    }

    // Manager login action, returning AddCustomerPage
    public AddCustomerPage ManagerLogin() {
        Manager_Login.click();
        return new AddCustomerPage();
    }

    // Manager login action, returning OpenAccountPage
    public OpenAccountPage ManagerLogin1() {
        Manager_Login.click();
        return new OpenAccountPage();
    }

    // Manager login action, returning CustomersPage
    public CustomerPage ManagerLogin2() {
        Manager_Login.click();
        return new CustomerPage();
    }
    }
