package testScriptsDWS;

import org.testng.annotations.Test;

import com.crm.baseClass.DWSBaseClass;

public class ClickAllTheLinks extends DWSBaseClass {
	
	@Test
	public void testScript() throws InterruptedException {
		System.out.println("TestScript1");
		Thread.sleep(3000);
	}	
	
	@Test
	public void testScript2() throws InterruptedException {
		System.out.println("TestScript2");
		Thread.sleep(3000);
	}
}
