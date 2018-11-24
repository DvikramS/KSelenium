package Listners;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Base.Base;
import Utilities.CommomFunctions;
import Utilities.UtilityFunctions;

public class Listner implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		Base.logger=Base.er.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Base.logger.log(Status.PASS, Base.data);
		Base.er.flush();
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		Base.logger.log(Status.FAIL, Base.data);
		/*try {
					CommomFunctions CommomFunction=new CommomFunctions();
			Base.logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(CommomFunction.getScreenShots(result.getMethod().getMethodName())).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Base.er.flush();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Base.logger.log(Status.SKIP, Base.data);
		Base.er.flush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
