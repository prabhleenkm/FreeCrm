
	package com.qa.ExtentReportListner;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	public class ExtentReportListener implements ITestListener {
	    private static ExtentReports extent;
	    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	    @Override
	    public void onStart(ITestContext context) {
	        // Initialize ExtentReports
	    	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
	        htmlReporter.config().setTheme(Theme.DARK);
	        htmlReporter.config().setDocumentTitle("Test Report");
	        htmlReporter.config().setReportName("Extent Report");

	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("Tester", "Your Name");
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        // Create a new test in the report
	        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
	        test.set(extentTest);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        // Log test success
	        test.get().pass("Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        // Log test failure
	        test.get().fail("Test Failed: " + result.getThrowable());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        // Log test skipped
	        test.get().skip("Test Skipped: " + result.getThrowable());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        // Flush the report
	        if (extent != null) {
	            extent.flush();
	        }
	    }
	}
