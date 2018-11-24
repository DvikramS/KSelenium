package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Base.Base;

public class Address {
	
	public Address(){
		Base.log=Logger.getLogger("Address");
	}
	
	@FindBy(how=How.XPATH, using="//*[text()='dhirendra Vikram']")
	WebElement menu;
	
	@FindBy(how=How.XPATH,using="//*[text()='My addresses']")
	WebElement myaddlink;
	
	@FindBy(how=How.XPATH,using="//*[@id='center_column']/h1")
	WebElement assertvalue;

	public String assertactualvalue="MY ADDRESSES";
	public String aseertexpectedvalue;
	
	
	public void verifyAddress(){
		menu.click();
		Base.log.info("menu Clicked");
		myaddlink.click();
		Base.log.info("my add Clicked");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aseertexpectedvalue=assertvalue.getText();
		Base.log.info("assert captured");
		System.out.println(aseertexpectedvalue);
	}
}
