package stepdefinition;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import Pages.verifyAddressPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.CucumberRunner;

public class VerifyAddress {
	
	public VerifyAddress(){
		CucumberRunner.log=Logger.getLogger("VerifyAddress");
	}
	
	verifyAddressPage ap;
	
	@Given("^I have sign in menu$")
	public void click_on_given_signin_menu(){
		ap=PageFactory.initElements(CucumberRunner.driver, verifyAddressPage.class);
		ap.menu.click();
		CucumberRunner.log.info("menu Clicked");
	}
	
	@When("^Click on address menu$")
	public void click_on_add_menu(){
		ap.myaddlink.click();
		CucumberRunner.log.info("my add Clicked");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("^I need to verify Title$")
	public void verifyadd(){
		
	
		ap.aseertexpectedvalue=ap.assertvalue.getText();
		CucumberRunner.log.info("assert captured");
	}

}
