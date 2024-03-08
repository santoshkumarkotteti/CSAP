package com.csp.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.csp.qa.base.TestBase;



// TestUtil class provides utility methods for handling test data, screenshots, and runtime information
public class TestUtil extends TestBase {

    // Set timeout values for page load and implicit wait
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;

    // Path to the Excel test data file
    public static String TESTDATA_SHEET_PATH = "/Users/Poojitha/eclipse/BsgAxisSolutions/src/main/java/com/crm/qa/testdata/FreeCrmTestData.xlsx";

    static Workbook book;
    static Sheet sheet;
    static JavascriptExecutor js;

    // Switch to the specified frame named "mainpanel"
    public void switchToFrame() {
        driver.switchTo().frame("mainpanel");
    }

    // Retrieve test data from the specified sheetName in the Excel file
    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            // Open Excel file input stream
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            // Create a Workbook instance from the input stream
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                // Populate data array with cell values from the Excel sheet
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }
        }
        return data;
    }

    // Capture screenshot and save it in the "screenshots" directory with a timestamp
    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }

    // Display runtime information using jQuery-growl for different message types
    public static void runTimeInfo(String messageType, String message) throws InterruptedException {
        js = (JavascriptExecutor) driver;

        // Check for jQuery on the page and add it if needed
        js.executeScript("if (!window.jQuery) {"
                + "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
                + "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
                + "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
        Thread.sleep(5000);

        // Add jquery-growl to the page
        js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

        // Add jquery-growl styles to the page
        js.executeScript("$('head').append('<link rel=\"stylesheet\" "
                + "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
        Thread.sleep(5000);

        // Show jQuery-growl messages based on the messageType
        js.executeScript("$.growl({ title: 'GET', message: '/' });");
        if (messageType.equals("error")) {
            js.executeScript("$.growl.error({ title: 'ERROR', message: '"+message+"' });");
        } else if(messageType.equals("info")) {
            js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
        } else if(messageType.equals("warning")) {
            js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
        } else {
            System.out.println("no error message");
        }
        Thread.sleep(5000);
    }

	
		
	}

