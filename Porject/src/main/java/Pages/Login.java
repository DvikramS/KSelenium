package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Base.Base;

public class Login {

	public Login(){
	Base.log=Logger.getLogger("Login");
	}
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Sign in')]")
	WebElement signin;
	
	@FindBy(how=How.XPATH,using="//*[@id='email']")
	WebElement username;
	
	@FindBy(how=How.XPATH,using="//*[@id='passwd']")
	WebElement password;
	
	@FindBy(how=How.XPATH, using="//*[@id='SubmitLogin']")
	WebElement loginButton;
	
	@FindBy(how=How.XPATH, using="//*[text()='dhirendra Vikram']")
	WebElement assertvalue;
	
	public static String assertactualvalue="dhirendra Vikram";
	public static String assertexpected;
	
	public void verifyLogin(String email, String pwd){
		signin.click();
		Base.log.info("signin clicked");
		username.sendKeys(email);
		Base.log.info("username entered");
		password.sendKeys(pwd);
		Base.log.info("password entered");
		loginButton.click();
		Base.log.info("Login button clicked");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertexpected=assertvalue.getText();
		Base.log.info("assert value finded");
	}
}
