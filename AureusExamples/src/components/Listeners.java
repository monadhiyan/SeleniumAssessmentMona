package components;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;


public class Listeners extends Baseclassutil implements ITestListener{
	ExtentTest Test;
	ExtentReports extent = ExtentReporterNG.getReportObject();

		  public void onTestStart(ITestResult result) {
		  Test =  extent.createTest(result.getMethod().getMethodName());
		  }

		
		  public void onTestSuccess(ITestResult result) {
		    
			  Test.log(Status.PASS,"Test Passed Successfully");
		  }

		  
		  public void onTestFailure(ITestResult result) {
		      try {
				driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		      Test.log(Status.FAIL,"Test Failed,The error is:");
			  Test.fail(result.getThrowable());
			  //Attaching screenshot when fails
			  String filepath= null;
			try {
				filepath = getscreenshot(result.getMethod().getMethodName(),driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  Test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		  }

		  
		  public void onTestSkipped(ITestResult result) {
		    // not implemented
		  }

		  
		  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
		  }

		  
		  public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		  }

		 
		  public void onStart(ITestContext context) {
		    // not implemented
		  }

		 
		  public void onFinish(ITestContext context) {
		    extent.flush();
		  }
		}

	

		



