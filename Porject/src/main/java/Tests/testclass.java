package Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testclass {
	
	@BeforeSuite
	public void bs(){
		System.out.println("BS");
	}
	@AfterSuite
	public void As(){
		System.out.println("AS");
	}
	@BeforeMethod
	public void bm(){
		System.out.println("BM");
	}
	@AfterMethod
	public void am(){
		System.out.println("AM");
	}
	@BeforeTest
	public void bt(){
		System.out.println("BT");
	}
	@AfterTest
	public void at(){
		System.out.println("AT");
	}
	@BeforeClass
	public void bc(){
		System.out.println("BC");
	}
	
 @AfterClass
 public void ac(){
	 System.out.println("AC");
	
}
 @Test(priority=0)
 public void Test1()
{
	 System.out.println("Test1");}
 @Test(priority=1)
 public void test2(){
	 System.out.println("Test2");
 }
}
