package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class verifyAddressPage {
	

	@FindBy(how=How.XPATH, using="//*[text()='dhirendra Vikram']")
	public WebElement menu;
	
	@FindBy(how=How.XPATH,using="//*[text()='My addresses']")
	public WebElement myaddlink;
	
	@FindBy(how=How.XPATH,using="//*[@id='center_column']/h1")
	public WebElement assertvalue;

	public String assertactualvalue="MY ADDRESSES";
	public String aseertexpectedvalue;

}
