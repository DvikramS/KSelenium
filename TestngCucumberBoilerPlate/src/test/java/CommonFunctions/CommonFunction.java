package CommonFunctions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import main.CucumberRunner;

public class CommonFunction {
public  static String getScreenShots(String filename){
		
		TakesScreenshot ts=(TakesScreenshot) CucumberRunner.driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\ScreenShots\\"+filename+".png");
		try {
			FileHandler.copy(source, dest);
			return dest.getAbsolutePath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
