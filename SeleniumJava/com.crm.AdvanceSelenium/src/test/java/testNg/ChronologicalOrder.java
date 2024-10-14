package testNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChronologicalOrder {
	
	@BeforeSuite
	
	@BeforeTest
		
	
	@BeforeClass
	
	@BeforeMethod
	
	@Test
	public void test() {
		System.out.println("this is a test");
	}
	
	@AfterMethod
	
	@AfterClass
	
	@AfterTest
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After suite");
	}
}
