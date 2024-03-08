package com.csp.qa.util;


	

	import java.io.IOException;

	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.events.WebDriverEventListener;

import com.csp.qa.base.TestBase;

	

	// WebEventListener class provides event listener methods to log actions performed by WebDriver
	public class WebEventListener extends TestBase implements WebDriverEventListener {

	    // Log before navigating to a URL
	    public void beforeNavigateTo(String url, WebDriver driver) {
	        System.out.println("Before navigating to: '" + url + "'");
	    }

	    // Log after navigating to a URL
	    public void afterNavigateTo(String url, WebDriver driver) {
	        System.out.println("Navigated to:'" + url + "'");
	    }

	    // Log before changing the value of a WebElement
	    public void beforeChangeValueOf(WebElement element, WebDriver driver) {
	        System.out.println("Value of the:" + element.toString() + " before any changes made");
	    }

	    // Log after changing the value of a WebElement
	    public void afterChangeValueOf(WebElement element, WebDriver driver) {
	        System.out.println("Element value changed to: " + element.toString());
	    }

	    // Log before clicking on a WebElement
	    public void beforeClickOn(WebElement element, WebDriver driver) {
	        System.out.println("Trying to click on: " + element.toString());
	    }

	    // Log after clicking on a WebElement
	    public void afterClickOn(WebElement element, WebDriver driver) {
	        System.out.println("Clicked on: " + element.toString());
	    }

	    // Log before navigating back to the previous page
	    public void beforeNavigateBack(WebDriver driver) {
	        System.out.println("Navigating back to the previous page");
	    }

	    // Log after navigating back to the previous page
	    public void afterNavigateBack(WebDriver driver) {
	        System.out.println("Navigated back to the previous page");
	    }

	    // Log before navigating forward to the next page
	    public void beforeNavigateForward(WebDriver driver) {
	        System.out.println("Navigating forward to the next page");
	    }

	    // Log after navigating forward to the next page
	    public void afterNavigateForward(WebDriver driver) {
	        System.out.println("Navigated forward to the next page");
	    }

	    // Log any exceptions that occur during WebDriver actions and take a screenshot
	    public void onException(Throwable error, WebDriver driver) {
	        System.out.println("Exception occurred: " + error);
	        try {
	            TestUtil.takeScreenshotAtEndOfTest();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // Log before finding an element by a specified By locator
	    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
	        System.out.println("Trying to find Element By : " + by.toString());
	    }

	    // Log after finding an element by a specified By locator
	    public void afterFindBy(By by, WebElement element, WebDriver driver) {
	        System.out.println("Found Element By : " + by.toString());
	    }

	    // Below are non-overridden methods of WebListener class without comments

	    public void beforeScript(String script, WebDriver driver) {
	    }

	    public void afterScript(String script, WebDriver driver) {
	    }

	    public void beforeAlertAccept(WebDriver driver) {
	    }

	    public void afterAlertAccept(WebDriver driver) {
	    }

	    public void afterAlertDismiss(WebDriver driver) {
	    }

	    public void beforeAlertDismiss(WebDriver driver) {
	    }

	    public void beforeNavigateRefresh(WebDriver driver) {
	    }

	    public void afterNavigateRefresh(WebDriver driver) {
	    }

	    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	    }

	    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	    }

	    public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
	    }

	    public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
	    }

	    public void afterSwitchToWindow(String arg0, WebDriver arg1) {
	    }

	    public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
	    }

	    public void beforeGetText(WebElement arg0, WebDriver arg1) {
	    }

	    public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
	    }
	}


