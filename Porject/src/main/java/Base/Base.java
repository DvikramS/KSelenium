package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utilities.ExcelUitlity;

public class Base {
	//public  static WebDriver driver;
	public static RemoteWebDriver driver;
	public static Properties pr;
	public static FileInputStream f;
	public static ExtentReports er;
	public static ExtentTest logger;
	public static ExtentHtmlReporter reporter;
	public static boolean isbrowserOpen=false;
	public static ExcelUitlity xl;
	public static String data;
	public static Logger log;
	static {
		reporter =new ExtentHtmlReporter(".\\Reports\\ExtentReports.html");
		er=new ExtentReports();
		er.attachReporter(reporter);
		log=Logger.getLogger("Base");
		PropertyConfigurator.configure(".\\src\\main\\java\\Config\\log4j.properties");
		try {
			f=new FileInputStream(".\\src\\main\\java\\Config\\config.properties");
			pr=new Properties();
			pr.load(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		xl=new ExcelUitlity(".\\TestData.xlsx");
		
	}
	public Base(){
		
	}
	public Base(String browser, String url){
		
		
		if(!isbrowserOpen || driver==null){
		if(browser.equalsIgnoreCase("Chrome")){
			
			System.setProperty("google.chrome.driver", ".\\chromedriver.exe");
			ChromeOptions co=new ChromeOptions();
			co.addArguments("disable-infobars");
		//	co.addArguments("headless");
			co.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
			//co.setCapability(CapabilityType.LOGGING_PREFS, false);
			driver=new ChromeDriver(co);
			log.info("browser opened");
			driver.manage().window().maximize();
			log.info("Maximized");
			driver.navigate().to(url);
			log.info("url opened");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.navigate().to(url);
			driver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", ".\\IEDriverServer.exe");
			InternetExplorerOptions io=new InternetExplorerOptions();
			io.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver=new InternetExplorerDriver(io);
			driver.navigate().to(url);
			driver.manage().window().maximize();
		}
		isbrowserOpen=true;
		}
	}
	
/*	public  void BaseGrid(String browser, String URL) throws MalformedURLException{
		
		if(browser.equalsIgnoreCase("chrome")){
			DesiredCapabilities dc=DesiredCapabilities.chrome();
			log.info("chrome capability set");
			dc.setBrowserName("chrome");
			dc.setPlatform(Platform.WIN10);
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
			log.info("driver initilized");
			//setDriver(dr);
			log.info("browser opened");
			driver.manage().window().maximize();
			log.info("Maximized");
			driver.navigate().to(URL);
			log.info("URL opened");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}
	
	public void setDriver(RemoteWebDriver dr){
		driver=dr;
	}
	*/
/*	public static void main(String[] args) {
		new Base("chrome","http://google.com");
	}*/
	

}
