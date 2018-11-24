package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import main.CucumberRunner;

public class loginPage {

	
	
		@FindBy(how=How.XPATH,using="//*[contains(text(),'Sign in')]")
		public WebElement signin;
		
		@FindBy(how=How.XPATH,using="//*[@id='email']")
		public WebElement username;
		
		@FindBy(how=How.XPATH,using="//*[@id='passwd']")
		public WebElement password;
		
		@FindBy(how=How.XPATH, using="//*[@id='SubmitLogin']")
		public WebElement loginButton;
		
		@FindBy(how=How.XPATH, using="//*[text()='dhirendra Vikram']")
		public WebElement assertvalue;
		
		@FindBy(how=How.XPATH, using="//*[text()='Authentication failed.']")
		public WebElement assertvalue1;
		
		public static String assertactualvalue="dhirendra Vikram";
		public static String assertexpected;
		public static String assertactualvalue1="Authentication failed.";
		public static String assertexpected1;
		
}
