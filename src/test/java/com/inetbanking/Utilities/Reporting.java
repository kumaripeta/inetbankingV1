package com.inetbanking.Utilities;
import java.io.File;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting implements ITestListener {
	 ExtentSparkReporter htmlReporter;
	 ExtentReports reports;
	 ExtentTest test;
 
 public void configureReport()
 {
	 htmlReporter = new  ExtentSparkReporter("ExtentListenerReportDemo.html");
	 reports = new ExtentReports();
	 reports.attachReporter(htmlReporter);
	 
	 //add system info/envirinfo to reports
	 reports.setSystemInfo("Machine","testpc1");
	 reports.setSystemInfo("OS","winddows 11");
	 reports.setSystemInfo("browser","chrome");
	 reports.setSystemInfo("user name","kumari");
	 
	 //config to change look n feel of report
	 htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
	 htmlReporter.config().setReportName("my first report");
	 htmlReporter.config().setTheme(Theme.DARK);
 }
 
 public void OnStart(ITestContext Result)
 {
	 configureReport();
	 System.out.println("On Start method invoked.........");
 }
 public void OnFinish(ITestContext Result)
 {
	 System.out.println("On Finished method invoked.........");
	 reports.flush();
 }
 
 //when Test case get failed.this method invi=oked
 public void OnTestFailure(ITestResult Result)
 {
	 System.out.println("Name of the Test method failed:" + Result.getName() );
	 test=reports.createTest(Result.getName());//create entry in html report
	 test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is:" +Result.getName(),ExtentColor.RED)); 
	 String screenShotPath = System.getProperty("user.dir")+ "\\Screenshorts\\" + Result.getName()+ ".png";
	 
	 File screenShotFile =new File(screenShotPath);
	 
	 if(screenShotFile.exists())
	 {
		 test.fail("captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));
	 }
	 //test.addScreenCaptureFromPath(null)
 
 }
 public void OnTestSkipped(ITestResult Result)
 {
	 System.out.println("Name of the Test method skipped:" + Result.getName() );
	 test=reports.createTest(Result.getName());
	 test.log(Status.SKIP, MarkupHelper.createLabel("name of the skipped test case is:" +Result.getName(),ExtentColor.YELLOW)); 
 }
 //when testcase get started, this method is called
 public void OnTestStart(ITestResult Result)
 {
	 System.out.println("Name of the Test method started:" + Result.getName());
 }
 
 //when testcase get passed, this method is called
 public void OnTestSuccess(ITestResult Result)
 {
	 System.out.println("Name of the Test method successfully executed:" + Result.getName());
	 test = reports.createTest(Result.getName());
	 test.log(Status.PASS, MarkupHelper.createLabel("name of the skipped test case is:"  +Result.getName(),ExtentColor.GREEN)); 
 }
 
 public void onTestFailedButWithinSuccessPercentage(ITestResult result)
 {
 } 
 }


