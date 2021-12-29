package com.crm.comcast.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImpClass implements ITestListener{
	JavaUtlity jLib = new JavaUtlity();

	public void onTestFailure(ITestResult result) {
		
					String testNAme = result.getMethod().getMethodName();
					 String date = jLib.getDateAndTime();
			
			      EventFiringWebDriver edriver = new EventFiringWebDriver(BaseAnnotationClass.sdriver);
			      File srcFiel = edriver.getScreenshotAs(OutputType.FILE);
			   
			      File dstFile = new File("./screenShot/"+testNAme+"_"+date +".png");
			      
			      try {
					FileUtils.copyFile(srcFiel, dstFile);
			  	} catch (IOException e) {
			
				}
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	

}
