package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Base.Base;

public class MyWishList {
	
	public MyWishList(){
		Base.log=Logger.getLogger("MyWishList");
	}

	@FindBy(how=How.XPATH, using="//*[text()='dhirendra Vikram']")
	WebElement menu;
	
	@FindBy(how=How.XPATH,using="//*[text()='My wishlists']")
	WebElement mywishlink;
	
	@FindBy(how=How.XPATH,using="//*[@id='mywishlist']/h1")
	WebElement assertvalue;

	public String assertactualvalue="MY WISHLISTS";
	public String aseertexpectedvalue;
	
	
	public void verifyMyWishList(){
		menu.click();
		Base.log.info("menu Clicked");
		mywishlink.click();
		Base.log.info("mywishlink Clicked");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aseertexpectedvalue=assertvalue.getText();
		System.out.println(aseertexpectedvalue);
		Base.log.info("assert captured");
	}
}
