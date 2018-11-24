package Pages;



import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import Base.Base;

public class AddAddress {
	
	
	public AddAddress(){
		Base.log=Logger.getLogger("AddAddress");
		
	}
	
	@FindBy(how=How.XPATH, using="//*[text()='dhirendra Vikram']")
	WebElement menu;
	
	@FindBy(how=How.XPATH, using="//*[contains(@title,'Addresses')]")
	WebElement address;
	
	@FindBy(how=How.XPATH, using="//*[contains(@title,'Add an address')]")
	WebElement addaddress;
	
	@FindBy(how=How.XPATH, using="//*[@id='address1']")
	WebElement address1;
	
	@FindBy(how=How.XPATH, using="//*[@id='city']")
	WebElement city;
	
	@FindBy(how=How.XPATH, using="//*[@id='id_state']")
	WebElement state;
	
	@FindBy(how=How.XPATH, using="//*[@id='postcode']")
	WebElement zip;
	
	@FindBy(how=How.XPATH, using="//*[@id='id_country']")
	WebElement country;
	
	@FindBy(how=How.XPATH, using="//*[@id='phone']")
	WebElement phone;
	
	@FindBy(how=How.XPATH, using="//*[@id='phone_mobile']")
	WebElement mobile;
	
	@FindBy(how=How.XPATH, using="//*[@id='alias']")
	WebElement alias;
	
	@FindBy(how=How.XPATH, using="//*[@id='submitAddress']")
	WebElement save;
	
	@FindBy(how=How.XPATH, using="//*[contains(@class,'col-xs-12')]/ul[contains(@class,'item box')]/li/h3")
	public List<WebElement> assertvalue;
	
	
	
	public static List<String> assertexpectedvalue;

	
	public void addAddress(String add,String city1, String zip1, String phone1, String mobile1, String al){
	
		menu.click();
		Base.log.info("menu clicked");
		address.click();
		Base.log.info("address clicked");
		addaddress.click();
		Base.log.info("add button clicked");
		address1.sendKeys(add);
		Base.log.info("address entered");
		city.sendKeys(city1);
		Base.log.info("city entered");
		Select sl=new Select(state);
		sl.selectByIndex(1);
		Base.log.info("state selected");
		zip.sendKeys(zip1);
		Base.log.info("zip entered");
		phone.sendKeys(phone1);
		Base.log.info("phone entered");
		mobile.sendKeys(mobile1);
		Base.log.info("mobile entered");
		alias.clear();
		Base.log.info("alias cleared");
		alias.sendKeys(al);
		Base.log.info("alias entered");
		save.click();
		Base.log.info("save clicked");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	
	}
	
}
