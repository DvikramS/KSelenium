package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Base;
import Pages.Address;

public class VerifyAddress{
	
	@Test
	public void verifyAddress(){
		
		Address add=PageFactory.initElements(Base.driver, Address.class);
		add.verifyAddress();
		Assert.assertTrue(add.assertactualvalue.equals(add.aseertexpectedvalue));
	}

}
