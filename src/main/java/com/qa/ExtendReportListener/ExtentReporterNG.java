package com.qa.ExtendReportListener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

// ExtentReporterNG class implements the IReporter interface for TestNG reporting
public class ExtentReporterNG implements IReporter {
	private ExtentReports extent;

	// Generates the HTML report based on the test results
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// Initialize the ExtentReports object with the output directory and file name
		extent = new ExtentReports(outputDirectory + File.separator + "Extent.html", true);

		// Iterate through each TestNG suite
		for (ISuite suite : suites) {
			// Get the results for each suite
			Map<String, ISuiteResult> result = suite.getResults();

			// Iterate through the results to build the test nodes
			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				// Build test nodes for passed, failed, and skipped tests
				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}

		// Flush and close the ExtentReports object to finalize the report
		extent.flush();
		extent.close();
	}

	// Build test nodes based on the result map and log the status
	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;

		// Check if there are any results in the map
		if (tests.size() > 0) {
			// Iterate through each test result
			for (ITestResult result : tests.getAllResults()) {
				// Start a new ExtentTest for each test method
				test = extent.startTest(result.getMethod().getMethodName());

				// Set the start and end time for the test
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));

				// Assign test categories based on groups
				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				// Log the test status and details
				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				} else {
					test.log(status, "Test " + status.toString().toLowerCase() + "ed");
				}

				// End the ExtentTest for the current test method
				extent.endTest(test);
			}
		}
	}

	// Convert milliseconds to Date object
	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

}
