package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

import CommonFunctions.CommonFunction;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import stepdefinition.Hooks;

@CucumberOptions(
		strict = true,
		monochrome = true, 
		features = "src/test/resources/features",
		glue = "stepdefinition",
		plugin = {"pretty", "html:target/cucumber-html-report"},
		//"pretty", "html:target/cucumber-html-report"
		tags={"@Regression,@JunitScenario,@TestngScenario"})

public class CucumberRunner extends AbstractTestNGCucumberTests {

	public static Properties config = null;
	public static WebDriver driver = null;
	public static ExtentReports er;
	public static ExtentTest logger;
	public static ExtentHtmlReporter reporter;
	public static Logger log;
	public void LoadConfigProperty() throws IOException {
		config = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//config//config.properties");
		config.load(ip);
		reporter =new ExtentHtmlReporter(".\\Reports\\ExtentReports.html");
		
		er=new ExtentReports();
		er.attachReporter(reporter);
		log=Logger.getLogger("CucumberRunner");
		PropertyConfigurator.configure(".\\src\\test\\resources\\config\\log4j.properties");
	}

	public void openBrowser() throws Exception {
		LoadConfigProperty();
		if (config.getProperty("browserType").equals("Firefox")) {

			driver = new FirefoxDriver();
		} else if (config.getProperty("browserType").equals("Chrome")) {
			//String chromeDriverPath = "/usr/local/bin/chromedriver";
			//System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--disable-gpu");
			options.addArguments("--no-sandbox");
        	options.addArguments("--disable-dev-shm-usage");
			options.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(options);
			log.info("driver initilized");
			log.info("browser opened");
		}
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
		log.info("maximized");
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void explicitWait(WebElement element) {
		WebDriverWait wait  = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void pageLoad(int time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	public void setEnv() throws Exception {
		LoadConfigProperty();
		String baseUrl = config.getProperty("siteUrl");
		driver.get(baseUrl);
		log.info("URL Opened");
	}

	public static String currentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String cal1 = dateFormat.format(cal.getTime());
		return cal1;
	}

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {
		openBrowser();
		maximizeWindow();
		implicitWait(30);
		deleteAllCookies();
		setEnv();
	}

/*	@AfterClass(alwaysRun = true)
	public void takeScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File trgtFile = new File(System.getProperty("user.dir") + "//screenshots/screenshot.png");
		trgtFile.getParentFile().mkdir();
		trgtFile.createNewFile();
		Files.copy(scrFile, trgtFile);

	}*/
	

/*	@AfterMethod(alwaysRun = true)
	public void tearDownr(ITestResult result) throws IOException {
		
		if (result.getStatus()==result.SUCCESS) {
			
			
			logger=er.createTest(Hooks.s);
			logger.log(Status.PASS, "PASSED");
			er.flush();
		}
		if(result.getStatus()==result.FAILURE){
			logger=er.createTest(Hooks.s);
			logger.log(Status.FAIL, "FAILED");
			
			logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(CommonFunction.getScreenShots(Hooks.s+result.getMethod().getMethodName())).build());
			er.flush();
		}
		
		if(result.getStatus()==result.SKIP){
			logger=er.createTest(Hooks.s);
			logger.log(Status.SKIP, "SKIPPED");
			er.flush();
		}

	}*/

	@AfterSuite(alwaysRun = true)
	public void quit() throws IOException, InterruptedException {
		driver.quit();
	}
}
