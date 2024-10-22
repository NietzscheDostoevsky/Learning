package practicingDWSListenerExtentReport;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.crm.baseClass.DWSBaseClass;

public class Main1 extends DWSBaseClass {
	
	@Test
	public void main1() {
		driver.get("https://www.redbus.in/");
		driver.navigate().back();
		assertEquals("mobile", "mobil");
	}
}
