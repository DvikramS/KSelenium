package Utilities;


import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Base;

public class CommomFunctions {
	WebDriver driver=Base.driver;
	public void implicitwait(){
		Base.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void explicitwait(){
		WebDriverWait wait =new WebDriverWait(Base.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("d")));
	}
	public void fulentwait(){
		
		Wait wait=new FluentWait(Base.driver).withTimeout(30,TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(Exception.class);
	
		driver.findElement(By.xpath("")).sendKeys("tets");
		WebElement ele=driver.findElement(By.xpath(""));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("doucment.getElementById('').value('dd')");
		ele.getText();
		
	}
	public void screenshot() throws IOException{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(""));
	}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://way2automation.com/way2auto_jquery/dropdown.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[text()='Signin']")).click();
		driver.findElement(By.name("username")).sendKeys("dvikramsingh913@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Test@1234");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.findElement(By.xpath("//h2[text()='Dropdown')]")).click();
		
		Select sl=new Select(driver.findElement(By.xpath("//select/option")));
		sl.selectByIndex(1);
		Alert al=driver.switchTo().alert();
		al.accept();
		al.dismiss();
		al.getText();
		driver.switchTo().defaultContent();
		driver.close();
	}
	
	public void urltest() throws IOException{
		
		List<WebElement> al=driver.findElements(By.tagName("a"));
		for(int i=0;i<al.size();i++){
		URL url=new URL(al.get(i).getAttribute("href"));
		HttpURLConnection ht=(HttpURLConnection)url.openConnection();
		ht.setConnectTimeout(30);
		ht.connect();
		if(ht.getResponseCode()!=200){
			System.out.println(al.get(i).getAttribute("href"));
		}
	}
	}
	
	
}