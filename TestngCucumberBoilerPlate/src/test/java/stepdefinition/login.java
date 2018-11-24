package stepdefinition;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Pages.loginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.CucumberRunner;




public class login {
	public login(){
		CucumberRunner.log=Logger.getLogger("Login");
		}
	loginPage login;
	
	@Given("^login page is given$")
	public void login_page_is_given() {
	    // Write code here that turns the phrase above into concrete actions
		 login=PageFactory.initElements(CucumberRunner.driver, loginPage.class);
	    
	}

	@When("^enter (?:valid|invalid) \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_and(List<String> username, List<String> password) {
	    // Write code here that turns the phrase above into concrete actions
		login.signin.click();
		CucumberRunner.log.info("signin clicked");
		login.username.sendKeys(username.get(0));
		CucumberRunner.log.info("username entered");
		login.password.sendKeys(password.get(0));
		CucumberRunner.log.info("password entered");
		login.loginButton.click();
		CucumberRunner.log.info("Login button clicked");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@And("^match assertion for valid login$")
	public void match_aseert_for_valid_login(){
		login.assertexpected=login.assertvalue.getText();
		CucumberRunner.log.info("assert value finded");
	}
	
	@And("^match assertion for invalid login$")
	public void match_aseert_for_invalid_login(){
		login.assertexpected1=login.assertvalue1.getText();
		login.signin.click();
		CucumberRunner.log.info("assert value finded");
	}   
	

	@Then("^login should sucessfull$")
	public void login_should_sucessfully() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(login.assertactualvalue.equals(login.assertexpected));
	}
	
	@Then("^login should not sucessfull$")
	public void login_should_not_sucessfull() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(login.assertactualvalue1.equals(login.assertexpected1));
	}

	
}
