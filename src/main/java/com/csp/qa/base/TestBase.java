package com.csp.qa.base; // Declares the package for organizing code

import java.io.FileInputStream; // Imports classes for file handling
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration; // Imports classes for time-related operations
import java.util.Properties; // Imports classes for properties management
import java.util.concurrent.TimeUnit; // Imports classes for time units

// Imports classes for Selenium WebDriver
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod; // Imports annotations for test execution

public class TestBase {

	// Declare driver and prop variables globally
	public static WebDriver driver;
	public static Properties prop;

	// Constructor to load properties from a file
	public TestBase() {
		try {
			prop = new Properties(); // Create a Properties object
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\LENOVO\\eclipse-workspace\\CSAP\\src\\main\\java\\com\\csp\\qa\\config\\config.properties"); // Read
																											// properties
																											// from a
																											// file
			prop.load(ip); // Load properties into the object
		} catch (FileNotFoundException e) { // Handle potential errors
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Method to initialize the WebDriver and set up browser settings
	public static void initialization() {
		String browserName = prop.getProperty("browser"); // Get the browser name from properties

		// Launch the specified browser
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\LENOVO\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); // Set ChromeDriver path
			driver = new ChromeDriver(); // Create a ChromeDriver instance
		} else if (browserName.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\LENOVO\\Downloads\\edgedriver_win64\\msedgedriver.exe"); // Set EdgeDriver
																										// path
			driver = new EdgeDriver(); // Create an EdgeDriver instance
		}

		// Maximize window, clear cookies, and set timeouts
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Navigate to the URL specified in properties
		driver.get(prop.getProperty("url"));
	}

	// Method to close the browser after each test method
	@AfterMethod
	public void teardownBrowser() {
		driver.quit(); // Close the browser window
	}
}
