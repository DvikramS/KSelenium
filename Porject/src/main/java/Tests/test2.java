package Tests;

import java.util.Set;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test2 {
	@Test(priority=-1)
	@Parameters("browser")
	public void test3(){
		System.out.println("Test3");
		Set<String> s=Base.Base.driver.getWindowHandles();
		System.out.println(s);
	}

}
