package Tests;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Base;
import Pages.AddAddress;

import Utilities.UtilityFunctions;

public class VerifyAddAddress {	
	
	
	@Test(dataProvider="getDataForVerifyAddAddress")
	public void VerifyAddAddress(Hashtable<String,String> hs){
		Base.data="";
		AddAddress ad=PageFactory.initElements(Base.driver, AddAddress.class);
		ad.addAddress(hs.get("add"), hs.get("city1"), hs.get("zip1"), hs.get("phone1"), hs.get("mobile1"), hs.get("al"));
		Base.data=hs.get("add")+" "+ hs.get("city1")+" "+ hs.get("zip1")+" "+ hs.get("phone1")+" "+ hs.get("mobile1")+" "+ hs.get("al");
		String s="";
		for(int i=0;i<ad.assertvalue.size();i++){
			if(ad.assertvalue.get(i).getText().equalsIgnoreCase(hs.get("al"))){
				s=ad.assertvalue.get(i).getText();
				Assert.assertTrue(s.equalsIgnoreCase((hs.get("al"))));
				
				break;
			}
		}
		
		
		
		
	}
	
	@DataProvider
	public Object[][] getDataForVerifyAddAddress(){
		Object[][]a=UtilityFunctions.getData("VerifyAddAddress", Base.xl);
		return a;
	}
}
