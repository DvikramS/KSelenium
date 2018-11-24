package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Base;
import Pages.MyWishList;

public class VerifyMyWishList{

	
	@Test
	public void verifyMyWishLsit(){
		MyWishList wl=PageFactory.initElements(Base.driver, MyWishList.class);
		wl.verifyMyWishList();
		Assert.assertTrue(wl.assertactualvalue.equals(wl.aseertexpectedvalue));
	}
}
