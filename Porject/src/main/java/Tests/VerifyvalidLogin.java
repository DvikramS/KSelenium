package Tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Base;
import Pages.Login;
import Utilities.UtilityFunctions;

public class VerifyvalidLogin {

	
	@Test(dataProvider="getDataForverifyLogin")
	public void verifyLogin(Hashtable<String, String > hs){
		Base.data="";
		//new Base(Base.pr.getProperty("Browser"), Base.pr.getProperty("URL"));
	
			new Base(Base.pr.getProperty("Browser"), Base.pr.getProperty("URL"));
		
		Login login=PageFactory.initElements(Base.driver, Login.class);
		login.verifyLogin(hs.get("username"), hs.get("password"));
		Base.data=hs.get("username")+hs.get("password");
		Assert.assertTrue(Login.assertactualvalue.equals(Login.assertexpected));
	}
	
	@DataProvider
	public Object[][] getDataForverifyLogin(){
		Object[][] a=UtilityFunctions.getData("verifyLogin", Base.xl);
		return a;
	}
	
	@AfterSuite
	public void cleanup(){
		Base.driver.close();
	}
	
	
	

}
