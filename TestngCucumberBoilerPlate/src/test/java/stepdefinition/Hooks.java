package stepdefinition;

import java.io.IOException;

import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import CommonFunctions.CommonFunction;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import main.CucumberRunner;


public class Hooks {

	
	public static String s="";
	@Before
	public void beforehook(Scenario sc){

		s=sc.getName();
		System.out.println(sc.getStatus()+"----------------");
		
	
	}
	
	@After
public void tearDownr(Scenario result) throws IOException {
		
		if (result.getStatus().equalsIgnoreCase("passed")) {
			
			
			CucumberRunner.logger=CucumberRunner.er.createTest(result.getName());
			CucumberRunner.logger.log(Status.PASS, "PASSED");
			CucumberRunner.er.flush();
		}
		if(result.getStatus().equalsIgnoreCase("failed")){
			CucumberRunner.logger=CucumberRunner.er.createTest(Hooks.s);
			CucumberRunner.logger.log(Status.FAIL, "FAILED");
			
			CucumberRunner.logger.fail(result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(CommonFunction.getScreenShots(Hooks.s+result.getName())).build());
			CucumberRunner.er.flush();
		}
		
		if(result.getStatus().equalsIgnoreCase("skipped")){
			CucumberRunner.logger=CucumberRunner.er.createTest(Hooks.s);
			CucumberRunner.logger.log(Status.SKIP, "SKIPPED");
			CucumberRunner.er.flush();
		}

	}
}
